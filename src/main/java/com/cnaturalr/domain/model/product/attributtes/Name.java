package com.cnaturalr.domain.model.product.attributtes;

import lombok.Builder;

@Builder
public class Name {

        private String value;

    public Name(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
