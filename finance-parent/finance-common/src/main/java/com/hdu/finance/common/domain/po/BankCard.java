package com.hdu.finance.common.domain.po;

import com.baomidou.mybatisplus.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.io.Serializable;

import io.swagger.models.auth.In;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 *
 * </p>
 *
 * @author vvc
 * @since 2023-11-01
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("c_bank_card")
public class BankCard implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 银行卡号
     */
    private String bankCardNo;

    /**
     * 银行编码
     */
    private String bankCode;

    /**
     * 状态（0-冻结，1正常）
     */
    private Integer status;

    /**
     * 卡类型（0-借记卡，1-贷记卡）
     */
    private Integer bankType;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 客户号
     */
    private String customerId;

    /**
     * 修改时间
     */
    private LocalDateTime updateTime;

    /**
     * 银行id
     */
    private Long bankId;

    /**
     * 逻辑删除(1:已删除，0:未删除)
     */
    @TableLogic
    private Integer isDeleted;

    /**
     * 账户余额
     */
    @TableField("account_balance")
    private BigDecimal accountBalance;


}
