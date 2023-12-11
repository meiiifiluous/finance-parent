package com.funcsales.service.serviceimpl;

import com.funcsales.mapper.FundAgreementMapper;
import com.funcsales.mapper.FundMapper;
import com.funcsales.po.Customer;
import com.funcsales.mapper.CustomerMapper;
import com.funcsales.service.CustomerService;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 
 * @since 2023-11-28
 */
@Service
public class CustomerServiceImpl extends ServiceImpl<CustomerMapper, Customer> implements CustomerService {
    @Autowired
    private CustomerMapper customerMapper;
    @Autowired
    private FundAgreementMapper fundAgreementMapper;
    @Autowired
    private FundMapper fundMapper;

    @Override
    public List<String> getFundCodeByIdCard(String idCard) {
        Long Id=customerMapper.getIdByIdCard(idCard);
        //在基金确认表中查找该客户购买的所有基金
        List<Long> fundIds=  fundAgreementMapper.GetFundIdById(Id);
        List<String> fundCodes = new ArrayList<>();
        for(Long fundId : fundIds) {
            String fundCode = fundMapper.getFundCodeById(fundId);
            fundCodes.add(fundCode);
        }
        return fundCodes;
    }
}
