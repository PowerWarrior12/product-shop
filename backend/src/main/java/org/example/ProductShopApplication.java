package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "org.example")
@EnableJpaRepositories
public class ProductShopApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProductShopApplication.class, args);
    }
}