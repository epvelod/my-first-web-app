package com.ln.azure.demo.controller;


import com.ln.azure.demo.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MyController {
    @Autowired
    private MyService myService;

    @GetMapping("/hello")
    public String hello() {
        return myService.hello();
    }
}