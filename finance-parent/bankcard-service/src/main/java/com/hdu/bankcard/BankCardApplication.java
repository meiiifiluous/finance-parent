package com.hdu.bankcard;

import com.hdu.finance.config.DefaultFeignConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@MapperScan("com.hdu.bankcard.mapper")
@EnableFeignClients(basePackages = {"com.hdu.finance.client"},defaultConfiguration = DefaultFeignConfig.class)
public class BankCardApplication {
    public static void main(String[] args) {
        SpringApplication.run(BankCardApplication.class);
    }
}
