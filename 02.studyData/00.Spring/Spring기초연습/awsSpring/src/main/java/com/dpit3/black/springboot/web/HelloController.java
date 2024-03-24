package com.dpit3.black.springboot.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello") //이전 꺼 : @RequestMapping(method = RequestMethod.GET)
    public String hello(){
        return "hello";
    }
}
