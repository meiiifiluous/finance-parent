package com.hdu.finance.common.domain.po;

import java.io.Serial;
import java.math.BigDecimal;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 *
 * </p>
 *
 * @author
 * @since 2023-11-10
 */
@Data
@TableName("f_holdcapital")
public class Holdcapital implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 客户号
     */
    private String customerId;

    /**
     * 持有资产
     */
    private BigDecimal holdCapital;


    /**
     * 产品编码
     */
    private String productCode;

    /**
     * 产品名称
     */
    private String productName;

    /**
     * 状态
     */
    private String status;

    /**
     * 累计收益
     */
    private BigDecimal totalProfit;

    /**
     * 申赎资产
     */
    private BigDecimal tradeAmount;

    /**
     * 修改时间
     */
    private LocalDateTime updateTime;

    /**
     * 昨日收益
     */
    private BigDecimal yesterdayProfit;

    /**
     * 产品类型
     */
    private String productType;

    private Integer isDeleted;
    /**
     * 银行卡号
     */
    @TableField("bank_card_no")
    private String bankCardNo;
}
