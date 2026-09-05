package com.ace.springbootPrac.service;

import com.ace.springbootPrac.dto.BookDto;

import java.util.List;
import java.util.Optional;

public interface BookService {

    BookDto createUpdateBook(String isbn, BookDto bookDto);

    List<BookDto> findAll();

    Optional<BookDto> findBook(String isbn);

    boolean isExists(String isbn);
}
