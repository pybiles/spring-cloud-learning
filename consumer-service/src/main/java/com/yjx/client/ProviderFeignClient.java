package com.yjx.client;

import com.yjx.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("nacos-provider-service")
public interface ProviderFeignClient {
    @RequestMapping("/nacos-provider/hello/{name}")
    String hello(@PathVariable("name") @RequestParam("name") String name);
}
