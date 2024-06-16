package org.service.microserviceuser.repositories;

import org.service.microserviceuser.entities.UserEntity;
import org.springframework.data.mongodb.repository.DeleteQuery;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<UserEntity,String> {

    Optional<UserEntity> findByDoc(String doc);

    Optional<UserEntity> findByEmail(String email);

}
