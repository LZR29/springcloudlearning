package com.lzr.eurekaconsumerfeign;

import org.springframework.stereotype.Component;

/**
 * @author linzerong
 * @create 2019-06-21 21:53
 *  * 服务降级配置类，实现接口然后在客户端标明即可,配置开启hystrix功能
 */
@Component
public class DcFallback implements DcClient {
    @Override
    public String consumer() {
        return "error";
    }

    @Override
    public String hello(String name) {
        return "error";
    }

    @Override
    public User hello(String name, Integer age) {
        return new User("error", 0);
    }

    @Override
    public String hello(User user) {
        return "error";
    }
}
