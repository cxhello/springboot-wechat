package com.cxhello.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.cxhello.admin.dao")
@EnableTransactionManagement
public class SpringbootWechatApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootWechatApplication.class, args);
    }

}
