package org.service.microservicebooking.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.service.microservicebooking.DTOs.BookDTO;
import org.service.microservicebooking.DTOs.UserDTO;
import org.springframework.data.mongodb.core.mapping.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Bookings")
public class BookingEntity {

    @MongoId(targetType = FieldType.OBJECT_ID)
    private String id;
    @Field(name = "UserId")
    @DocumentReference(collection = "Users")
    private UserDTO user;
    @Field(name = "booksIds")
    @DocumentReference(collection = "Books")
    private List<BookDTO> books;
    @Field(name = "booking_date")
    private LocalDateTime bookingDate;
    @Field(name = "deadline")
    private LocalDateTime deadline;
    @Field(name = "return_date")
    private LocalDateTime returnDate;
    @Field(name = "penalty_fee")
    private double penaltyFee;

}
