package com.cnaturalr.domain.model.user.attributtes;

import lombok.Builder;

@Builder
public class Name {

    private final String value;

    public Name(String value) {
        validatedName(value);
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    private void validatedName(String value) {
        if (value == null || value.isEmpty()) {
            throw new IllegalArgumentException("Nombre no puede ser null o vacio");
        }
        if (value.length() < 3) {
            throw new IllegalArgumentException("Nombre debe contener mas de 3 caracteres");
        }
        if(value.length() > 30) {
            throw new IllegalArgumentException("Nombre debe contener menos de 30 caracteres");
        }
    }
}
