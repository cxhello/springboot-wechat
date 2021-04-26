package com.cxhello.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.cxhello.example.dao")
@EnableTransactionManagement
public class SpringbootWeChatApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootWeChatApplication.class, args);
    }

}
