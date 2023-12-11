package com.hdu.customer.service.impl;


import cn.hutool.system.UserInfo;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hdu.finance.common.domain.po.Customer;
import com.hdu.customer.mapper.CustomerMapper;
import com.hdu.customer.service.CustomerService;
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
public class CustomerServiceImpl extends ServiceImpl<CustomerMapper, Customer> implements CustomerService {

    @Override
    public boolean checkMobile(String mobile) {
        QueryWrapper<Customer> customerQueryWrapper = new QueryWrapper<>();
        customerQueryWrapper.eq("mobile", mobile);
        Integer count = baseMapper.selectCount(customerQueryWrapper);
        return count > 0;
    }
}
