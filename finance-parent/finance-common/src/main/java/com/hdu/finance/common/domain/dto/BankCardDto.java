package com.hdu.finance.common.domain.dto;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.Data;

@Data
public class BankCardDto {
    /**
     * 银行卡号
     */
    @ApiModelProperty("银行卡号")
    private String bankCardNo;
    /**
     * 银行名称
     */
    private String bankName;
    /**
     * 卡类型（0-借记卡，1-贷记卡）
     */
    private Integer bankType;
    /**
     * 客户姓名
     */
    private String customerName;

}
