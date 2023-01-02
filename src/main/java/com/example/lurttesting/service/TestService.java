package com.example.lurttesting.service;

import com.example.lurttesting.pojos.TestObject;
import com.example.lurttesting.repos.TestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TestService {
    private final TestRepository testRepository;

    public List<TestObject> getRequestedTestObjects(List<Long> ids) {
        return testRepository.getAll().stream()
                .filter(testObject -> ids.contains(testObject.getId()))
                .toList();
    }

    public Long getTestObjectsId(TestObject ob) {
        return ob.getId();
    }

    public boolean getTestObjectsBoolean(TestObject ob) {
        return ob.getBooleanValue();
    }
}
