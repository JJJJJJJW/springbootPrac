package com.ace.springbootPrac.controller;

import com.ace.springbootPrac.domain.Book;
import com.ace.springbootPrac.dto.BookDto;
import com.ace.springbootPrac.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PutMapping("/books/{isbn}")
    public ResponseEntity<BookDto> createBook(
            @PathVariable("isbn") String isbn,
            @RequestBody BookDto bookDto){

            return new ResponseEntity<>(bookService.createBook(isbn,bookDto), HttpStatus.CREATED);

    }
}
