package com.funcsales.service;

import com.funcsales.po.Fundnav;
import com.baomidou.mybatisplus.extension.service.IService;

import java.math.BigDecimal;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 
 * @since 2023-11-29
 */
public interface FundnavService extends IService<Fundnav> {

    BigDecimal getNetValueByFundCode(String fundCode);
}
