package org.service.microservicebooking.clients;

import org.service.microservicebooking.DTOs.BookDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.Optional;


@FeignClient(name = "microservice-book",url="http://localhost:8091")
public interface BookClient {

    @GetMapping("/api/book/findBookById/{bookId}")
    Optional<BookDTO> findBook(@PathVariable("bookId") String bookId);

    @PutMapping("/api/book/reduceStock/{bookId}")
    void reduceStock(@PathVariable(value = "bookId") String bookId);

    @PutMapping("/api/book/plusStock/{bookId}")
    void plusStock(@PathVariable(value = "bookId") String bookId);

}
