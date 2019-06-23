package com.lzr.eurekaconsumerribbonhystrix;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author linzerong
 * @create 2019-06-20 9:32
 */
@Service
public class ConsumerService {
    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "helloFallback")
    public String helloService(){
        return restTemplate.getForEntity("http://EUREKA-CLIENT/dc-hystrix", String.class).getBody();
    }

    public String helloFallback(){
        return "error";
    }
}
