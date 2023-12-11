package com.hdu.finance.common.domain.po;

import com.baomidou.mybatisplus.annotation.TableLogic;
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

    /**
     * 客户号
     */
    private String customerId;

    /**
     * 绑定邮箱
     */
    private String email;

    /**
     * 证件号码
     */
    private String identityNumber;

    /**
     * 证件类型
     */
    private String identityTyper;

    /**
     * 绑定手机
     */
    private String mobile;

    /**
     * 真实姓名
     */
    private String realName;

    /**
     * 用户状态(0-异常，1-正常）
     */
    private Integer status;

    /**
     * 创建人
     */
    private String createBy;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 修改人
     */
    private String updateBy;

    /**
     * 修改时间
     */
    private LocalDateTime updateTime;

    /**
     * 投资类型（1-保守型，2-稳健型，3-激进型）
     */
    private Integer investmentType;
    @TableLogic
    private Integer isDeleted;


}
