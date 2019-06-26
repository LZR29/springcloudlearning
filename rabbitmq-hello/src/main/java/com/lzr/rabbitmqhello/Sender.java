package com.lzr.rabbitmqhello;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author linzerong
 * @create 2019-06-24 23:51
 */
@Component
public class Sender {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send(){
        String s = "hello " + new Date();
        System.out.println("Sender  : " + s + "   -------------------------");
        this.rabbitTemplate.convertAndSend("hello", s);
    }
}
