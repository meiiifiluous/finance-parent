package com.hdu.finance.common.domain.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@ApiModel("历史净值")
public class HistoryNetvalue {
    private LocalDate currDate;
    /**
     * 基金单位净值，表示每个基金份额的当前净值
     */
    @TableField("netvalue")
    private BigDecimal netvalue;

    /**
     * 总净值，表示基金的总净值
     */
    @TableField("total_netvalue")
    private BigDecimal totalNetvalue;
    /**
     * 涨跌幅百分比
     */
    @TableField("percent")
    private BigDecimal percent;
}
