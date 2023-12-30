package com.hdu.finance.common.domain.po;

import java.io.Serial;
import java.math.BigDecimal;

import com.baomidou.mybatisplus.annotation.*;

import java.time.LocalDateTime;
import java.io.Serializable;

import lombok.Data;


/**
 * <p>
 *
 * </p>
 *
 * @author
 * @since 2023-11-07
 */
@Data
@TableName("t_trade")
public class Trade implements Serializable {

    /**
     * 交易主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 交易流水号
     */
    private String tradeNo;

    /**
     * 手续费
     */
    private BigDecimal fee;

    /**
     * 1:申购 2:赎回 3:分红
     */
    private Integer type;

    /**
     * 0-不需发送；1-待确认；2-确认完成；3-确认失败
     */
    private Integer confirmStatus;

    /**
     * 下单时间
     */
    private LocalDateTime tradeTime;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 预计确认时间
     */
    private LocalDateTime updateTime;

    /**
     * 客户号
     */
    private String custId;

    /**
     * 银行卡号
     */
    private String bankCardNo;

    /**
     * /**
     * 银行名称
     */
    private String bankName;

    /**
     * 交易状态（1.正常，0.不正常）
     */
    private String payStatus;

    /**
     * 申赎金额;
     */
    private BigDecimal tradeAmount;
    /**
     * 产品编码
     */
    private String productCode;

    /**
     * 产品名称
     */
    private String productName;

    /**
     * 产品单价
     */
    private BigDecimal productPrice;

    /**
     * 数量
     */
    private BigDecimal quantity;

    private Integer isDeleted;
}
