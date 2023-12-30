package com.hdu.trade;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableFeignClients(basePackages = "com.hdu.finance.client")
@ComponentScan({"com.hdu.trade","com.hdu.finance.common"})
@MapperScan({"com.hdu.finance.common.mapper","com.hdu.trade.mapper"})
@EnableScheduling
public class TradeApplication {
    public static void main(String[] args) {
        SpringApplication.run(TradeApplication.class,args);
    }
}
