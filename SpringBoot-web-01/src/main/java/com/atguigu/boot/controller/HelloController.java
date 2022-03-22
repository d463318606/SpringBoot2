package com.atguigu.boot.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {
    @RequestMapping("/halo.png")
    public String hello(){
        return "hehe";
    }

    @RequestMapping(value = "/user",method = RequestMethod.GET)
    public String getUser(){
        return "GET-hehe";
    }

    @RequestMapping(value = "/user",method = RequestMethod.POST)
    public String saveUser(){
        return "POST-hehe";
    }

    @PutMapping("/user")
//@RequestMapping(value = "/user",method = RequestMethod.PUT)
    public String putUser(){
        return "PUT-张三";
    }

    @DeleteMapping("/user")
//@RequestMapping(value = "/user",method = RequestMethod.DELETE)
    public String deleteUser(){
        return "DELETE-张三";
    }
}
