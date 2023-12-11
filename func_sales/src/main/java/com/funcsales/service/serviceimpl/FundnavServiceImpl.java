package com.funcsales.service.serviceimpl;

import com.funcsales.po.Fundnav;
import com.funcsales.mapper.FundnavMapper;
import com.funcsales.service.FundnavService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 
 * @since 2023-11-29
 */
@Service
public class FundnavServiceImpl extends ServiceImpl<FundnavMapper, Fundnav> implements FundnavService {
    @Autowired
    private FundnavMapper fundnavMapper;

    @Override
    public BigDecimal getNetValueByFundCode(String fundCode) {
        return fundnavMapper.getnetvalueByIdAndDate(fundCode, LocalDate.now());
    }
}
