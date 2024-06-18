package org.service.microservicebooking.Requests_Responses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.service.microservicebooking.entities.BookingEntity;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateBookingRequest {

    private BookingEntity bookingEntity;
    private List<String> booksIds;

}
