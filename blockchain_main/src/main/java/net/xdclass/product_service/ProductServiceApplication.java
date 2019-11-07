package net.xdclass.product_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"net.xdclass.product_service.service.impl","net.xdclass.product_service.service","net.xdclass.product_service.controller","net.xdclass.product_service.mapper"})
@SpringBootApplication
public class ProductServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductServiceApplication.class, args);
    }

}
