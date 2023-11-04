package com.cnaturalr.infraestructure.driven_adapters.DBOAdapters;

import com.cnaturalr.domain.model.gateways.UserRepository;
import com.cnaturalr.domain.model.user.User;
import com.cnaturalr.infraestructure.driven_adapters.DBORepository.IUserDBORepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
@AllArgsConstructor
public class UserDBORepositoryAdapter implements UserRepository {

    private final IUserDBORepository repository;

    @Override
    public Mono<User> save(User user) {
        return null;
    }

    @Override
    public Mono<User> findById(Integer id) {
        return null;
    }

    @Override
    public Mono<User> update(User user) {
        return null;
    }

    @Override
    public Mono<User> delete(Integer id) {
        return null;
    }

    @Override
    public Mono<User> findByUsername(String name) {
        return null;
    }

    @Override
    public Mono<User> findByPassword(String password) {
        return null;
    }

    @Override
    public Mono<User> findByEmail(String email) {
        return null;
    }

    @Override
    public Mono<User> findByIdentification(Integer identification) {
        return null;
    }

    @Override
    public Mono<User> findByEmailAndPassword(String email, String password) {
        return null;
    }

    @Override
    public Flux<User> findAll() {
        return null;
    }

    @Override
    public Flux<User> saveAll(Flux<User> users) {
        return null;
    }
}
