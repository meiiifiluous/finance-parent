package com.hdu.trade.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hdu.finance.common.domain.po.FundAgreement;
import com.hdu.finance.common.domain.vo.FundVo;
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

    @Select("SELECT fa.fund_id, fa.holding_shares, fn.chi_name, fn.risk_level " +
            "FROM f_fund_agreement fa " +
            "LEFT JOIN p_fund fn ON fa.fund_id = fn.id " +
            "WHERE fa.customer_id = #{id} AND fa.is_deleted = 0")
    List<FundVo> GetFundIdById(@Param("id") Long id);
}
