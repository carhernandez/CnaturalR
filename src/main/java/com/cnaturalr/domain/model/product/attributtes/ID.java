package com.cnaturalr.domain.model.product.attributtes;

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
}
