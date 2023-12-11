package com.hdu.finance;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("com.hdu.finance.mapper")
@ComponentScan("com.hdu.finance")
public class FundApplication {
    public static void main(String[] args) {
        SpringApplication.run(FundApplication.class,args);
    }
}
