package org.service.microservicebooking.services;

import org.service.microservicebooking.DTOs.UserDTO;
import org.service.microservicebooking.Requests_Responses.CreatedBookingResponse;
import org.service.microservicebooking.entities.BookingEntity;

import java.util.List;

public interface BookingService {

    List<BookingEntity> getAllBookings();

    BookingEntity getBookingById(String id);

    String returnBooks(String userId);

    CreatedBookingResponse createBooking(BookingEntity bookingEntity, String userId, List<String> booksIds);

    List<BookingEntity> getBookingsByUserId(String userId);

}
