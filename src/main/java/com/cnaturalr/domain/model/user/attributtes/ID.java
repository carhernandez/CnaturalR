package com.cnaturalr.domain.model.user.attributtes;

import lombok.Builder;

@Builder
public class ID {

    private Integer value;

    public ID(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    private void validatedID(Integer value) {
        if (value == null || value < 0) {
            throw new IllegalArgumentException("ID no puede ser null o negativo");
        }
    }
}
