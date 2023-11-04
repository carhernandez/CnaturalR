package com.cnaturalr.infraestructure.entry_points.product.dto;

import com.cnaturalr.domain.model.product.Product;
import com.cnaturalr.domain.model.product.attributtes.*;
import lombok.AllArgsConstructor;
import lombok.Builder;

@Builder
@AllArgsConstructor
public class ProductDTO {

    private final Integer id;
    private final String name;
    private final Double price;
    private final String description;
    private final Integer stock;
    private final String photo;

    public Product toDomain(){
        return new Product(ID.builder().value(id).build(),
                Name.builder().value(name).build(),
                Price.builder().value(price).build(),
                Description.builder().value(description).build(),
                Stock.builder().value(stock).build(),
                Photo.builder().value(photo).build());
    }

    public static ProductDTO fromDomain(Product product){
        return new ProductDTO(product.getId().getValue(),
                product.getName().getValue(),
                product.getPrice().getValue(),
                product.getDescription().getValue(),
                product.getStock().getValue(),
                product.getPhoto().getValue());
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
