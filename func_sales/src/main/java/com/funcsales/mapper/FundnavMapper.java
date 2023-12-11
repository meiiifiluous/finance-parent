package com.funcsales.mapper;

import com.funcsales.po.Fundnav;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 
 * @since 2023-11-10
 */
public interface FundnavMapper extends BaseMapper<Fundnav> {
    @Select("SELECT * FROM fundnav WHERE fund_code = #{productCode} ORDER BY curr_date DESC LIMIT 1")
    Fundnav getFundnavById(@Param("productCode") String productCode);
    //查找基金净值
    @Select("SELECT netvalue FROM fundnav Where fund_code = #{productCode} AND curr_date = #{date} AND is_deleted = 0")
    BigDecimal getnetvalueByIdAndDate(@Param("productCode")String productCode, @Param("date") LocalDate date);
}
