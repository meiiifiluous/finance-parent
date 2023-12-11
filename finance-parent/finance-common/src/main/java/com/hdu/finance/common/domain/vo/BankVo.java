package com.hdu.finance.common.domain.vo;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class BankVo {

    private Long id;

    /**
     * 银行编码
     */
    private String bankCode;

    /**
     * 银行名称
     */
    private String bankName;


    /**
     * 英文名
     */
    private String enName;
}
