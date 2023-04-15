package com.yjx.controller;

import com.yjx.User;
import com.yjx.client.ProviderFeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class FeignController {
    @Resource
    private ProviderFeignClient providerFeignClient;

    @RequestMapping("/feign/hello/{name}")
    public String feignHello(@PathVariable("name") String name) {
        return providerFeignClient.hello(name);
    }

    @RequestMapping("/sayHi")
    public User sayHi(User user) {
        return providerFeignClient.sayHi(user);
    }
}
