package com.lzr.streamhello;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author linzerong
 * @create 2019-06-25 20:10
 */
@RestController
public class TestController {

    @Autowired(required = false)
    private SinkSender sinkSender;

    @GetMapping("/test")
    public String contextLoads(){
        sinkSender.output().send(MessageBuilder.withPayload("From SinkSender").build());
        return "Finish";
    }
}
