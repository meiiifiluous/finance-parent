package com.hdu.trade.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hdu.finance.common.domain.po.CustomerErrorLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author
 * @since 2023-12-06
 */
public interface CustomerErrorLogMapper extends BaseMapper<CustomerErrorLog> {
    @Insert("INSERT INTO customer_error_log (customer_id, message) VALUES ( #{customerId}, #{message})")
    int insertErrorLog(@Param("customerId") String customerId, @Param("message") String message);
    @Select("SELECT * FROM customer_error_log WHERE customer_id= #{custId}")
    List<CustomerErrorLog> errorLog(@Param("custId") String custId);
}
