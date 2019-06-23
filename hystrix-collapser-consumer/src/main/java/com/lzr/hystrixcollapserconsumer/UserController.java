package com.lzr.hystrixcollapserconsumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @author linzerong
 * @create 2019-06-21 0:26
 */
@RestController
public class UserController {

    @Autowired
    UserService userService;


    @GetMapping("/consumer")
    public List<String> consumer() throws ExecutionException, InterruptedException {
        Future<String> u1 = userService.findById(1L);
        Future<String> u2 = userService.findById(2L);
        Future<String> u3 = userService.findById(3L);
        Future<String> u4 = userService.findById(4L);

        List<String> result = new ArrayList<>();
        result.add(u1.get());
        result.add(u2.get());
        result.add(u3.get());
        result.add(u4.get());
        return result;
    }

    @GetMapping("/consumer2")
    public List<String> consumer2() throws ExecutionException, InterruptedException {
        Future<String> u1 = userService.findById(1L);
        Future<String> u2 = userService.findById(2L);
        Future<String> u3 = userService.findById(3L);
        Thread.sleep(3000);
        Future<String> u4 = userService.findById(4L);
        Future<String> u5 = userService.findById(5L);
        List<String> result = new ArrayList<>();
        result.add(u1.get());
        result.add(u2.get());
        result.add(u3.get());
        result.add(u4.get());
        result.add(u5.get());
        return result;
    }
}
