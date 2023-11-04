package com.cnaturalr.infraestructure.driven_adapters.entity;

import com.cnaturalr.domain.model.product.Product;
import com.cnaturalr.domain.model.product.attributtes.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("products")
@Builder
@Getter
@AllArgsConstructor
public class ProductDBO {

    @Id
    private final Integer id;
    private final String name;
    private final Double price;
    private final String description;
    private final Integer stock;
    private final String photo;

    public static ProductDBO fromDomain(Product product){
        return ProductDBO.builder()
                .id(product.getId().getValue())
                .name(product.getName().getValue())
                .price(product.getPrice().getValue())
                .description(product.getDescription().getValue())
                .stock(product.getStock().getValue())
                .photo(product.getPhoto().getValue())
                .build();
    }

    public static Product toDomain(ProductDBO productDBO){
        return new Product(ID.builder().value(productDBO.getId()).build(),
                Name.builder().value(productDBO.getName()).build(),
                Price.builder().value(productDBO.getPrice()).build(),
                Description.builder().value(productDBO.getDescription()).build(),
                Stock.builder().value(productDBO.getStock()).build(),
                Photo.builder().value(productDBO.getPhoto()).build());
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public Integer getStock() {
        return stock;
    }

    public String getPhoto() {
        return photo;
    }
}
