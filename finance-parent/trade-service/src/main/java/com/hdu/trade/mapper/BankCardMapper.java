package com.hdu.trade.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hdu.finance.common.domain.po.BankCard;
import com.hdu.finance.common.domain.vo.BankCardVo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.math.BigDecimal;
import java.util.List;


/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author vvc
 * @since 2023-11-01
 */
public interface BankCardMapper extends BaseMapper<BankCard> {
    @Select("SELECT * FROM c_bank_card WHERE bank_card_no = #{bankCardNo}")
    BankCard getBankCardById(@Param("bankCardNo") String bankCardNo);
    //更新余额
    @Update("UPDATE c_bank_card SET account_balance = #{difference} WHERE bank_card_no = #{bankCardNo} ")
    void updateAccountBalance(@Param("difference") BigDecimal difference, @Param("bankCardNo") String bankCardNo);
    @Select("SELECT bank_card_no,account_balance FROM c_bank_card WHERE customer_id = #{custId} A")
    List<BankCardVo> getBankCard(@Param("custId") String custId);
}
