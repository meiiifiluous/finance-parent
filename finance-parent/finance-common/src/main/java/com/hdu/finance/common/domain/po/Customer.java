package com.hdu.finance.common.domain.po;

import com.baomidou.mybatisplus.annotation.*;

import java.time.LocalDateTime;
import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;
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
@TableName("c_customer")
public class Customer implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "客户号")
    @TableField("customer_id")
    private String customerId;

    @ApiModelProperty(value = "绑定邮箱")
    @TableField("email")
    private String email;

    @ApiModelProperty(value = "证件号码")
    @TableField("identity_number")
    private String identityNumber;

    @ApiModelProperty(value = "证件类型")
    @TableField("identity_typer")
    private String identityTyper;

    @ApiModelProperty(value = "绑定手机")
    @TableField("mobile")
    private String mobile;

    @ApiModelProperty(value = "真实姓名")
    @TableField("real_name")
    private String realName;

    @ApiModelProperty(value = "用户状态(0-异常，1-正常）")
    @TableField("status")
    private Integer status;

    @ApiModelProperty(value = "创建人")
    @TableField("create_by")
    private String createBy;

    @ApiModelProperty(value = "创建时间")
    @TableField("create_time")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "修改人")
    @TableField("update_by")
    private String updateBy;

    @ApiModelProperty(value = "修改时间")
    @TableField("update_time")
    private LocalDateTime updateTime;

    @ApiModelProperty(value = "投资类型（1-保守型，2-稳健型，3-激进型）")
    @TableField("investment_type")
    private Integer investmentType;

    @TableField("is_deleted")
    private Boolean isDeleted;

    @ApiModelProperty(value = "反洗钱标志")
    @TableField("aml_flag")
    private String amlFlag;


}
