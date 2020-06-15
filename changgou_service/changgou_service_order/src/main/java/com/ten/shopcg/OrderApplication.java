package com.ten.shopcg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@EnableEurekaClient
@MapperScan(basePackages = {"com.ten.shopcg.order.dao"})
public class OrderApplication {
    public static void main(String[] args) {
        SpringApplication.run( OrderApplication.class);
    }
}
