package com.cnaturalr.domain.model.user.attributtes;

import lombok.Builder;

@Builder
public class Email {

    private final String value;

    public Email(String value) {
        validatedEmail(value);
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    private void validatedEmail(String value) {
        if (value == null || value.isEmpty()) {
            throw new IllegalArgumentException("Email no puede ser null o vacio");
        }
        if (value.length() < 3) {
            throw new IllegalArgumentException("Email debe contener mas de 3 caracteres");
        }
        if(value.length() > 30) {
            throw new IllegalArgumentException("Email debe contener menos de 30 caracteres");
        }
    }


}
