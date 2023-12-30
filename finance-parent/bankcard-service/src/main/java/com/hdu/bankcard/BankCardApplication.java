package com.hdu.bankcard;

import com.hdu.finance.config.DefaultFeignConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@ComponentScan({"com.hdu.bankcard","com.hdu.finance.common"})
@MapperScan({"com.hdu.bankcard.mapper","com.hdu.finance.common.mapper"})
@EnableFeignClients(basePackages = {"com.hdu.finance.client"},defaultConfiguration = DefaultFeignConfig.class)
@EnableAspectJAutoProxy
public class BankCardApplication {
    public static void main(String[] args) {
        SpringApplication.run(BankCardApplication.class);
    }
}
