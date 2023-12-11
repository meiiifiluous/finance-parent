package com.funcsales.service;

import com.funcsales.po.Customer;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 
 * @since 2023-11-28
 */
public interface CustomerService extends IService<Customer> {

    List<String> getFundCodeByIdCard(String idCard);
}
