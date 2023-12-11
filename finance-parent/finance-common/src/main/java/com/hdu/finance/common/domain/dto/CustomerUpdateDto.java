package com.hdu.finance.common.domain.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class CustomerUpdateDto {

    private Long id;
    /**
     * 绑定邮箱
     */
    @ApiModelProperty("绑定邮箱")
    private String email;
    /**
     * 绑定手机
     */
    @ApiModelProperty("绑定手机")
    private String mobile;
    /**
     * 投资类型（1-保守型，2-稳健型，3-激进型）
     */
    @ApiModelProperty("投资类型（1-保守型，2-稳健型，3-激进型）")
    private Integer investmentType;
}
