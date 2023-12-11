package com.funcsales.po;

import java.io.Serial;
import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDate;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableName;
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
@TableName("fundnav")
public class Fundnav implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 基金代码
     */
    private String fundCode;

    /**
     * 当前日期
     */
    private LocalDate currDate;

    /**
     * 基金单位净值，表示每个基金份额的当前净值
     */
    private BigDecimal netvalue;

    /**
     * 总净值，表示基金的总净值
     */
    private BigDecimal totalNetvalue;

    /**
     * 涨跌幅百分比
     */
    private BigDecimal percent;

    /**
     * 1个月收益率
     */
    private BigDecimal yield1m;

    /**
     * 3个月收益率
     */
    private BigDecimal yield3m;

    /**
     * 6个月收益率
     */
    private BigDecimal yield6m;

    /**
     * 12个月收益率
     */
    private BigDecimal yield12m;

    /**
     *  今年收益率
     */
    private BigDecimal yieldThisYear;

    /**
     * 三年内收益率
     */
    private BigDecimal cgs3Year;

    /**
     *  是否在销售（1-在，0不在）
     */
    private Integer okSale;

    /**
     * 基金管理费
     */
    private String fundManagementFees;

    /**
     * 基金托管费
     */
    private String fundTrusteeFees;

    /**
     * 创建时间
     */
    private LocalDateTime crateTime;

    /**
     * 修改时间
     */
    private LocalDateTime updateTime;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private Boolean isDeleted;


}
