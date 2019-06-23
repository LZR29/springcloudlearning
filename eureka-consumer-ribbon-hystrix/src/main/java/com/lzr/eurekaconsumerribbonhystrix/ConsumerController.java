package com.lzr.eurekaconsumerribbonhystrix;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author linzerong
 * @create 2019-06-14 14:24
 */
@RestController
public class ConsumerController {

    @Autowired
    ConsumerService service;

    @GetMapping("/ribbon-consumer")
    public String helloConsumer(){
        return service.helloService();
    }
}
