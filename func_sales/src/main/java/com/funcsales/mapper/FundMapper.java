package com.funcsales.mapper;

import com.funcsales.po.Fund;
import com.funcsales.po.Fundnav;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 
 * @since 2023-11-07
 */
public interface FundMapper extends BaseMapper<Fund> {

    @Select("SELECT * FROM p_fund WHERE fund_code = #{productCode} AND is_deleted = 0")
    Fund getFundById(@Param("productCode") String productCode);

    @Select("SELECT fund_code FROM p_fund WHERE id = #{fundId} AND is_deleted = 0")
    String getFundCodeById(@Param("fundId") Long fundId);

    @Update("UPDATE p_fund SET buyed_count = #{quantity} WHERE fund_code=#{productCode}")
    Void UpdateBuyedCount(@Param("quantity")BigDecimal quantity,@Param("productCode")String productCode);
}
