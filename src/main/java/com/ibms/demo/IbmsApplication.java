package com.ibms.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.ibms.demo.mapper")
public class IbmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(IbmsApplication.class, args);
    }

}
