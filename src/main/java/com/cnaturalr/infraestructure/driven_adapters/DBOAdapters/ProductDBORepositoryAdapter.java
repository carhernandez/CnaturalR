package com.cnaturalr.infraestructure.driven_adapters.DBOAdapters;

import com.cnaturalr.domain.model.gateways.ProductRepository;
import com.cnaturalr.domain.model.product.Product;
import com.cnaturalr.infraestructure.driven_adapters.DBORepository.IProductDBORepository;
import com.cnaturalr.infraestructure.driven_adapters.entity.ProductDBO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
@AllArgsConstructor
public class ProductDBORepositoryAdapter implements ProductRepository {


    private final IProductDBORepository repository;

    @Override
    public Mono<Product> save(Product product) {
        return repository.save(ProductDBO.fromDomain(product)).map(ProductDBO::toDomain);
    }

    @Override
    public Mono<Product> findById(Integer id) {
        return repository.findById(id).map(ProductDBO::toDomain);
    }

    @Override
    public Mono<Product> update(Product product) {
        return repository.findById(product.getId().getValue())
                .switchIfEmpty(Mono.error(new RuntimeException("Product not found with ID: " + product.getId())))
                .then(repository.save(ProductDBO.fromDomain(product))
                        .map(ProductDBO::toDomain))
                .onErrorResume(
                        Exception.class, e -> Mono.error(
                                new RuntimeException("Product not found with ID: " + product.getId())));
    }

    @Override
    public Mono<Product> delete(Integer id) {
        return repository.findById(id)
                .flatMap(product -> repository.delete(product)
                        .then(Mono.just(ProductDBO.toDomain(product))));
    }

    @Override
    public Flux<Product> findByName(String name) {
        return repository.findByName(name).map(ProductDBO::toDomain);
    }

    @Override
    public Mono<Product> findByDescription(String description) {
        return null;
    }

    @Override
    public Mono<Product> findByPrice(Double price) {
        return null;
    }

    @Override
    public Mono<Product> findByCategory(String category) {
        return null;
    }

    @Override
    public Flux<Product> findAll() {
        return null;
    }
}
