package com.hdu.finance.client;

import com.hdu.finance.common.domain.common.Result;
import com.hdu.finance.common.domain.po.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("customer-service")
public interface CustomerClient {
    @GetMapping("/customer/getByName")
    Result getByName(@RequestParam String realName);

    @GetMapping("/customer/checkMobile/{mobile}")
    boolean checkMobile(@PathVariable String mobile);

    @GetMapping("/customer/get")
    public Customer getCustomerByIdCard(@RequestParam("identityNumber") String identityNumber);
}
