package com.cnaturalr.domain.model.product.attributtes;

import lombok.Builder;

@Builder
public class Description {

    private String value;

    public Description(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
