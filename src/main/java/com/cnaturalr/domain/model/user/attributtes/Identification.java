package com.cnaturalr.domain.model.user.attributtes;

import lombok.Builder;

@Builder
public class Identification {

    private Integer value;

    public Identification(Integer value) {
        validatedIdentification(value);
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    private void validatedIdentification(Integer value) {
        if (value == null || value < 0) {
            throw new IllegalArgumentException("Document no puede ser null o negativo");
        }
    }
}
