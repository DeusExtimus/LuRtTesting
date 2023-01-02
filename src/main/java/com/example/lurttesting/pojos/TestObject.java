package com.example.lurttesting.pojos;

import lombok.Builder;
import lombok.Getter;
import lombok.extern.jackson.Jacksonized;

import java.math.BigDecimal;

@Builder(setterPrefix = "with")
@Getter
@Jacksonized
public class TestObject {
    Long id;
    Double doubleValue;
    Boolean booleanValue;
}
