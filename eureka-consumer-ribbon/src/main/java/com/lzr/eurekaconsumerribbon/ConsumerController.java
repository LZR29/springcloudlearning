package com.lzr.eurekaconsumerribbon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author linzerong
 * @create 2019-06-14 14:24
 */
@RestController
public class ConsumerController {

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/ribbon-consumer")
    public String helloConsumer(){
        return restTemplate.getForEntity("http://EUREKA-CLIENT/dc", String.class).getBody();
    }
}
