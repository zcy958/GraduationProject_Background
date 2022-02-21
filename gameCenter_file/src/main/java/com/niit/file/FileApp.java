package com.niit.file;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@MapperScan("com.niit.file.mapper")
@EnableDiscoveryClient
public class FileApp {
    public static void main(String[] args) {
        SpringApplication.run(FileApp.class, args);
    }
}
