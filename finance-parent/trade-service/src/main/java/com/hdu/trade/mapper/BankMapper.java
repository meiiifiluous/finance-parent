package com.hdu.trade.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.hdu.finance.common.domain.po.Bank;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author
 * @since 2023-11-07
 */
public interface BankMapper extends BaseMapper<Bank> {

    @Select("SELECT * FROM c_bank WHERE bank_code = #{bankCode} AND is_deleted = 0")
    Bank getBankById(@Param("bankCode") String bankCode);
}
