package com.funcsales.po;

import java.io.Serial;
import java.math.BigDecimal;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
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
 * @author 
 * @since 2023-11-07
 */
@Data
@TableName("c_bank_card")
public class BankCard implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 银行卡号
     */
    @TableField("bank_card_no")
    private String bankCardNo;

    /**
     * 银行编码
     */
    @TableField("bank_code")
    private String bankCode;

    /**
     * 状态（0-冻结，1正常）
     */
    @TableField("status")
    private Integer status;

    /**
     * 卡类型（0-借记卡，1-贷记卡）
     */
    @TableField("bank_type")
    private Integer bankType;

    /**
     * 创建时间
     */
    @TableField("create_time")
    private LocalDateTime createTime;

    /**
     * 客户号
     */
    @TableField("customer_id")
    private String customerId;

    /**
     * 修改时间
     */
    @TableField("update_time")
    private LocalDateTime updateTime;

    /**
     * 银行id
     */
    @TableField("bank_id")
    private Long bankId;

    /**
     * 逻辑删除(1:已删除，0:未删除) 
     */
    @TableField("is_deleted")
    private Boolean isDeleted;

    /**
     * 账户余额
     */
    @TableField("account_balance")
    private BigDecimal accountBalance;


}
