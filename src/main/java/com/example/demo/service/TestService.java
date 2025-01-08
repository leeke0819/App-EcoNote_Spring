package com.example.demo.service;

import com.example.demo.model.TestEntity;
import com.example.demo.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestService {

    @Autowired
    private TestRepository testRepository;

    public TestEntity printS(String s1, String s2) {
        try {
            TestEntity testEntity = new TestEntity();
            testEntity.setTitle(s1);
            testEntity.setContent(s2);
            testRepository.save(testEntity);

            return testEntity;
        } catch (NumberFormatException e) {
            throw new NumberFormatException("숫자만 적을 수 있습니다.");
        }
    }

    public String deleteBoard(int id) {
        testRepository.deleteById(id);
        return "성공";
    }

    public TestEntity updateBoard(int id, String content) {
        TestEntity entity = testRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("id를 찾을 수 없습니다."));
        entity.setContent(content); // content 업뎃해주기
        return testRepository.save(entity); // 저장한걸 반환
    }

    public TestEntity getBoardById(int id) {
        return testRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("id를 찾을 수 없습니다."));
    }
}