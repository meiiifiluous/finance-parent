package com.hdu.dict.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hdu.finance.common.domain.po.Dict;
import com.hdu.dict.mapper.DictMapper;
import com.hdu.dict.service.DictService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author vvc
 * @since 2023-10-31
 */
@Service
public class DictServiceImpl extends ServiceImpl<DictMapper, Dict> implements DictService {

}
