package com.ace.springbootPrac.controller;

import com.ace.springbootPrac.dto.BookDto;
import com.ace.springbootPrac.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PutMapping("/books/{isbn}")
    public ResponseEntity<BookDto> createUpdateBook(
            @PathVariable("isbn") String isbn,
            @RequestBody BookDto bookDto){

            if(bookService.isExists(isbn)){
                return new ResponseEntity<>(bookService.createUpdateBook(isbn,bookDto), HttpStatus.OK);
            }else {
                return new ResponseEntity<>(bookService.createUpdateBook(isbn,bookDto), HttpStatus.CREATED);
            }

    }

    @GetMapping(path = "/books")
    public List<BookDto> listBooks(){
        return bookService.findAll();
    }

    @GetMapping(path = "/books/{isbn}")
    public ResponseEntity<BookDto> getBook(@PathVariable("isbn") String isbn){
        return bookService.findBook(isbn)
                .map(BookDto -> ResponseEntity
                        .status(HttpStatus.OK)
                        .body(BookDto)
                ).orElseGet(() -> ResponseEntity.notFound().build());
    }

}
