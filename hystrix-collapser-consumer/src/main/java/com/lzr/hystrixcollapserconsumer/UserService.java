package com.lzr.hystrixcollapserconsumer;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCollapser;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.concurrent.Future;

/**
 * @author linzerong
 * @create 2019-06-21 0:19
 */
@Service
public class UserService {

    @Autowired
    RestTemplate restTemplate;


    @HystrixCollapser(
            scope = com.netflix.hystrix.HystrixCollapser.Scope.GLOBAL,
            batchMethod = "findByIds",
            collapserProperties = {
                    @HystrixProperty(name="timerDelayInMilliseconds", value = "100")
            }
    )
    public Future<String> findById(Long id){
        System.out.println("findById: " + id);
        return null;
    }

    @HystrixCommand(commandProperties = @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000"))
    public List<String> findByIds(List<Long> ids){
        System.out.println("findByIds: " + ids);
        List<String> result = restTemplate.getForObject("http://HYSTRIX-COLLAPSER-PROVIDER/users?ids={1}",
                List.class, StringUtils.join(ids, ","));
        System.out.println(result.toString());
        return result;
    }
}
