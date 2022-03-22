package com.atguigu.admin.controller;

import com.atguigu.admin.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.List;

@Controller
public class TableController {
    @GetMapping("/basic_table")
    public String basic_table(){
        return "table/basic_table";
    }

    @GetMapping("/dynamic_table")
    public String dynamic_table(){
        //表格内容的遍历
        List<User> users= Arrays.asList(new User("lixing","123456"),
                                        new User("lili","123456"));
        return "table/dynamic_table";
    }

    @GetMapping("/responsive_table")
    public String responsive_table(){
        return "table/responsive_table";
    }

    @GetMapping("/editable_table")
    public String editable_table(){
        return "table/editable_table";
    }

}
