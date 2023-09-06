package org.example.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum OrderType {
    POPULARITY("popularity"), COST("price"), ABC("productName");
    private final String fieldName;
    OrderType(String fieldName) {
        this.fieldName = fieldName;
    }
    @JsonValue
    public String toValue() {
        return fieldName;
    }
}
