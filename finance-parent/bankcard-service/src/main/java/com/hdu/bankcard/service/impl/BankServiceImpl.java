package com.hdu.bankcard.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hdu.finance.common.domain.po.Bank;
import com.hdu.bankcard.mapper.BankMapper;
import com.hdu.bankcard.service.BankService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author vvc
 * @since 2023-11-01
 */
@Service
public class BankServiceImpl extends ServiceImpl<BankMapper, Bank> implements BankService {

}
