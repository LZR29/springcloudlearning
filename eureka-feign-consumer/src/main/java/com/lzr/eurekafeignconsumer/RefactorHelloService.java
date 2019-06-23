package com.lzr.eurekafeignconsumer;

import com.lzr.eurekafeignapi.service.HelloService;
import org.springframework.cloud.netflix.feign.FeignClient;

@FeignClient(value = "eureka-feign-provider")
public interface RefactorHelloService extends HelloService {

}
