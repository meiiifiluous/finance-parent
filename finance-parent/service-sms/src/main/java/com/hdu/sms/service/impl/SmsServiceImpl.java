package com.hdu.sms.service.impl;

import cn.hutool.core.lang.Assert;
import com.aliyun.auth.credentials.Credential;
import com.aliyun.auth.credentials.provider.StaticCredentialProvider;
import com.aliyun.sdk.service.dysmsapi20170525.AsyncClient;
import com.aliyun.sdk.service.dysmsapi20170525.models.SendSmsRequest;
import com.aliyun.sdk.service.dysmsapi20170525.models.SendSmsResponse;
import com.google.gson.Gson;
import com.hdu.finance.common.domain.common.Result;
import com.hdu.finance.common.domain.common.ResultCodeEnum;
import com.hdu.finance.common.exception.BusinessException;
import com.hdu.sms.service.SmsService;
import com.hdu.sms.uitl.AliSmsTemplateUtils;
import com.hdu.sms.uitl.SmsProperties;
import darabonba.core.client.ClientOverrideConfiguration;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.rmi.ServerException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

@Service
@Slf4j
public class SmsServiceImpl implements SmsService {
    @Resource
    private RedisTemplate<String,String> redisTemplate;
    @Override
    public Result send(String mobile, Map<String, String> param) {
        AliSmsTemplateUtils aliSmsTemplateUtils = new AliSmsTemplateUtils();
        //查看缓存中是否已经存在
        String key = "finance:sms:code:" + mobile;
        Long expire = redisTemplate.getExpire(key);
        if(expire > 0){
            return Result.build(null,701,"发送失败，验证码仍在有效期内");
        }
        boolean success = aliSmsTemplateUtils.sendLoginCode(mobile, param.get("code"));
        // 7.返回
        if (!success){
            // 移除redis中的缓存记录
            redisTemplate.delete(key);
            return Result.build(null,700,"短息发送失败");
        }
        //将验证码存入redis
        redisTemplate.opsForValue().set("finance:sms:code:" + mobile, param.get("code"), 5, TimeUnit.MINUTES);
        return Result.build(null,ResultCodeEnum.SUCCESS);
    }
}
