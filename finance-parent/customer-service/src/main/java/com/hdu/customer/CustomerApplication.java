package com.hdu.customer;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@MapperScan({"com.hdu.customer.mapper","com.hdu.finance.common.mapper"})
@ComponentScan({"com.hdu.customer","com.hdu.finance.common"})
@EnableAspectJAutoProxy
public class CustomerApplication {
    public static void main(String[] args) {
        SpringApplication.run(CustomerApplication.class);
    }
}
