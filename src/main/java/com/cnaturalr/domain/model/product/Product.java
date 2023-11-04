package com.cnaturalr.domain.model.product;

import com.cnaturalr.domain.model.product.attributtes.*;

import lombok.Builder;

@Builder
public class Product {

    private final ID id;
    private final Name name;
    private final Price price;
    private final Description description;
    private final Stock stock;
    private final Photo photo;

    public Product(ID id, Name name, Price price, Description description, Stock stock, Photo photo) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.stock = stock;
        this.photo = photo;
    }

    public ID getId() {
        return id;
    }

    public Name getName() {
        return name;
    }

    public Price getPrice() {
        return price;
    }

    public Description getDescription() {
        return description;
    }

    public Stock getStock() {
        return stock;
    }

    public Photo getPhoto() {
        return photo;
    }
}
