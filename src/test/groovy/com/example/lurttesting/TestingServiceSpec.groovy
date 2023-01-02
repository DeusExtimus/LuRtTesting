package com.example.lurttesting

import com.example.lurttesting.pojos.TestObject
import com.example.lurttesting.repos.TestRepository
import com.example.lurttesting.service.TestService
import spock.lang.Specification

class TestingServiceSpec extends Specification {
    TestService testService
    TestRepository testRepository

    TestObject ob1
    TestObject ob2

    // wird vor jedem Test ausgeführt
    void setup() {
        // Mock benötigter Komponenten
        testRepository = Mock TestRepository

        // Deklarieren von Test-Objekten
        ob1 = TestObject.builder().withId(7L).withBooleanValue(true).withDoubleValue(33.3483987).build()
        ob2 = TestObject.builder().withId(8L).withBooleanValue(true).withDoubleValue(33.1111111).build()

        // Initialisieren des zu testenden Services mit den gemockten Args
        testService = new TestService(testRepository)
    }

    void 'getRequestedObjects simple Test'() {
        // Testfall vorbereiten
        setup:
        List<Long> ids = [7L]

        // Testfall aufbauen
        when:
        // >> gibt gemockten Rückgabe wert an, 1* ob die Methode genau einmal ausgeführt wird
        1 * testRepository.getAll() >> List.of(ob1, ob2)

        // zu testende Methode aufrufen
        var result = testService.getRequestedTestObjects(ids)

        then:
        result.contains(ob1)
    }

    void 'getRequestedObjects simple Test'() {
        setup:
        List<Long> ids = [7L]

        when:
        1 * testRepository.getAll() >> List.of(ob1, ob2)
        def result = testService.getRequestedTestObjects(ids)

        then:
        result.contains(ob1)
        //FIXME: insert for higher strength
//        !result.contains(ob2)
    }

    void 'getTestObjectsId parametrized'() {
        when:
        def res = testService.getTestObjectsId(params)

        then:
        0 * testRepository.getAll()
        res == result

        // Parameter
        where:
        name       || params                                  || result
        'Object 1' || TestObject.builder().withId(7L).build() || 7L
        'Object 2' || TestObject.builder().withId(8L).build() || 8L
    }

    void 'getTestObjectsBoolean parametrized'() {
        when:
        def res = testService.getTestObjectsBoolean(params)

        then:
        0 * testRepository.getAll()
        res

        // Parameter
        where:
        params << [
                TestObject.builder().withId(7L).withBooleanValue(true).build(),
                TestObject.builder().withId(8L).withBooleanValue(true).build()
        ]
    }

    //FIXME: insert for higher strength
//    void 'getTestObjectsBoolean parametrized with high strength'() {
//        when:
//        def result = testService.getTestObjectsBoolean(obs)
//
//        then:
//        0 * testRepository.getAll()
//        result == res
//
//        // Parameter
//        where:
//        obs | res
//        TestObject.builder().withId(7L).withBooleanValue(true).build() | true
//        TestObject.builder().withId(8L).withBooleanValue(false).build() | false
//    }
}
