package com.hdu.finance.common.domain.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class FundVo {

    private Long id;

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
    private String fundScale;

    /**
     * 基金类型
     */
    private String fundType;

    /**
     * 投资期限
     */
    private String investPeriod;


    /**
     * 风险级别
     */
    private String riskLevel;

    /**
     * 基金代码
     */
    private String fundCode;

    /**
     * 费用
     */
    private Integer charge;

    /**
     * 投资领域
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
