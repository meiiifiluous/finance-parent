package com.funcsales.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.funcsales.dto.PageDto;
import com.funcsales.dto.TradeDto;
import com.funcsales.po.Trade;
import com.baomidou.mybatisplus.extension.service.IService;
import com.funcsales.query.TradeQuery;
import com.funcsales.vo.TradeVo;
import org.springframework.http.ResponseEntity;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 
 * @since 2023-11-07
 */
public interface TradeService extends IService<Trade> {

    ResponseEntity purchaseTrade(TradeDto tradeDto);

    ResponseEntity<?> redeemTrade(TradeDto tradeDto);

    PageDto<TradeVo> queryTrade(TradeQuery query);

    boolean deleteTrade(Long tradeId, Integer confirmStatus);
}
