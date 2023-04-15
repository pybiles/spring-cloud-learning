package com.yjx.controller;

import com.yjx.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProviderController {
    @RequestMapping("/provider/hello/{name}")
    public String hello(@PathVariable("name") String name) {
        return "hello\t" + name;
    }
    @RequestMapping("/sayHi")
    public User sayHi(@RequestBody User user){
        user.setId(2);
        user.setName("Array");
        return user;
    }
}
