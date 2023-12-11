package com.hdu.finance.common.domain.po;

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
 * @since 2023-10-31
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Dict implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String codeCat;

    private String codeKey;

    private String codeVal;

    private Integer seqNo;

    private String createBy;

    private LocalDateTime createTime;

    private String status;

    private String sysInd;

    private String magic;

    private String remarks;

    private LocalDateTime updateTime;

    private Integer isDeleted;


}
