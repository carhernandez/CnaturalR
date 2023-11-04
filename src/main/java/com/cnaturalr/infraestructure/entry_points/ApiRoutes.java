package com.cnaturalr.infraestructure.entry_points;

import com.cnaturalr.infraestructure.entry_points.user.UserHandler;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static javax.management.Query.and;
import static org.springframework.web.reactive.function.server.RequestPredicates.*
        ;

@Configuration
@CrossOrigin(origins = "*")
public class ApiRoutes {

    @Value("${PATH_BASE}")
    private String pathBase;


    @Bean
    public RouterFunction<ServerResponse> userFunctionalEndpointa(UserHandler handler) {
        String param = "/users";
        return RouterFunctions
                .route(POST(pathBase.concat(param)).and(accept(MediaType.APPLICATION_JSON)), handler::createUser)
                .andRoute(GET(pathBase.concat(param)).and(accept(MediaType.APPLICATION_JSON)), handler::getUsers)
                .andRoute(GET(pathBase.concat(param).concat("/id/{id}")).and(accept(MediaType.APPLICATION_JSON)), handler::getUserById)
                .andRoute(PUT(pathBase.concat(param).concat("/id/{id}")).and(accept(MediaType.APPLICATION_JSON)), handler::updateUser)
                .andRoute(DELETE(pathBase.concat(param).concat("/{id}")).and(accept(MediaType.APPLICATION_JSON)), handler::deleteUser)
                .andRoute(POST(pathBase.concat(param).concat("/login")).and(accept(MediaType.APPLICATION_JSON)),handler::login)
                .andRoute(GET(pathBase.concat(param).concat("/{email}")).and(accept(MediaType.APPLICATION_JSON)),handler::getEmail)
                .andRoute(GET(pathBase.concat(param).concat("/identification/{identification}")).and(accept(MediaType.APPLICATION_JSON)),handler::getIdentification);
    }

    @Bean
    CorsWebFilter corsFilter() {

        CorsConfiguration config = new CorsConfiguration();

        // Possibly...
        // config.applyPermitDefaultValues()

        config.setAllowCredentials(true);
        config.addAllowedOrigin("http://localhost:4200");
        config.addAllowedHeader("*");
        config.addAllowedMethod("*");

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);

        return new CorsWebFilter(source);
    }
}
