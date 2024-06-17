package org.service.microservicebooking.Requests_Responses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.service.microservicebooking.entities.BookingEntity;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreatedBookingResponse {

    private String message;
    private BookingEntity bookingEntity;

}
