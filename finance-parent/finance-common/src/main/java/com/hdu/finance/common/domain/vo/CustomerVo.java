package com.hdu.finance.common.domain.vo;

import lombok.Data;

@Data
public class CustomerVo {
    private Long id;

    /**
     * 客户号
     */
    private String customerId;

    /**
     * 绑定邮箱
     */
    private String email;

    /**
     * 证件号码
     */
    private String identityNumber;

    /**
     * 证件类型
     */
    private String identityTyper;

    /**
     * 绑定手机
     */
    private String mobile;

    /**
     * 真实姓名
     */
    private String realName;
    /**
     * 投资类型（1-保守型，2-稳健型，3-激进型）
     */
    private Integer investmentType;
}
