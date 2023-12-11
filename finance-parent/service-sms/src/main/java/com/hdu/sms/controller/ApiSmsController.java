package com.hdu.sms.controller;

import cn.hutool.core.lang.Assert;
import com.hdu.finance.client.CustomerClient;
import com.hdu.finance.common.domain.common.Result;
import com.hdu.finance.common.domain.common.ResultCodeEnum;
import com.hdu.finance.common.utils.RandomUtils;
import com.hdu.finance.common.utils.RegexValidateUtils;
import com.hdu.sms.service.SmsService;
import com.hdu.sms.uitl.SmsProperties;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/sms")
@Api(tags = "短信管理")
@Slf4j
public class ApiSmsController {
    @Resource
    private SmsService smsService;

    @Resource
    private RedisTemplate redisTemplate;

    @Resource
    private CustomerClient customerClient;

    @ApiOperation("获取验证码")
    @GetMapping("/send/{mobile}")
    public Result send(
            @ApiParam(value = "手机号", required = true)
            @PathVariable String mobile){

        //校验手机号吗不能为空
        Assert.notEmpty(mobile,  String.valueOf(ResultCodeEnum.MOBILE_NULL_ERROR));
        //是否是合法的手机号码
        Assert.isTrue(RegexValidateUtils.checkCellphone(mobile), String.valueOf(ResultCodeEnum.MOBILE_ERROR));

        //判断手机号是否已经注册
        boolean result = customerClient.checkMobile(mobile);
        log.info("result = " + result);
        Assert.isTrue(result == false, String.valueOf(ResultCodeEnum.MOBILE_EXIST_ERROR));

        String code = RandomUtils.getFourBitRandom();
        HashMap<String, String> map = new HashMap<>();
        map.put("code", code);
        return smsService.send(mobile,map);

    }
}
