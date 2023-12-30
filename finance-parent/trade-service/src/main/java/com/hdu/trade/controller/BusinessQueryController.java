package com.hdu.trade.controller;


import com.hdu.finance.common.domain.common.Result;
import com.hdu.finance.common.domain.common.ResultCodeEnum;
import com.hdu.finance.common.domain.po.CustomerErrorLog;
import com.hdu.finance.common.domain.vo.BankCardVo;
import com.hdu.finance.common.domain.vo.CustomerVo;
import com.hdu.finance.common.domain.vo.FundVo;
import com.hdu.finance.common.domain.vo.TradeVo;
import com.hdu.finance.common.exception.BusinessException;
import com.hdu.trade.dto.PageDto;
import com.hdu.trade.query.TradeQuery;
import com.hdu.trade.service.TradeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/businessquery")
@Api(tags = "业务查询接口")
public class BusinessQueryController {
    @Autowired
    private TradeService tradeService;

    @ApiOperation("根据条件分页查询交易记录")
    //根据条件分页查询交易记录
    @PostMapping("/query")
    public Result queryTrade(@RequestBody TradeQuery query) {
        return tradeService.queryTrade(query);
    }

    @ApiOperation("撤销未确认的申请")
    //撤销未确认的申请
    @DeleteMapping("/delete")
    public Result cancelTrade(@RequestBody TradeVo tradeVo) {
        boolean isSuccess = tradeService.deleteTrade(tradeVo);
        if (isSuccess) {
            return Result.build(null, ResultCodeEnum.SUCCESS);
        } else {
            throw new BusinessException("撤销申请失败!");
        }
    }


}






