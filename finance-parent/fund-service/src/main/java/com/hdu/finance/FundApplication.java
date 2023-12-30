package com.hdu.finance;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan({"com.hdu.finance.mapper","com.hdu.finance.common.mapper"})
@ComponentScan({"com.hdu.finance","com.hdu.finance.common"})
public class FundApplication {
    public static void main(String[] args) {
        SpringApplication.run(FundApplication.class,args);
    }
}
