package org.service.microservicebooking.repositories;

import org.service.microservicebooking.entities.BookingEntity;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface BookingRepository extends MongoRepository<BookingEntity,String> {

    List<BookingEntity> findByUserId(String userId);

    @Query(value = "{'UserId': ?0}", sort = "{'booking_date': -1}")
    List<BookingEntity> returnLastByUserId(String userId, Pageable pageable);

    default Optional<BookingEntity> findLastByUser(String userId) {
        Pageable pageable = PageRequest.of(0, 1);
        List<BookingEntity> results = returnLastByUserId(userId, pageable);
        return results.isEmpty() ? Optional.empty() : Optional.of(results.get(0));
    }

}
