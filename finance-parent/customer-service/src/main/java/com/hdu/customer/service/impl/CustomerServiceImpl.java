package com.hdu.customer.service.impl;


import cn.hutool.core.util.StrUtil;
import cn.hutool.system.UserInfo;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hdu.finance.common.domain.common.PageDTO;
import com.hdu.finance.common.domain.po.Customer;
import com.hdu.customer.mapper.CustomerMapper;
import com.hdu.customer.service.CustomerService;
import com.hdu.finance.common.domain.po.Fund;
import com.hdu.finance.common.domain.query.CustomerQuery;
import com.hdu.finance.common.domain.vo.CustomerVo;
import com.hdu.finance.common.domain.vo.FundVo;
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

    @Override
    public PageDTO<CustomerVo> pageCustomerPage(CustomerQuery query) {
        Page<Customer> page = lambdaQuery().page(query.toMpPage());
        return PageDTO.of(page,CustomerVo.class);

    }
}
