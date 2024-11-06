package com.example.demo.service;

import com.example.demo.controller.TestController;
import com.example.demo.model.TestEntity;
import com.example.demo.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestService {

    public TestEntity printS(String s1, String s2) {
        try {
            int a = Integer.parseInt(s1);
            int b = Integer.parseInt(s2);

            TestEntity testEntity = new TestEntity();
            testEntity.setA(a);
            testEntity.setB(b);

            return testEntity;
        } catch (NumberFormatException e) {
            throw new NumberFormatException("숫자만 적을 수 있습니다.");
        }
    }
}
