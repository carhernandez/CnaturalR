package com.cnaturalr.infraestructure.driven_adapters.DBORepository;

import com.cnaturalr.infraestructure.driven_adapters.entity.UserDBO;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserDBORepository extends ReactiveCrudRepository<UserDBO, Integer > {


}
