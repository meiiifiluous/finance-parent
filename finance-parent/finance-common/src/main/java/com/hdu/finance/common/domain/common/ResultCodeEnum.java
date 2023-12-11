package com.hdu.finance.common.domain.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter // 提供获取属性值的getter方法
@AllArgsConstructor
@ToString
public enum ResultCodeEnum {

    SUCCESS(200 , "操作成功") ,
    SAVE_ERROR(201 , "新增失败"),
    FUND_CODE_IS_EXISTS(202 , "基金代码已存在！"),
    FUND_IS_NOT_EXISTS(203 , "基金不存在！"),

    LOGIN_AUTH(208 , "用户未登录"),
    USER_NAME_IS_EXISTS(209 , "用户名已经存在"),
    SYSTEM_ERROR(9999 , "您的网络有问题请稍后重试"),
    NODE_ERROR( 217, "该节点下有子节点，不可以删除"),
    DATA_ERROR(204, "数据异常"),
    ACCOUNT_STOP( 216, "账号已停用"),

    STOCK_LESS( 219, "库存不足"),
    MOBILE_NULL_ERROR(-220,"手机号为空"),
    MOBILE_ERROR(-221,"手机号码不正确"),
    MOBILE_EXIST_ERROR(-222,"手机号已被注册"),
    ALIYUN_RESPONSE_ERROR(-501, "阿里云短信服务响应失败"),
    ALIYUN_SMS_LIMIT_CONTROL_ERROR(-502, "短信发送过于频繁"),//业务限流
    ALIYUN_SMS_ERROR(-503, "短信发送失败"),//其他失败
    ;

    private Integer code ;      // 业务状态码
    private String message ;    // 响应消息


}
