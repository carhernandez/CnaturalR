package com.cnaturalr.application.configuration;

import com.cnaturalr.domain.model.gateways.ProductRepository;
import com.cnaturalr.domain.model.gateways.UserRepository;
import com.cnaturalr.domain.usecase.ProductUseCase;
import com.cnaturalr.domain.usecase.UserUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseBeanConfig {

    @Bean
    public UserUseCase userUseCase(UserRepository userRepository) {

        return new UserUseCase(userRepository);
    }

    @Bean
    public ProductUseCase productUseCase(ProductRepository productRepository) {
        return new ProductUseCase(productRepository);
    }


}
