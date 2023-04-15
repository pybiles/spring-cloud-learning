package com.yjx.web.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NacosProviderController {
    @RequestMapping("/nacos-provider/hello/{name}")
    public String hello(@PathVariable("name") String name){
        return "hello\t"+name;
    }
}
