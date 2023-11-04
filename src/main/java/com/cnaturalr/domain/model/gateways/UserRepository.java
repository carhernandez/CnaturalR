package com.cnaturalr.domain.model.gateways;

import com.cnaturalr.domain.model.user.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


public interface UserRepository {

Mono<User> save(User user);

Mono<User> findById(Integer id);

Mono<User> update(User user);

Mono<User> delete(Integer id);

Mono<User> findByUsername(String name);

Mono<User> findByPassword(String password);

Mono<User> findByEmail(String email);

Mono<User> findByIdentification(Integer identification);

Mono<User> findByEmailAndPassword(String email, String password);

Flux<User> findAll();

Flux<User> saveAll(Flux<User> users);


}
