package com.example.lurttesting.controller;

import com.example.lurttesting.pojos.TestObject;
import com.example.lurttesting.service.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class TestController {
    private final TestService testService;

    @PostMapping("/testObjects")
    private ResponseEntity<List<TestObject>> getTestByTestId(
            @RequestBody List<Long> ids
    ) {
        return ResponseEntity.ok(testService.getRequestedTestObjects(ids));
    }
}
