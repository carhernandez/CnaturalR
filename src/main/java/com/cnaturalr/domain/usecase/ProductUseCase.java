package com.cnaturalr.domain.usecase;

import com.cnaturalr.domain.model.gateways.ProductRepository;
import com.cnaturalr.domain.model.product.Product;
import com.cnaturalr.infraestructure.entry_points.product.dto.ProductDTO;
import lombok.AllArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@AllArgsConstructor
public class ProductUseCase {

    private final ProductRepository productRepository;


    public Mono<Product> createProduct(ProductDTO productDTO) {
        Product product = productDTO.toDomain();
        return productRepository.save(product);
    }

    public Mono<Product> getProductById(Integer id) {
        return productRepository.findById(id);
    }

    public Mono<Product> updateProduct(Product product) {
        return productRepository.update(product);
    }

    public Mono<Product> deleteProduct(Integer id) {
        return productRepository.delete(id);
    }

    public Flux<Product> getProductByName(String name) {
        return productRepository.findByName(name);
    }

    public Mono<Product> getProductByDescription(String description) {
        return productRepository.findByDescription(description);
    }

    public Mono<Product> getProductByPrice(Double price) {
        return productRepository.findByPrice(price);
    }

    public Flux<Product> getProducts() {
        return productRepository.findAll();
    }


}
