package com.cnaturalr.domain.usecase;

import com.cnaturalr.domain.model.gateways.UserRepository;
import com.cnaturalr.domain.model.user.User;
import com.cnaturalr.infraestructure.entry_points.user.dto.UserDTO;
import lombok.AllArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@AllArgsConstructor
public class UserUseCase {

    private final UserRepository userRepository;

    public Mono<User> createUser(UserDTO userDTO) {
        User user = userDTO.toDomain();
        return userRepository.save(user);
    }

    public Mono<User> getUserById(Integer id) {
        return userRepository.findById(id);
    }

    public Mono<User> updateUser(UserDTO userDTO) {
        User user = userDTO.toDomain();
        return userRepository.update(user);
    }

    public Mono<User> deleteUser(Integer id) {
        return userRepository.delete(id);
    }

    public Flux<User> getUsers() {
        return userRepository.findAll();
    }

    public Mono<User> getEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public Mono<User> getIdentification(Integer identification) {
        return userRepository.findByIdentification(identification);
    }

    public Mono<User> getEmailAndPassword(String email, String password) {
        return userRepository.findByEmailAndPassword(email, password);
    }


}
