package com.hdu.dict;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import javax.swing.*;

@SpringBootApplication()
@MapperScan({"com.hdu.dict.mapper","com.hdu.finance.common.mapper"})
@ComponentScan({"com.hdu.dict","com.hdu.finance.common"})
@EnableAspectJAutoProxy
public class DictApplication {
    public static void main(String[] args) {
        SpringApplication.run(DictApplication.class);
    }
}
