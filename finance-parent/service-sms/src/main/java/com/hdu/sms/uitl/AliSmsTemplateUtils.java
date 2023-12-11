package com.hdu.sms.uitl;

import cn.hutool.json.JSONUtil;
import com.aliyun.auth.credentials.Credential;
import com.aliyun.auth.credentials.provider.StaticCredentialProvider;
import com.aliyun.sdk.service.dysmsapi20170525.AsyncClient;
import com.aliyun.sdk.service.dysmsapi20170525.models.SendSmsRequest;
import com.aliyun.sdk.service.dysmsapi20170525.models.SendSmsResponse;
import com.aliyun.sdk.service.dysmsapi20170525.models.SendSmsResponseBody;
import darabonba.core.client.ClientOverrideConfiguration;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.HashMap;
import java.util.concurrent.CompletableFuture;

@Data
@AllArgsConstructor
@Slf4j
public class AliSmsTemplateUtils {

    /**
     * 发送登录验证码
     *
     * @param phone 手机号
     * @return true-发送成功，false-发送失败
     */
    public boolean sendLoginCode(String phone, String code){
        // 配置凭据身份验证信息，包括 accessKeyId 与 accessKeySecret
        StaticCredentialProvider provider = StaticCredentialProvider.create(Credential.builder()
                .accessKeyId(SmsProperties.KEY_ID)
                .accessKeySecret(SmsProperties.KEY_SECRET)
                .build());

        // 客户端配置
        AsyncClient client = AsyncClient.builder()
                .region("cn-hangzhou")
                .credentialsProvider(provider)
                .overrideConfiguration(
                        ClientOverrideConfiguration.create()
                                // 访问的域名，不要修改
                                .setEndpointOverride("dysmsapi.aliyuncs.com")
                                // 设置超时时长
                                .setConnectTimeout(Duration.ofSeconds(30))
                )
                .build();

        // 请求参数设置
        HashMap<String, String> contentParam = new HashMap<>();
        contentParam.put("code",code);
        SendSmsRequest sendSmsRequest = SendSmsRequest.builder()
                .signName(SmsProperties.SIGN_NAME)
                .templateCode(SmsProperties.TEMPLATE_CODE)
                .phoneNumbers(phone)
                .templateParam(JSONUtil.toJsonStr(contentParam))
                .build();

        CompletableFuture<SendSmsResponse> response = null;

        try {
            // 异步获取API请求的返回值
            response = client.sendSms(sendSmsRequest);

            // 同步获取API请求的返回值
            SendSmsResponseBody body = response.get().getBody();
            // 判断是否发送成功
            if ("OK".equalsIgnoreCase(body.getCode())){
                return true;
            }else{
                return false;
            }
        } catch (Exception e) {
            // 日志记录
            log.error("发送登录短信验证码发生异常：{}",e.getMessage());
            // 存入 mysql
            return false;
        } finally {
            // 关闭客户端
            client.close();
        }


    }
}
