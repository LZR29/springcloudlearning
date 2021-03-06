package com.lzr.streamconsumergroup;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

/**
 * @author linzerong
 * @create 2019-06-25 10:53
 */
@EnableBinding({Sink.class})
public class SinkReceiver {
    private static Logger logger = LoggerFactory.getLogger(SinkReceiver.class);

    @StreamListener(Sink.INPUT)
    public void receive(String payload) {
        logger.info("Received: " + payload);
    }
}
