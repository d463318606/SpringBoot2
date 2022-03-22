package com.atguigu.boot.controller;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ParameterTestController {
    @GetMapping("/car/{id}/owner/{username}")
    public Map<String,Object> getCar(@PathVariable("id") Integer id,
                                     @PathVariable("username") String name,
                                      @PathVariable Map<String,String> pv){
        Map<String,Object> map=new HashMap<>();
        map.put("id",id);
        map.put("name",name);
        map.put("pv",pv);
        return map;
    }
    @PostMapping("/save")
    public Map postMethod(@RequestBody String content){
        Map<String,Object> map=new HashMap<>();
        map.put("content",content);
        return map;
    }

    @GetMapping("/cars/{path}")
    public Map carsSell(@MatrixVariable("low") Integer low,
                         @MatrixVariable("brand")List<String> brand,
                          @PathVariable("path") String path){
        Map<String,Object> map=new HashMap<>();

        map.put("low",low);
        map.put("brand",brand);
        map.put("path",path);
        return map;
    }

    @GetMapping("/boss/{bossId}/{empId}")
    public Map bossId(@MatrixVariable(value = "age",pathVar = "bossId") Integer bossAge,
                      @MatrixVariable(value = "age",pathVar = "empId") Integer empAge){
        Map<String,Object> map=new HashMap<>();
        map.put("bossAge",20);
        map.put("empAge",15);
        return map;
    }
}
