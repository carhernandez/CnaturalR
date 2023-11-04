package com.cnaturalr.domain.model.product.attributtes;

import lombok.Builder;

@Builder
public class Stock {

    private Integer value;

    public Stock(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

}
