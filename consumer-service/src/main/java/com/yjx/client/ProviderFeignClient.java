package com.yjx.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("provider-service")
public interface ProviderFeignClient {
    @RequestMapping("/provider/hello/{name}")
    public String hello(@PathVariable("name") String name);
}
