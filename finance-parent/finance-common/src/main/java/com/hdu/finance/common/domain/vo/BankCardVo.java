package com.hdu.finance.common.domain.vo;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class BankCardVo {

    private Long id;
    /**
     * 银行卡号
     */
    private String bankCardNo;

    /**
     * 银行编码
     */
    private String bankCode;


    /**
     * 卡类型（0-借记卡，1-贷记卡）
     */
    private Integer bankType;


    /**
     * 银行名称
     */
    private String bankName;

}
