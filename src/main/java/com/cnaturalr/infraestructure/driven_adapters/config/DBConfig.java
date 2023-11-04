package com.cnaturalr.infraestructure.driven_adapters.config;

import io.r2dbc.postgresql.PostgresqlConnectionConfiguration;
import io.r2dbc.postgresql.PostgresqlConnectionFactory;
import io.r2dbc.spi.ConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.r2dbc.config.AbstractR2dbcConfiguration;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;

import java.util.Objects;

@Configuration
@EnableR2dbcRepositories
public class DBConfig extends AbstractR2dbcConfiguration {

//    @Bean
//    public DBSecret secret(Environment environment) {
//        return new DBSecret(
//                environment.getProperty("spring.datasource.username"),
//                environment.getProperty("spring.datasource.password"),
//                environment.getProperty("spring.datasource.host"),
//                Integer.parseInt(Objects.requireNonNull(environment.getProperty("spring.datasource.port"))),
//                environment.getProperty("spring.datasource.database")
//        );
//    }


    @Override
    @Bean
    public ConnectionFactory connectionFactory() {
        return new PostgresqlConnectionFactory(PostgresqlConnectionConfiguration
                .builder()
                .host("localhost")
                .port(5432)
                .database("CNatural")
                .username("postgres")
                .password("Edilma5422*")
                .build());
    }
}
