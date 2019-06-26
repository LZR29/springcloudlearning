package com.lzr.rabbitmqhello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author linzerong
 * @create 2019-06-24 23:58
 */
@RestController
public class TestController {
    @Autowired
    private Sender sender;


    @GetMapping("/test")
    public String hello(){
        sender.send();
        return "Finish";
    }
}
