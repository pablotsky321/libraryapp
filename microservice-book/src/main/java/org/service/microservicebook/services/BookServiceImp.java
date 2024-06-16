package org.service.microservicebook.services;

import org.service.microservicebook.DTOs.BookDTO;
import org.service.microservicebook.Requests_Responses.CreatedBookResponse;
import org.service.microservicebook.entities.BookEntity;
import org.service.microservicebook.repositories.AuthorRepository;
import org.service.microservicebook.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImp implements BookService{

    @Autowired
    BookRepository bookRepository;

    @Autowired
    AuthorRepository authorRepository;

    @Override
    public List<BookEntity> getAllBooks() {
        if(bookRepository.findAll().isEmpty()){
            return new ArrayList<BookEntity>();
        }else{
            return bookRepository.findAll();
        }
    }

    @Override
    public BookDTO getBookById(String id) {
        Optional<BookEntity> findBook = bookRepository.findById(id);
        if(findBook.isEmpty()){
            return BookDTO.builder().build();
        }else{
            return BookDTO
                    .builder()
                    .id(findBook.get().getId())
                    .title(findBook.get().getTitle())
                    .subtitle(findBook.get().getSubtitle())
                    .summary(findBook.get().getSummary())
                    .build();
        }
    }

    @Override
    public BookDTO getBookByIsbn(String isbn) {
        Optional<BookEntity> findBook = bookRepository.findByIsbn(isbn);
        if(findBook.isEmpty()){
            return BookDTO.builder().build();
        }else{
            return BookDTO
                    .builder()
                    .id(findBook.get().getId())
                    .title(findBook.get().getTitle())
                    .subtitle(findBook.get().getSubtitle())
                    .summary(findBook.get().getSummary())
                    .build();
        }
    }

    @Override
    public CreatedBookResponse createBook(BookEntity book) {
        if(bookRepository.findByIsbn(book.getComercialInformation().getIsbn()).isPresent()){
            return new CreatedBookResponse("book already exists",null);
        }else{
            return new CreatedBookResponse("book created",bookRepository.save(book));
        }
    }

    @Override
    public List<BookEntity> createBooks(List<BookEntity> books) {
        List<BookEntity> bookEntities = new ArrayList<BookEntity>();
        for(BookEntity book : books){
            if(bookRepository.findByIsbn(book.getComercialInformation().getIsbn()).isEmpty()){
                bookEntities.add(bookRepository.save(book));
            }
        }
        return bookEntities;
    }

    @Override
    public String updateBook(BookEntity book) {
        if(bookRepository.findByIsbn(book.getComercialInformation().getIsbn()).isEmpty()){
           return "book does not exist";
        }else{
            bookRepository.save(book);
            return "book updated";
        }
    }

    @Override
    public String deleteBook(String id) {
        if(bookRepository.findById(id).isEmpty()){
            return "book does not exist";
        }else{
            bookRepository.deleteById(id);
            return "book deleted";
        }
    }
}
