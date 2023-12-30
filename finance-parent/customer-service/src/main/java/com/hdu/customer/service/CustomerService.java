package com.hdu.customer.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.hdu.finance.common.domain.common.PageDTO;
import com.hdu.finance.common.domain.po.Customer;
import com.hdu.finance.common.domain.query.CustomerQuery;
import com.hdu.finance.common.domain.vo.CustomerVo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author vvc
 * @since 2023-11-01
 */
public interface CustomerService extends IService<Customer> {

    boolean checkMobile(String mobile);

    PageDTO<CustomerVo> pageCustomerPage(CustomerQuery query);
}
