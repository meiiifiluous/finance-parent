package com.hdu.finance.common.domain.po;

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
 * @since 2023-11-01
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("c_bank")
public class Bank implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 银行编码
     */
    private String bankCode;

    /**
     * 银行名称
     */
    private String bankName;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 英文名
     */
    private String enName;

    /**
     * 状态
     */
    private String status;

    /**
     * 修改时间
     */
    private LocalDateTime updateTime;

    /**
     * 删除标记（0:未删除 1:已删除）
     */
    @TableLogic
    private Boolean isDeleted;


}
