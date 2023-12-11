package com.funcsales.po;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;

import java.io.Serial;
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
@TableName("c_bank")
public class Bank implements Serializable {

    @Serial
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
    private Boolean isDeleted;


}
