package com.example.lurttesting

import com.example.lurttesting.pojos.TestObject
import org.junit.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.HttpStatusCode
import org.springframework.test.annotation.DirtiesContext
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.web.client.RestTemplate
import spock.lang.Specification

import static org.assertj.core.api.Assertions.*

@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)
class IntSpec extends Specification {

    RestTemplate template = new RestTemplate()

    @Test
    void 'testSomething'() {
        setup:
        def requestObject = List.of(1L, 12L, 78L)

        when:
        def a = template.postForEntity("http://localhost:8080/testObjects", requestObject,List<TestObject>)

        then:
        a.getStatusCode() === HttpStatusCode.valueOf(200)
        assertThat(a.getBody()).hasSize(3)
    }
}
