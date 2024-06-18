package org.service.microservicebooking.services;

import org.service.microservicebooking.DTOs.BookDTO;
import org.service.microservicebooking.DTOs.UserDTO;
import org.service.microservicebooking.Requests_Responses.CreatedBookingResponse;
import org.service.microservicebooking.clients.BookClient;
import org.service.microservicebooking.clients.UserClient;
import org.service.microservicebooking.entities.BookingEntity;
import org.service.microservicebooking.repositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookingServiceImp implements BookingService{

    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    UserClient userClient;

    @Autowired
    BookClient bookClient;

    @Override
    public List<BookingEntity> getAllBookings() {
        if(bookingRepository.findAll().isEmpty()){
            return new ArrayList<BookingEntity>();
        }else{
            return bookingRepository.findAll();
        }
    }

    @Override
    public BookingEntity getBookingById(String id) {
        if(bookingRepository.findById(id).isEmpty()){
            return new BookingEntity();
        }else{
            return bookingRepository.findById(id).get();
        }
    }

    @Override
    public String returnBooks(String userId) {
        if(bookingRepository.findLastByUser(userId).isEmpty() || bookingRepository.findLastByUser(userId).get().isReturned()){
            return "books were not returned";
        }else{
            BookingEntity booking = bookingRepository.findLastByUser(userId).get();
            booking.setReturned(true);
            for(BookDTO book:booking.getBooks()){
                if(bookClient.findBook(book.getId()).isPresent()){
                    bookClient.plusStock(book.getId());
                }
            }
            booking.setReturnDate(LocalDateTime.now());
            bookingRepository.save(booking);
            return "Books returned";
        }
    }

    @Override
    public CreatedBookingResponse createBooking(BookingEntity booking, String userId, List<String> booksIds) {
        Optional<UserDTO> userFind = userClient.getUserById(userId);
        Optional<BookingEntity> bookingFind = bookingRepository.findLastByUser(userId);
        if(bookingFind.isPresent()) {
            if (userFind.isEmpty() || (bookingFind.get().isHas_penalty_fee() && bookingFind.get().getAmountpaid() < bookingFind.get().getPenaltyFee()) || !bookingFind.get().isReturned()) {
                return new CreatedBookingResponse("Booking wasn't done", null);
            } else {
                return new CreatedBookingResponse("Booking was made",addBooking(booking,userFind.get(),booksIds));
            }
        }else{
            return new CreatedBookingResponse("Booking was made",addBooking(booking,userFind.get(),booksIds));
        }
    }

    private BookingEntity addBooking(BookingEntity booking,UserDTO userFind,List<String> booksIds){
        List<BookDTO> books = new ArrayList<>();
        booking.setUser(userFind);
        for (String bookId : booksIds) {
            if (bookClient.findBook(bookId).isPresent()) {
                books.add(bookClient.findBook(bookId).get());
                bookClient.reduceStock(bookId);
            }
        }
        booking.setBooks(books);
        booking.setBookingDate(LocalDateTime.now());
        booking.setDeadline(LocalDateTime.now().plusMonths(3));
        booking.setReturnDate(null);
        booking.setAmountpaid(0);
        booking.setReturned(false);
        booking.setPenaltyFee(0);
        booking.setHas_penalty_fee(false);
        return bookingRepository.save(booking);
    }

    @Override
    public List<BookingEntity> getBookingsByUserId(String userId) {
        if(bookingRepository.findByUserId(userId).isEmpty()){
            return new ArrayList<>();
        }else{
            return bookingRepository.findByUserId(userId);
        }
    }
}
