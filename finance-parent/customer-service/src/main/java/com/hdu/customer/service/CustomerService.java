package com.hdu.customer.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.hdu.finance.common.domain.po.Customer;

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
}
