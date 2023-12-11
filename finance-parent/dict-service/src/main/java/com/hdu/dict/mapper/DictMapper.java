package com.hdu.dict.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hdu.finance.common.domain.po.Dict;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;


/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author vvc
 * @since 2023-10-31
 */
@Mapper
public interface DictMapper extends BaseMapper<Dict> {

}
