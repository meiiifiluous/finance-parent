package com.hdu.finance.common.domain.po;

import java.math.BigDecimal;

import com.baomidou.mybatisplus.annotation.*;

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
@TableName("p_fund")
public class Fund implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 最低申购金额
     */
    @TableField(value = "min_apply_amount")
    private BigDecimal minApplyAmount;

    /**
     * 最低赎回金额
     */
    @TableField(value = "lowest_redemption")
    private BigDecimal lowestRedemption;

    /**
     * 一年内收益率
     */
    @TableField(value = "one_year_profit")
    private BigDecimal oneYearProfit;

    /**
     * 一周内收益率
     */
    @TableField("one_week_profit")
    private BigDecimal oneWeekProfit;


    /**
     * 申购状态（0-可申购，1-不可申购）
     */
    @TableField("is_apply")
    private Boolean isApply;

    /**
     * 赎回状态（0-可赎回，1-不可赎回）
     */
    @TableField("is_redemption")
    private Boolean isRedemption;

    /**
     * 产品状态（0-正常，1-异常）
     */
    @TableField("product_status")
    private Integer productStatus;

    /**
     * 创建时间
     */
    @TableField("create_time")
    private LocalDateTime createTime;

    /**
     * 修改时间
     */
    @TableField("update_time")
    private LocalDateTime updateTime;

    /**
     * 更新者
     */
    @TableField("update_by")
    private String updateBy;

    /**
     * 创建者
     */
    @TableField("create_by")
    private String createBy;

    /**
     * 公司名称
     */
    @TableField("company_name")
    private String companyName;

    /**
     * 基金中文名称
     */
    @TableField("chi_name")
    private String chiName;

    /**
     * 中文简称缩写
     */
    @TableField("chi_name_abbr")
    private String chiNameAbbr;

    /**
     * 基金规模
     */
    @TableField("fund_scale")
    private BigDecimal fundScale;

    /**
     * 基金类型
     */
    @TableField("fund_type")
    private String fundType;

    /**
     * 投资期限
     */
    @TableField("invest_period")
    private String investPeriod;

    /**
     * 费用
     */
    @TableField("charge")
    private Integer charge;


    /**
     * 风险级别
     */
    @TableField("risk_level")
    private Integer riskLevel;

    /**
     * 基金代码
     */
    @TableField("fund_code")
    private String fundCode;

    /**
     * 初始购买的份额数量
     */
    @TableField("init_buyed_count")
    private Long initBuyedCount;

    /**
     * 购买份额数量
     */
    @TableField("buyed_count")
    private BigDecimal BuyedCount;

    /**
     *  投资领域
     */
    @TableField("investment_field")
    private String investmentField;


    /**
     * 基金描述
     */
    @TableField("description")
    private String description;

    /**
     * 逻辑删除(1:已删除，0:未删除)
     */
    @TableField("is_deleted")
    @TableLogic
    private Integer isDeleted;

    /**
     * 基金经理
     */
    @TableField("fund_manager")
    private String fundManager;


}
