package com.lzr.eurekaconsumerfeign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author linzerong
 * @create 2019-06-21 14:54
 */
@RestController
public class DcController {

    @Autowired
    DcClient dcClient;

    @GetMapping("/feign-consumer")
    public String dc() {
        return dcClient.consumer();
    }

    @GetMapping("/feign-consumer2")
    public String feignCoonsumer(){
        StringBuilder sb = new StringBuilder();
        sb.append(dcClient.hello("LZR29")).append("\n")
                .append(dcClient.hello("Lzr29", 22)).append("\n")
                .append(dcClient.hello(new User("lzr", 22))).append("\n");
        return sb.toString();
    }
}
