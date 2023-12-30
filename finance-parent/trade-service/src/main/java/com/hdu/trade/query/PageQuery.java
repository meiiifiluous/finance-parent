package com.hdu.trade.query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "分页查询实体")
public class PageQuery<T> {
    @ApiModelProperty("页码")
    private Integer pageNo;
    @ApiModelProperty("每页条数")
    private Integer pageSize;
    @ApiModelProperty("排序字段")
    private String sortBy;
    @ApiModelProperty("是否升序")
    private Boolean isAsc;

}
