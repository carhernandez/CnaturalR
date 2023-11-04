package com.cnaturalr.domain.model.user.attributtes;

import lombok.Builder;

@Builder
public class Password {

    private String value;

    public Password(String value) {
        validatedPassword(value);
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    private void validatedPassword(String value) {
        if (value == null || value.isEmpty()) {
            throw new IllegalArgumentException("Password no puede ser null o vacio");
        }
    }
}
