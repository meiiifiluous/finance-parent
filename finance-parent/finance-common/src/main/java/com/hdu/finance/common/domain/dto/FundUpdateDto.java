package com.hdu.finance.common.domain.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data

public class FundUpdateDto {

    private Long id;
    /**
     * 最低申购金额
     */
    @ApiModelProperty("最低申购金额")
    private BigDecimal minApplyAmount;

    /**
     * 最低赎回金额
     */
    @ApiModelProperty("最低赎回金额")
    private BigDecimal lowestRedemption;

    /**
     * 一年内收益率
     */
    @ApiModelProperty("一年内收益率")
    private BigDecimal oneYearProfit;


    /**
     * 公司名称
     */
    @ApiModelProperty("公司名称")
    private String companyName;

    /**
     * 基金中文名称
     */
    @ApiModelProperty("基金中文名称")
    private String chiName;

    /**
     * 中文简称缩写
     */
    @ApiModelProperty("中文简称缩写")
    private String chiNameAbbr;

    /**
     * 基金规模
     */
    @ApiModelProperty("基金规模")
    private String fundScale;

    /**
     * 基金类型
     */
    @ApiModelProperty("基金类型")
    private String fundType;

    /**
     * 投资期限
     */
    @ApiModelProperty("投资期限")
    private String investPeriod;


    /**
     * 风险级别
     */
    @ApiModelProperty("风险级别")
    private String riskLevel;

    /**
     * 基金代码
     */
    @ApiModelProperty("基金代码")
    private String fundCode;

    /**
     * 初始购买的份额数量
     */
    @ApiModelProperty("初始购买的份额数量")
    private Long initBuyedCount;


    /**
     *  投资领域
     */
    @ApiModelProperty("投资领域")
    private String investmentField;

    /**
     * 基金描述
     */
    @ApiModelProperty("基金描述")
    private String description;

    /**
     * 基金经理
     */
    @ApiModelProperty("基金经理")
    private String fundManager;
}
