package com.ibms.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan("com.ibms.demo.mapper")
@EnableTransactionManagement
public class IbmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(IbmsApplication.class, args);
    }

}
