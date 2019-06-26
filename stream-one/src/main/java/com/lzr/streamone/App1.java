package com.lzr.streamone;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.messaging.handler.annotation.SendTo;

/**
 * @author linzerong
 * @create 2019-06-25 20:28
 */
@EnableBinding(value ={Processor.class})
public class App1 {

    private static Logger logger = LoggerFactory.getLogger(App1.class);

    @StreamListener(Processor.INPUT)
    @SendTo(Processor.OUTPUT)
    public Object receiveFromInput(Object payload){
        logger.info("App1 Received : " + payload + "  -----------");
        return "From Input Channel Return - " + payload;
    }
}
