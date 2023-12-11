package com.hdu.dict;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import javax.swing.*;

@SpringBootApplication()
@ComponentScan({"com.hdu.dict","com.hdu.finance.common.config"})
public class DictApplication {
    public static void main(String[] args) {
        SpringApplication.run(DictApplication.class);
    }
}
