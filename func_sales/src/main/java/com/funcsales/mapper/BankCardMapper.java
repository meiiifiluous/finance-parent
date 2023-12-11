package com.funcsales.mapper;

import com.funcsales.po.BankCard;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.math.BigDecimal;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 
 * @since 2023-11-10
 */
public interface BankCardMapper extends BaseMapper<BankCard> {
    @Select("SELECT * FROM c_bank_card WHERE bank_card_no = #{bankCardNo} AND is_deleted = 0")
    BankCard getBankCardById(@Param("bankCardNo") String bankCardNo);
    //更新余额
    @Update("UPDATE c_bank_card SET account_balance = #{difference} WHERE bank_card_no = #{bankCardNo} ")
    void updateAccountBalance(@Param("difference") BigDecimal difference, @Param("bankCardNo") String bankCardNo);
}
