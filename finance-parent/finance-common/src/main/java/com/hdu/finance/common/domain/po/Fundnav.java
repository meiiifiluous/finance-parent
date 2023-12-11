package com.hdu.finance.common.domain.po;

import java.math.BigDecimal;

import com.baomidou.mybatisplus.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 *
 * </p>
 *
 * @author vvc
 * @since 2023-10-31
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("fundnav")
public class Fundnav implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 基金代码
     */
    @TableField("fund_code")
    private String fundCode;

    /**
     * 当前日期
     */
    @TableField("curr_date")
    private LocalDate currDate;

    /**
     * 基金单位净值，表示每个基金份额的当前净值
     */
    @TableField("netvalue")
    private BigDecimal netvalue;

    /**
     * 总净值，表示基金的总净值
     */
    @TableField("total_netvalue")
    private BigDecimal totalNetvalue;

    /**
     * 涨跌幅百分比
     */
    @TableField("percent")
    private BigDecimal percent;


    /**
     * 1个月收益率
     */
    @TableField("yield_1m")
    private BigDecimal yield1m;

    /**
     * 3个月收益率
     */
    @TableField("yield_3m")
    private BigDecimal yield3m;

    /**
     * 6个月收益率
     */
    @TableField("yield_6m")
    private BigDecimal yield6m;

    /**
     * 12个月收益率
     */
    @TableField("yield_12m")
    private BigDecimal yield12m;

    /**
     *  今年收益率
     */
    @TableField("yield_this_year")
    private BigDecimal yieldThisYear;

    /**
     * 三年内收益率
     */
    @TableField("cgs_3_year")
    private BigDecimal cgs3Year;

    /**
     *  是否在销售（1-在，0不在）
     */
    @TableField("ok_sale")
    private Integer okSale;

    /**
     * 基金管理费
     */
    @TableField("fund_management_fees")
    private String fundManagementFees;

    /**
     * 基金托管费
     */
    @TableField("fund_trustee_fees")
    private String fundTrusteeFees;

    /**
     * 创建时间
     */
    @TableField("crate_time")
    private LocalDateTime crateTime;

    /**
     * 修改时间
     */
    @TableField("update_time")
    private LocalDateTime updateTime;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    @TableField("is_deleted")
    @TableLogic
    private Integer isDeleted;


}
