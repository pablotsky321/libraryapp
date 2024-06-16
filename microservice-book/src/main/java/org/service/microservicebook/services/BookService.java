package org.service.microservicebook.services;

import org.service.microservicebook.DTOs.BookDTO;
import org.service.microservicebook.Requests_Responses.CreatedBookResponse;
import org.service.microservicebook.entities.BookEntity;

import java.util.List;

public interface BookService {

    List<BookEntity> getAllBooks();

    BookDTO getBookById(String id);

    BookDTO getBookByIsbn(String isbn);

    CreatedBookResponse createBook(BookEntity book);

    List<BookEntity> createBooks(List<BookEntity> books);

    String updateBook(BookEntity book);

    String deleteBook(String id);


}
