package com.lzr.hystrixcollapserprovider;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author linzerong
 * @create 2019-06-20 17:54
 */
@RestController
public class UserController {

    private static Map<Long, String> users = new HashMap<>();

    static {
        users.put(1L, "aaa");
        users.put(2L, "bbb");
        users.put(3L, "ccc");
        users.put(4L, "ddd");
        users.put(5L, "eee");
    }


    @GetMapping("/users/{id}")
    public String findById(@PathVariable("id") Long id){
        System.out.println("findById: " + id);
        return users.get(id);
    }

    @GetMapping("/users")
    public List<String> findByIds(@RequestParam String ids){
        System.out.println("findByIds: " + ids);
        List<String> result = new ArrayList<>();
        for(String id : ids.split(",")) {
            if(users.get(Long.valueOf(id)) != null) {
                result.add(users.get(Long.valueOf(id)));
            }
        }
        System.out.println("findByIds: " + result);
        return result;
    }
}
