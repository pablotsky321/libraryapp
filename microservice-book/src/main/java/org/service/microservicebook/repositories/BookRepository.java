package org.service.microservicebook.repositories;

import org.service.microservicebook.entities.BookEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends MongoRepository<BookEntity,String> {

    @Query("{'commercial_information.isbn': ?0}")
    Optional<BookEntity> findByIsbn(String isbn);

}
