package com.yjx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * EurekaServerApp启动类
 */
@SpringBootApplication
@EnableDiscoveryClient
public class NacosProviderApp {
    public static void main(String[] args) {

        SpringApplication.run(NacosProviderApp.class, args);
    }
}
