package com.daniel.gptcontentapi.dtos;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Role {
    SYSTEM("system"),
    USER("user");

    private final String value;

    Role(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }
}
