package com.example.lurttesting.repos;

import com.example.lurttesting.pojos.TestObject;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Repository
public class TestRepository {
    List<TestObject> mockDb = new ArrayList<>();

    public TestRepository() {
        Random r = new Random();
        for (long i = 1; i < 104; i++) {
            mockDb.add(TestObject.builder()
                    .withId(i)
                    .withDoubleValue((double) i)
                    .withBooleanValue(r.nextBoolean())
                    .build());
        }
    }

    public List<TestObject> getAll() {
        return mockDb;
    }
}
