package com.lzr.eurekaconsumerfeign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "eureka-client", fallback = DcFallback.class, configuration = FullLogConfiguration.class)
public interface DcClient {
    @GetMapping("/dc")
    String consumer();

    @GetMapping("/hello1")
    String hello(@RequestParam("name") String name);

    @GetMapping("/hello2")
    User hello(@RequestHeader("name") String name, @RequestHeader("age") Integer age);

    @PostMapping("/hello3")
    String hello(@RequestBody User user);
}
