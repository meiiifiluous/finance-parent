package com.funcsales.mapper;

import com.funcsales.po.Fund;
import com.funcsales.po.FundAgreement;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
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
 * @author 
 * @since 2023-11-15
 */
public interface FundAgreementMapper extends BaseMapper<FundAgreement> {
    @Update("UPDATE f_fund_agreement SET update_time=CURRENT_TIMESTAMP() WHERE customer_id=#{customerId} AND fund_id=#{fundId} AND bankcard_id=#{bankcardId}")
    void Updatetime(@Param("customerId")Long customerId, @Param("fundId")Long fundId, @Param("bankcardId")Long bankcardId);

    @Update("UPDATE f_fund_agreement SET holding_shares=#{balance} WHERE customer_id=#{customerId} AND fund_id=#{fundId} AND bankcard_id=#{bankcardId}")
    void UpdateBalance(@Param("balance")BigDecimal balance, @Param("customerId")Long customerId, @Param("fundId")Long fundId, @Param("bankcardId")Long bankcardId);

    @Select("SELECT fund_id from f_fund_agreement WHERE customer_id=#{Id} AND is_deleted = 0")
    List<Long> GetFundIdById(@Param("Id") Long id);
}
