package com.hdu.trade.query;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "订单查询实体")
public class TradeQuery extends PageQuery{
    @ApiModelProperty("身份证号")
    private String identityNumber;
    @ApiModelProperty("银行卡号")
    private String bankCardNo;
    @ApiModelProperty("基金代码")
    private String fundCode;
    @ApiModelProperty("基金名称")
    private String productName;
    @ApiModelProperty("交易类型")
    private Integer type;
    @ApiModelProperty("确认情况")
    private Integer confirmStatus;

}
