package com.hdu.finance.common.domain.query;

import com.hdu.finance.common.domain.common.PageQuery;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class FundQuery extends PageQuery {
    /**
     * 中文简称缩写
     */
    @ApiModelProperty("中文简称缩写")
    private String chiNameAbbr;
    /**
     * 基金类型
     */
    @ApiModelProperty("基金类型")
    private String fundType;
    /**
     * 基金代码
     */
    @ApiModelProperty("基金代码")
    private String fundCode;
}
