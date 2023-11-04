package com.cnaturalr.infraestructure.entry_points.user;

import com.cnaturalr.domain.usecase.UserUseCase;
import com.cnaturalr.infraestructure.entry_points.user.dto.LoginDTO;
import com.cnaturalr.infraestructure.entry_points.user.dto.UserDTO;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@AllArgsConstructor
public class UserHandler {


    private final UserUseCase userUseCase;


    public Mono<ServerResponse> createUser(ServerRequest serverRequest) {
        return serverRequest
                .bodyToMono(UserDTO.class)
                .flatMap(userDTO -> userUseCase.createUser(userDTO)
                        .flatMap(savedUser -> ServerResponse
                                .status(HttpStatus.CREATED)
                                .bodyValue(savedUser)))
                .onErrorResume(exception -> ServerResponse
                        .badRequest()
                        .bodyValue("Error al crear el usuario. Error:  " + exception.getCause()));
    }

    public Mono<ServerResponse> getUserById(ServerRequest serverRequest) {
        System.out.println("Entrando a getUserById");
        int id = Integer.parseInt(serverRequest.pathVariable("id"));
        return userUseCase
                .getUserById(id)
                .flatMap(user -> ServerResponse
                        .ok()
                        .bodyValue(UserDTO.fromDomain(user)))
                .onErrorResume(exception -> ServerResponse
                        .status(HttpStatus.NOT_FOUND)
                        .bodyValue("Error al obtener el usuario. Error:  " + exception.getMessage()));
    }

    public Mono<ServerResponse> updateUser(ServerRequest serverRequest) {
        return serverRequest
                .bodyToMono(UserDTO.class)
                .flatMap(userDTO -> userUseCase.updateUser(userDTO)
                        .flatMap(savedUser -> ServerResponse
                                .status(HttpStatus.CREATED)
                                .bodyValue(savedUser)))
                .onErrorResume(exception -> ServerResponse
                        .badRequest()
                        .bodyValue("Error al actualizar el usuario. Error:  " + exception.getCause()));
    }

    public Mono<ServerResponse> deleteUser(ServerRequest serverRequest) {
        int id = Integer.parseInt(serverRequest.pathVariable("id"));
        return userUseCase
                .deleteUser(id)
                .flatMap(user -> ServerResponse
                        .ok()
                        .bodyValue(UserDTO.fromDomain(user)))
                .onErrorResume(exception -> ServerResponse
                        .status(HttpStatus.NOT_FOUND)
                        .bodyValue("Error al eliminar el usuario. Error:  " + exception.getMessage()));
    }

    public Mono<ServerResponse> getIdentification(ServerRequest serverRequest) {
        int identification = Integer.parseInt(serverRequest.pathVariable("identification"));
        return userUseCase
                .getIdentification(identification)
                .flatMap(user -> ServerResponse
                        .ok()
                        .bodyValue(UserDTO.fromDomain(user)))
                .onErrorResume(exception -> ServerResponse
                        .status(HttpStatus.NOT_FOUND)
                        .bodyValue("Error al obtener el usuario por cedula. Error:  " + exception.getMessage()));
    }

    public Mono<ServerResponse> getEmail(ServerRequest serverRequest) {
        String email = serverRequest.pathVariable("email");
        return userUseCase
                .getEmail(email)
                .flatMap(user -> ServerResponse
                        .ok()
                        .bodyValue(UserDTO.fromDomain(user)))
                .onErrorResume(exception -> ServerResponse
                        .status(HttpStatus.NOT_FOUND)
                        .bodyValue("Error al obtener el usuario por email. Error:  " + exception.getMessage()));
    }


    public Mono<ServerResponse> login(ServerRequest serverRequest){
        return serverRequest.bodyToMono(LoginDTO.class)
                .flatMap(loginDTO -> {
                    String email = loginDTO.getEmail();
                    String password = loginDTO.getPassword();
                    return userUseCase.getEmailAndPassword(email, password)
                            .flatMap(user -> ServerResponse.ok().bodyValue(UserDTO.fromDomain(user)))
                            .switchIfEmpty(ServerResponse.notFound().build());
                })
                .onErrorResume(exception -> ServerResponse.badRequest().bodyValue("Error al iniciar sesión. Error: " + exception.getMessage()));
    }

    public Mono<ServerResponse> getUsers(ServerRequest serverRequest){
        return userUseCase
                .getUsers()
                .collectList()
                .flatMap(users -> ServerResponse
                        .ok()
                        .bodyValue(users))
                .switchIfEmpty(ServerResponse
                        .status(HttpStatus.NO_CONTENT)
                        .bodyValue("No hay usuarios registrados"));

    }

}
