package com.example.demo.controller;

import com.example.demo.model.TestEntity;
import com.example.demo.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/place")
public class TestController {
    @Autowired
    private final TestService testService;

    @Autowired
    public TestController(TestService testService) {
        this.testService = testService;
    }
    @GetMapping("/one/{s1}")
    public TestEntity test(@PathVariable String s1, @RequestParam String s2) {
        return testService.printS(s1, s2);
    }
}
