package com.lzr.eurekafeignconsumer;

import com.lzr.eurekafeignapi.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author linzerong
 * @create 2019-06-21 20:07
 */
@RestController
public class FeignConsumerController {

    @Autowired
    RefactorHelloService refactorHelloService;

    @GetMapping("/feign-consumer")
    public String helloConsumer3(){
        StringBuilder sb = new StringBuilder();
        sb.append(refactorHelloService.hello("LZR29")).append("\n")
                .append(refactorHelloService.hello("Lzr29", 22)).append("\n")
                .append(refactorHelloService.hello(new User("lzr", 22))).append("\n");
        return sb.toString();
    }
}
