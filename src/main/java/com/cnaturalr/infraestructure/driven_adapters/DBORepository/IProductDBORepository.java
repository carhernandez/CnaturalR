package com.cnaturalr.infraestructure.driven_adapters.DBORepository;

import com.cnaturalr.infraestructure.driven_adapters.entity.ProductDBO;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface IProductDBORepository extends ReactiveCrudRepository<ProductDBO, Integer > {

    Flux<ProductDBO> findByName(String name);
}
