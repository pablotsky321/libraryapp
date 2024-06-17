package org.service.microservicebooking.controllers;

import org.service.microservicebooking.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/booking")
public class BookingController {

    @Autowired
    BookingService bookingService;

    @GetMapping("/allBookings")
    public ResponseEntity<?> getAll(){
        try{
            return new ResponseEntity<>(bookingService.getAllBookings(),HttpStatus.ACCEPTED);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/BookingById/{id}")
    public ResponseEntity<?> getBookingById(@PathVariable(value = "id") String id){
        try{
            return new ResponseEntity<>(bookingService.getBookingById(id),HttpStatus.ACCEPTED);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/BookingsByUser")
    public ResponseEntity<?> getUserBookings(@RequestParam(value = "userId") String userId){
        try{
            return new ResponseEntity<>(bookingService.getBookingsByUserId(userId),HttpStatus.ACCEPTED);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
