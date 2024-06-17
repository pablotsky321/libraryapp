package org.service.microservicebooking.repositories;

import org.service.microservicebooking.entities.BookingEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface BookingRepository extends MongoRepository<BookingEntity,String> {

    List<BookingEntity> findByUserId(String userId);

    @Query(sort = "{booking_date: -1}",value = "{UserId:?0}")
    Optional<BookingEntity> findLastByUserId(String userId);

}
