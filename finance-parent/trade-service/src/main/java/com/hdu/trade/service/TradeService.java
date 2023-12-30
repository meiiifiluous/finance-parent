package com.hdu.trade.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hdu.finance.common.domain.common.Result;
import com.hdu.finance.common.domain.dto.TradeDto;
import com.hdu.finance.common.domain.po.Trade;
import com.hdu.finance.common.domain.vo.TradeVo;
import com.hdu.trade.dto.PageDto;
import com.hdu.trade.query.TradeQuery;
import org.springframework.http.ResponseEntity;


/**
 * <p>
 *  服务类
 * </p>
 *
 * @author
 * @since 2023-11-07
 */
public interface TradeService extends IService<Trade> {
    Result purchaseTrade(TradeDto tradeDto);

    Result redeemTrade(TradeDto tradeDto);

    Result queryTrade(TradeQuery query);

    boolean deleteTrade(TradeVo tradeVo);
}
