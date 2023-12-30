package com.hdu.finance.common.domain.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class CustomerDto {
    private Long id;
    /**
     * 绑定邮箱
     */
    @ApiModelProperty("绑定邮箱")
    private String email;

    /**
     * 客户号
     */
    @ApiModelProperty("客户号")
    private String customerId;
    /**
     * 绑定手机
     */
    @ApiModelProperty("绑定手机")
    private String mobile;

    /**
     * 真实姓名
     */
    @ApiModelProperty("真实姓名")
    private String realName;
    /**
     * 证件类型
     */
    @ApiModelProperty("证件类型")
    private String identityTyper;
    /**
     * 证件号码
     */
    @ApiModelProperty("证件号码")
    private String identityNumber;

    /**
     * 投资类型（1-保守型，2-稳健型，3-激进型）
     */
    @ApiModelProperty("投资类型（1-保守型，2-稳健型，3-激进型）")
    private Integer investmentType;
}
