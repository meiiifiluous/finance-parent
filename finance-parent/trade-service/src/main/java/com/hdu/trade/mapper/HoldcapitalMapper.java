package com.hdu.trade.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hdu.finance.common.domain.po.Holdcapital;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author
 * @since 2023-11-10
 */
public interface HoldcapitalMapper extends BaseMapper<Holdcapital> {
    @Select("SELECT * FROM f_holdcapital WHERE customer_id=#{custId} AND product_code=#{productCode} AND bank_card_no=#{bankCardNO} AND is_deleted = 0")
    Holdcapital holdcapital(@Param("custId")String custId,@Param("productCode")String productCode,@Param("bankCardNO")String bankCardNO);

    @Update("UPDATE f_holdcapital SET hold_capital = #{tradeAmount} WHERE customer_id=#{custId} AND product_code=#{productCode} AND bank_card_no=#{bankCardNO}")
    void UpdateHoldCapital(@Param("tradeAmount")BigDecimal tradeAmount,@Param("custId")String custId,@Param("productCode")String productCode,@Param("bankCardNO")String bankCardNO);

    @Update("UPDATE f_holdcapital SET trade_amount = #{tradeAmount} WHERE customer_id=#{custId} AND product_code=#{productCode} AND bank_card_no=#{bankCardNO}")
    void UpdateTradeAmount(@Param("tradeAmount")BigDecimal tradeAmount,@Param("custId")String custId,@Param("productCode")String productCode,@Param("bankCardNO")String bankCardNO);

    @Update("UPDATE f_holdcapital SET update_time=CURRENT_TIMESTAMP() WHERE customer_id=#{custId} AND product_code=#{productCode} AND bank_card_no=#{bankCardNO}")
    void UpdateUtime(@Param("custId")String custId,@Param("productCode")String productCode,@Param("bankCardNO")String bankCardNO);

}
