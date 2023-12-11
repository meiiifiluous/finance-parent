package com.funcsales.po;

import java.io.Serial;
import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableId;
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
@TableName("p_fund")
public class Fund implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 最低申购金额
     */
    private BigDecimal minApplyAmount;

    /**
     * 最低赎回金额
     */
    private BigDecimal lowestRedemption;

    /**
     * 一年内收益率
     */
    private BigDecimal oneYearProfit;

    /**
     * 一周内收益率
     */
    private BigDecimal oneWeekProfit;

    /**
     * 申购状态（0-可申购，1-不可申购）
     */
    private Boolean isApply;

    /**
     * 赎回状态（0-可赎回，1-不可赎回）
     */
    private Boolean isRedemption;

    /**
     * 产品状态（0-正常，1-异常）
     */
    private Boolean productStatus;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 修改时间
     */
    private LocalDateTime updateTime;

    /**
     * 更新者
     */
    private String updateBy;

    /**
     * 创建者
     */
    private String createBy;

    /**
     * 公司名称
     */
    private String companyName;

    /**
     * 基金中文名称
     */
    private String chiName;

    /**
     * 中文简称缩写
     */
    private String chiNameAbbr;

    /**
     * 基金规模
     */
    private BigDecimal fundScale;

    /**
     * 基金类型
     */
    private String fundType;

    /**
     * 投资期限
     */
    private String investPeriod;

    /**
     * 费用
     */
    private Integer charge;

    /**
     * 账户类型
     */
    private String toAccountType;

    /**
     * 风险级别（1-低风险，2-中低风险，3-中高风险，4-高风险）
     */
    private Integer riskLevel;

    /**
     * 基金代码
     */
    private String fundCode;

    /**
     * 初始购买的份额数量
     */
    private Long initBuyedCount;

    /**
     * 购买份额数量
     */
    private BigDecimal BuyedCount;

    /**
     *  投资领域
     */
    private String investmentField;

    /**
     * 基金描述
     */
    private String description;

    /**
     * 逻辑删除(1:已删除，0:未删除)
     */
    private Integer isDeleted;

    /**
     * 基金经理
     */
    private String fundManager;


}
