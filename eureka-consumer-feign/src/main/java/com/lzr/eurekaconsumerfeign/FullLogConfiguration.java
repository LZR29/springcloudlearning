package com.lzr.eurekaconsumerfeign;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



/**
 * @author linzerong
 * @create 2019-06-21 22:16
 */
@Configuration
public class FullLogConfiguration {

    @Bean
    Logger.Level feignLoggerLevel(){
        return Logger.Level.FULL;
    }
}
