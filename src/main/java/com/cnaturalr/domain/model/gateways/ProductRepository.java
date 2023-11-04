package com.cnaturalr.domain.model.gateways;

import com.cnaturalr.domain.model.product.Product;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductRepository {


    Mono<Product> save(Product product);
    Mono<Product> findById(Integer id);

    Mono<Product> update(Product product);

    Mono<Product> delete(Integer id);

    Flux<Product> findByName(String name);

    Mono<Product> findByDescription(String description);

    Mono<Product> findByPrice(Double price);

    Mono<Product> findByCategory(String category);

    Flux<Product> findAll();

}
