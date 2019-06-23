package com.lzr.hystrixcollapserprovider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class HystrixCollapserProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(HystrixCollapserProviderApplication.class, args);
    }

}
