package org.example.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum ProductFilterType {
    BRAND, CATEGORY, PRODUCER;
    @JsonValue
    public String toValue() {
        return name();
    }
}
