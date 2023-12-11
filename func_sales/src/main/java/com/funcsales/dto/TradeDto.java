package com.funcsales.dto;

import java.math.BigDecimal;

import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import lombok.Data;


/**
 * @since 2023-11-07
 */
@Data
@ApiModel(description = "交易输入条件")
public class TradeDto {
    /**
     * 手续费
     */
    private BigDecimal fee;

    /**
     *  1:申购 2:赎回 3:分红
     */
    private Integer type;
    /**
     * 下单时间
     */
    private LocalDateTime tradeTime;
    /**
     * 客户身份证号
     */
    private String identityNumber;

    /**
     *  银行卡号
     */
    private String bankCardNo;
    /**
     * 申赎金额
     */
    private BigDecimal tradeAmount;

    /**
     * 产品编码
     */
    private String productCode;

}
