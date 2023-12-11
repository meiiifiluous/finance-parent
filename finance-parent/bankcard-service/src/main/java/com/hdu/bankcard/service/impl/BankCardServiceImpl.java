package com.hdu.bankcard.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hdu.finance.common.domain.po.BankCard;
import com.hdu.bankcard.mapper.BankCardMapper;
import com.hdu.bankcard.service.BankCardService;
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
public class BankCardServiceImpl extends ServiceImpl<BankCardMapper, BankCard> implements BankCardService {

}
