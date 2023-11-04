package com.cnaturalr.infraestructure.entry_points.product;

import com.cnaturalr.domain.usecase.ProductUseCase;
import com.cnaturalr.infraestructure.entry_points.product.dto.ProductDTO;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@AllArgsConstructor
public class ProductHandler {

    private final ProductUseCase productUseCase;

    public Mono<ServerResponse> createProduct(ServerRequest serverRequest) {
        System.out.println(serverRequest);
        return serverRequest
                .bodyToMono(ProductDTO.class)
                .flatMap(productDTO -> productUseCase.createProduct(productDTO)
                        .flatMap(savedProduct -> ServerResponse
                                .ok()
                                .bodyValue(savedProduct)))
                .onErrorResume(exception -> ServerResponse
                        .badRequest()
                        .bodyValue("Error al crear el producto. Error:  " + exception.getCause()));
    }

    public Mono<ServerResponse> getProducts(ServerRequest serverRequest) {
        return productUseCase
                .getProducts()
                .collectList()
                .flatMap(products -> ServerResponse
                        .ok()
                        .bodyValue(products))
                .switchIfEmpty(ServerResponse
                        .status(HttpStatus.NO_CONTENT)
                        .bodyValue("No hay productos registrados"));
    }

    public Mono<ServerResponse> findByName(ServerRequest serverRequest) {
        String name = serverRequest.pathVariable("name");
        return productUseCase
                .getProductByName(name)
                .collectList()
                .flatMap(products -> ServerResponse
                        .ok()
                        .bodyValue(products))
                .onErrorResume(exception -> ServerResponse
                        .badRequest()
                        .bodyValue("Error al obtener el producto. Error:  " + exception.getMessage()));
    }

    public Mono<ServerResponse> getProductById(ServerRequest serverRequest) {
        int id = Integer.parseInt(serverRequest.pathVariable("id"));
        return productUseCase
                .getProductById(id)
                .flatMap(product -> ServerResponse
                        .ok()
                        .bodyValue(ProductDTO.fromDomain(product)))
                .onErrorResume(exception -> ServerResponse
                        .badRequest()
                        .bodyValue("Error al obtener el producto. Error:  " + exception.getMessage()));
    }

    public Mono<ServerResponse> updateProduct(ServerRequest serverRequest) {
        return serverRequest
                .bodyToMono(ProductDTO.class)
                .flatMap(productDTO -> productUseCase.updateProduct(productDTO.toDomain())
                        .flatMap(savedProduct -> ServerResponse
                                .ok()
                                .bodyValue(savedProduct)))
                .onErrorResume(exception -> ServerResponse
                        .badRequest()
                        .bodyValue("Error al actualizar el producto. Error:  " + exception.getMessage()));
    }

    public Mono<ServerResponse> deleteProduct(ServerRequest serverRequest) {
        int id = Integer.parseInt(serverRequest.pathVariable("id"));
        return productUseCase
                .deleteProduct(id)
                .flatMap(product -> ServerResponse
                        .ok()
                        .bodyValue(product))
                .onErrorResume(exception -> ServerResponse
                        .badRequest()
                        .bodyValue("Error al eliminar el producto. Error:  " + exception.getMessage()));
    }

}
