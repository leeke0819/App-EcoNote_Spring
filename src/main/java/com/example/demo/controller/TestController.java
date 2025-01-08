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

    @GetMapping("/one")
    public TestEntity createBoard(@RequestParam String title, @RequestBody String content) {
        return testService.printS(title, content);
    }

    @DeleteMapping("/delete")
    public String deleteBoard(@RequestParam int id) {
        return testService.deleteBoard(id);
    }

    @PutMapping("/update")
    public TestEntity updateBoard(@RequestParam int id, @RequestBody String content) {
        return testService.updateBoard(id, content);
    }

    @GetMapping("/read")
    public TestEntity readBoard(@RequestParam int id) {
        return testService.getBoardById(id);
    }
}
