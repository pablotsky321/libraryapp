package org.service.microservicebook.controllers;

import org.service.microservicebook.entities.AuthorEntity;
import org.service.microservicebook.entities.BookEntity;
import org.service.microservicebook.services.AuthorService;
import org.service.microservicebook.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/book")
public class BookController {

    @Autowired
    BookService bookService;

    @Autowired
    AuthorService authorService;

    //Author's routes
    @GetMapping("/allAuthors")
    public ResponseEntity<?> findAllAuthors(){
        try {
            return new ResponseEntity<>(authorService.getAllAuthors(), HttpStatus.ACCEPTED);
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/findAuthorById/{id}")
    public ResponseEntity<?> findAuthorById(@PathVariable(value = "id") String id){
        try {
            return new ResponseEntity<>(authorService.getAuthorById(id), HttpStatus.ACCEPTED);
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/insertAuthor")
    public ResponseEntity<?> insertAuthor(@RequestBody AuthorEntity author){
        try {
            return new ResponseEntity<>(authorService.createAuthor(author), HttpStatus.ACCEPTED);
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/insertAuthors")
    public ResponseEntity<?> insertAuthors(@RequestBody List<AuthorEntity> authors){
        try {
            return new ResponseEntity<>(authorService.createAuthors(authors), HttpStatus.ACCEPTED);
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/updateAuthor")
    public ResponseEntity<?> updateAuthor(@RequestBody AuthorEntity author){
        try {
            return new ResponseEntity<>(authorService.updateAuthor(author), HttpStatus.ACCEPTED);
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/deleteAuthor/{id}")
    public ResponseEntity<?> deleteAuthor(@PathVariable(value = "id") String id){
        try {
            return new ResponseEntity<>(authorService.deleteAuthor(id), HttpStatus.ACCEPTED);
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //Book's routes
    @GetMapping("/allBooks")
    public ResponseEntity<?> findAllBooks(){
        try {
            return new ResponseEntity<>(bookService.getAllBooks(), HttpStatus.ACCEPTED);
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/findBookById/{id}")
    public ResponseEntity<?> findBookById(@PathVariable(value = "id") String id){
        try {
            return new ResponseEntity<>(bookService.getBookById(id), HttpStatus.ACCEPTED);
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/findBookByIsbn")
    public ResponseEntity<?> findAllBooks(@RequestParam(value = "isbn") String isbn){
        try {
            return new ResponseEntity<>(bookService.getBookByIsbn(isbn), HttpStatus.ACCEPTED);
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/insertBook")
    public ResponseEntity<?> insertBook(@RequestBody BookEntity book){
        try {
            return new ResponseEntity<>(bookService.createBook(book), HttpStatus.ACCEPTED);
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/insertBooks")
    public ResponseEntity<?> insertBooks(@RequestBody List<BookEntity> books){
        try {
            return new ResponseEntity<>(bookService.createBooks(books), HttpStatus.ACCEPTED);
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/updateBook")
    public ResponseEntity<?> updateBook(@RequestBody BookEntity book){
        try {
            return new ResponseEntity<>(bookService.updateBook(book), HttpStatus.ACCEPTED);
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/deleteBook/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable(value = "id") String id){
        try {
            return new ResponseEntity<>(bookService.deleteBook(id), HttpStatus.ACCEPTED);
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/reduceStock/{id}")
    public ResponseEntity<?> reduceStock(@PathVariable("id") String id){
        try{
            bookService.reduceStock(id);
            return ResponseEntity.ok("Stock reduced");
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/plusStock/{id}")
    public ResponseEntity<?> plusStock(@PathVariable("id") String id){
        try{
            bookService.plusStock(id);
            return ResponseEntity.ok("Stock reduced");
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
