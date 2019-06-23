package com.lzr.eurekaclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

/**
 * @author linzerong
 * @create 2019-06-13 23:26
 */
@RestController
public class DcController {

    @Autowired(required = false)
    private DiscoveryClient client;

    @GetMapping("/dc")
    public String dc(){
        String services = "Services: " + client.getServices();
        System.out.println(services);
        return services;
    }

    /**
     * 当睡眠时间超过2000ms时，断路器会触发熔断请求
     * @return
     * @throws InterruptedException
     */
    @GetMapping("/dc-hystrix")
    public String dcHystrix() throws InterruptedException {
        //让线程睡眠几秒钟，验证断路器处理阻塞情况
        int sleepTime = new Random().nextInt(4000);
        System.out.println("睡眠时间为:" + sleepTime);
        Thread.sleep(sleepTime);
        String services = "Services: " + client.getServices();
        System.out.println(services);
        return services;
    }

    @GetMapping("/hello1")
    public String hello(@RequestParam String name){
        return "Hello : " + name;
    }

    @GetMapping("/hello2")
    public User hello(@RequestHeader String name, @RequestHeader Integer age){
        return new User(name, age);
    }

    @PostMapping("/hello3")
    public String hello(@RequestBody User user){
        return "Hello " + user.getName() + ", " + user.getAge();
    }
}
