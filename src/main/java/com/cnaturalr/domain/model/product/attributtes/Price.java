package com.cnaturalr.domain.model.product.attributtes;

import lombok.Builder;

@Builder
public class Price {

        private Double value;

        public Price(Double value) {
            this.value = value;
        }

        public Double getValue() {
            return value;
        }
}
