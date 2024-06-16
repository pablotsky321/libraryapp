package org.service.microservicebook.repositories;

import org.service.microservicebook.entities.AuthorEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AuthorRepository extends MongoRepository<AuthorEntity,String> {

}
