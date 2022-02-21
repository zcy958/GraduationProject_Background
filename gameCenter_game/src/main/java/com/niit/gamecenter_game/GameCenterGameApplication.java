package com.niit.gamecenter_game;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan("com.niit.gamecenter_game.mapper")
@EnableTransactionManagement
@EnableDiscoveryClient
@EnableAsync
public class GameCenterGameApplication {

    public static void main(String[] args) {
        SpringApplication.run(GameCenterGameApplication.class, args);
    }
}
