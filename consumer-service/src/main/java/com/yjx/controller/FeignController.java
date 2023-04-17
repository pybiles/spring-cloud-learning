package com.yjx.controller;

import com.yjx.User;
import com.yjx.client.ProviderFeignClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RefreshScope//可以动态获取配置文件的更新
public class FeignController {
    @Resource
    private ProviderFeignClient providerFeignClient;

    @RequestMapping("/feign/hello/{name}")
    public String feignHello(@PathVariable("name") String name) {
        return providerFeignClient.hello(name);
    }

}
