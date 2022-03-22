package com.atguigu.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewTestController {
    @GetMapping("/atguigu")
    public  String atguigu(Model model){
    //model中的数据会被放到请求域中
      model.addAttribute("msg","hello,atguigu");
      model.addAttribute("link","http://www.baidu.com");
      return "success";

    }
}
