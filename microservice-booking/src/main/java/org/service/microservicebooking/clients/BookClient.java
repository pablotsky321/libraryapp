package org.service.microservicebooking.clients;

import org.service.microservicebooking.DTOs.BookDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "microservice-book",url="http://localhost:8091")
public interface BookClient {

    @GetMapping("/api/book/findBookById/{bookId}")
    BookDTO findBook(@PathVariable("bookId") String bookId);

}
