package com.hdu.finance.common.domain.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@ApiModel("基金收益返回对象")
public class FundnavVo {
    @ApiModelProperty("近一周涨跌幅")
    private BigDecimal oneWeekReturn;
    @ApiModelProperty("日涨跌幅")
    private BigDecimal percent;
    @ApiModelProperty("近一个月涨跌幅")
    private BigDecimal yield1m;
    @ApiModelProperty("近三个月涨跌幅")
    private BigDecimal yield3m;
    @ApiModelProperty("近6个月涨跌幅")
    private BigDecimal yield6m;
    @ApiModelProperty("近12个月涨跌幅")
    private BigDecimal yield12m;
    @ApiModelProperty("历史净值列表")
    private List<HistoryNetvalue> HistoryNetvalueList;
    @ApiModelProperty("最近一天净值")
    private BigDecimal netvalue;
    @ApiModelProperty("近一年涨跌幅")
    private BigDecimal yieldThisYear;
    @ApiModelProperty("近三年涨跌幅")
    private BigDecimal cgs3Year;
}
