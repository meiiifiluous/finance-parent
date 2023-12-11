package com.funcsales.scheduler;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.funcsales.mapper.*;

import com.funcsales.po.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Component
public class PurchaseScheduler {
    @Autowired
    private TradeMapper tradeMapper;
    @Autowired
    private FundnavMapper fundnavMapper;
    @Autowired
    private HoldcapitalMapper holdcapitalMapper;
    @Autowired
    private FundMapper fundMapper;
    @Autowired
    private CustomerMapper customerMapper;
    @Autowired
    private BankCardMapper bankCardMapper;
    @Autowired
    private FundAgreementMapper fundAgreementMapper;

    @Scheduled(cron = "0 0 8 * * ?") // 每天上午8点执行
    public void PurchaseProcessing(){
        LocalDate today = LocalDate.now();
        LocalTime eightAM = LocalTime.of(8, 0);
        LocalDateTime targetDateTime = LocalDateTime.of(today, eightAM);

        // 查询 trade 表，更新符合条件的记录
        List<Trade> trades =tradeMapper.getTradeByUpdateTime(targetDateTime);
        BigDecimal quantity;
        for (Trade trade : trades) {
            Holdcapital holdcapital=holdcapitalMapper.holdcapital(trade.getCustId(),trade.getProductCode(),trade.getBankCardNo());
            // 执行基金份额计算、确认状态更新和银行卡余额扣减逻辑
            if (trade.getTradeTime().toLocalTime().isBefore(LocalTime.of(15, 0))) {
                // 下午3点前购买的逻辑，按照第二天的基金净值计算份额
                //下单后第二天
                LocalDate nextday=trade.getTradeTime().plusDays(1).toLocalDate();
                //获取第二天的基金净值
                BigDecimal netvalue=fundnavMapper.getnetvalueByIdAndDate(trade.getProductCode(),nextday);
                //计算份额
                quantity=trade.getTradeAmount().divide(netvalue, 4, RoundingMode.DOWN);
            } else {
                // 下午3点后购买的逻辑，按照第三天的基金净值计算份额
                //下单后第三天
                LocalDate thirdDay=trade.getTradeTime().plusDays(2).toLocalDate();
                //获取第三天的基金净值
                BigDecimal netvalue=fundnavMapper.getnetvalueByIdAndDate(trade.getProductCode(),thirdDay);
                //计算份额
                quantity=trade.getTradeAmount().divide(netvalue, 4, RoundingMode.DOWN);
            }


            Fund fund=fundMapper.getFundById(trade.getProductCode());
            BankCard bankCard=bankCardMapper.getBankCardById(trade.getBankCardNo());
            Long fundId=fund.getId();
            Long customerId=customerMapper.getCustomerById(trade.getCustId()).getId();
            Long bankcardId=bankCardMapper.getBankCardById(trade.getBankCardNo()).getId();
            //判断基金确认表中是否有符合条件的记录
            LambdaQueryWrapper<FundAgreement> fundAgreementLambdaQueryWrapper=new LambdaQueryWrapper<>();
            fundAgreementLambdaQueryWrapper.eq(FundAgreement::getFundId,fundId)
                    .eq(FundAgreement::getCustomerId,customerId)
                    .eq(FundAgreement::getBankcardId,bankcardId);
            // 使用 selectOne 方法重载
            FundAgreement fundAgreement = fundAgreementMapper.selectOne(fundAgreementLambdaQueryWrapper);

            //如果是未确认的申购
            if(trade.getType()==1&&trade.getConfirmStatus()==1){

                //更新trade表中的份额
                tradeMapper.UpdateQuantityById(quantity,trade.getTradeNo());
                //判断基金规模是否超出
                if(fund.getFundScale().compareTo(fund.getBuyedCount().add(quantity)) < 0){
                    //订单确认失败
                    tradeMapper.UpdateConfirmStatusById(3,trade.getProductCode());
                    //更新银行卡余额
                    bankCardMapper.updateAccountBalance(bankCard.getAccountBalance().add(trade.getTradeAmount()),trade.getBankCardNo());
                    //更新客户持有资产表
                    holdcapitalMapper.UpdateTradeAmount(holdcapital.getTradeAmount().subtract(trade.getTradeAmount()),trade.getCustId(),trade.getProductCode(),trade.getBankCardNo());
                    holdcapitalMapper.UpdateUtime(trade.getCustId(),trade.getProductCode(),trade.getBankCardNo());
                    throw new RuntimeException("购买份额超出基金规模，申购失败");
                }else{
                    // 更新 trade 表中的申购状态
                    tradeMapper.UpdateConfirmStatusById(2,trade.getTradeNo());
                    //更新客户持有资产表
                    holdcapitalMapper.UpdateHoldCapital(trade.getTradeAmount().add(holdcapital.getHoldCapital()),trade.getCustId(),trade.getProductCode(),trade.getBankCardNo());
                    //已确认的订单不算申赎资产
                    holdcapitalMapper.UpdateTradeAmount(holdcapital.getTradeAmount().subtract(trade.getTradeAmount()),trade.getCustId(),trade.getProductCode(),trade.getBankCardNo());

                    //更新基金表
                    fundMapper.UpdateBuyedCount(fund.getBuyedCount().add(quantity),trade.getProductCode());
                    //更新基金确认表

                    if(fundAgreement!=null){
                        fundAgreementMapper.Updatetime(customerId,fundId,bankcardId);
                        fundAgreementMapper.UpdateBalance(quantity.add(fundAgreement.getHoldingShares()),customerId,fundId,bankcardId);
                    }else{
                        fundAgreement.setFundId(fundId);
                        fundAgreement.setBankcardId(bankcardId);
                        fundAgreement.setBankcardId(bankcardId);
                        fundAgreement.setCreateTime(LocalDateTime.now());
                        fundAgreement.setUpdateTime(LocalDateTime.now());
                        fundAgreement.setHoldingShares(quantity);
                    }
                }


            }
            //如果是未确认的赎回
            if(trade.getType()==2&&trade.getConfirmStatus()==1){
                //判断赎回的份额是否超出已购份额
                if(fundAgreement.getHoldingShares().compareTo(quantity)<0){
                    //订单确认失败
                    tradeMapper.UpdateConfirmStatusById(3,trade.getProductCode());
                    //更新银行卡余额
                    bankCardMapper.updateAccountBalance(bankCard.getAccountBalance().subtract(trade.getTradeAmount()),trade.getBankCardNo());
                    //更新客户持有资产表
                    holdcapitalMapper.UpdateTradeAmount(holdcapital.getTradeAmount().subtract(trade.getTradeAmount()),trade.getCustId(),trade.getProductCode(),trade.getBankCardNo());
                    holdcapitalMapper.UpdateUtime(trade.getCustId(),trade.getProductCode(),trade.getBankCardNo());
                    throw new RuntimeException("赎回份额超出购买份额，赎回失败");
                }else{
                    // 更新 trade 表中的赎回状态
                    tradeMapper.UpdateConfirmStatusById(2,trade.getTradeNo());
                    //更新赎回的份额
                    tradeMapper.UpdateQuantityById(quantity,trade.getTradeNo());
                    //更新客户持有资产表
                    holdcapitalMapper.UpdateHoldCapital(trade.getTradeAmount().subtract(holdcapital.getHoldCapital()),trade.getCustId(),trade.getProductCode(),trade.getBankCardNo());
                    //已确认的订单不算申赎资产
                    holdcapitalMapper.UpdateTradeAmount(holdcapital.getTradeAmount().subtract(trade.getTradeAmount()),trade.getCustId(),trade.getProductCode(),trade.getBankCardNo());
                    //更新客户持有份额
                    fundAgreementMapper.Updatetime(customerId,fundId,bankcardId);
                    fundAgreementMapper.UpdateBalance(fundAgreement.getHoldingShares().subtract(quantity),customerId,fundId,bankcardId);
                    //更新基金表
                }
            }
        }
    }
}