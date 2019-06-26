package com.lzr.configclient;

import org.omg.CORBA.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author linzerong
 * @create 2019-06-23 23:56
 */
@RestController
@RefreshScope
public class ConfigController {

    @Value("${from}")
    String from;


    @GetMapping("/from")
    public String from(){
        return this.from;
    }
}
