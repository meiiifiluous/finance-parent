package com.hdu.trade.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hdu.finance.common.domain.po.Trade;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;


/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author
 * @since 2023-11-07
 */
public interface TradeMapper extends BaseMapper<Trade> {

    //根据预计确认时间查询交易表
    @Select("SELECT * FROM t_trade WHERE update_time = #{updateTime} ")
    List<Trade> getTradeByUpdateTime(@Param("updateTime")LocalDateTime updateTime);

    //更新基金份额
    @Update("UPDATE t_trade SET quantity = #{quantity} WHERE trade_no = #{tradeNo}")
    void UpdateQuantityById(@Param("quantity")BigDecimal quantity,@Param("tradeNo") String tradeNo);

    //更新基金确认状态
    @Update("UPDATE t_trade SET confirm_status = #{ConfirmStatus} WHERE trade_no = #{tradeNo}")
    void UpdateConfirmStatusById(@Param("ConfirmStatus")Integer ConfirmStatus,@Param("tradeNo") String tradeNo);

    @Delete("UPDATE t_trade SET is_deleted = 1 WHERE id=#{tradeId} AND confirm_status = #{confirmStatus} ")
    Boolean DeleteTrade(@Param("tradeId")Long tradeId,@Param("confirmStatus") Integer confirmStatus);
}
