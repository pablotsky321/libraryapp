package org.service.microservicebooking.repositories;

import org.service.microservicebooking.DTOs.BookDTO;
import org.service.microservicebooking.DTOs.UserDTO;
import org.service.microservicebooking.entities.BookingEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface BookingRepository extends MongoRepository<BookingEntity,String> {

    List<BookingEntity> findByUserId(String userId);

}
