package com.yjx.client;

import com.yjx.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("provider-service")
public interface ProviderFeignClient {
    @RequestMapping("/provider/hello/{name}")
    String hello(@PathVariable("name") String name);
    @RequestMapping("/sayHi")
    User sayHi(User user);
}
