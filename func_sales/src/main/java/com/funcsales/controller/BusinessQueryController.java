package com.funcsales.controller;

import com.funcsales.dto.PageDto;
import com.funcsales.query.TradeQuery;

import com.funcsales.service.CustomerService;
import com.funcsales.service.FundnavService;
import com.funcsales.service.TradeService;
import com.funcsales.vo.TradeVo;
import io.swagger.annotations.Api;
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
    @Autowired
    private CustomerService customerService;
    @Autowired
    private FundnavService fundnavService;
    //根据条件分页查询交易记录
    @PostMapping("/query")
    public PageDto<TradeVo> queryTrade(@RequestBody TradeQuery query){

        return tradeService.queryTrade(query);
    }
    //根据客户身份证号查询基金代码
    @GetMapping("/selectFund")
    public List<String> selectFund(@RequestParam String idCard){
        return customerService.getFundCodeByIdCard(idCard);
    }
    //产品代码查当日购买的金额
    @GetMapping("/selectNetvalue")
    public BigDecimal selectNetvalue(@RequestParam String fundCode){
        return fundnavService.getNetValueByFundCode(fundCode);
    }
    //撤销未确认的申请
    @DeleteMapping("/delete")
    public boolean cancelTrade(@RequestParam Long tradeId,@RequestParam Integer confirmStatus){
        boolean isSuccess=tradeService.deleteTrade(tradeId,confirmStatus);
        return isSuccess;
    }

}
