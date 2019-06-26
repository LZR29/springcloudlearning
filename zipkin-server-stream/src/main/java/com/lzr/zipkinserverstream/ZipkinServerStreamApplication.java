package com.lzr.zipkinserverstream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.sleuth.zipkin.stream.EnableZipkinStreamServer;

@SpringBootApplication
@EnableZipkinStreamServer
public class ZipkinServerStreamApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZipkinServerStreamApplication.class, args);
    }

}
