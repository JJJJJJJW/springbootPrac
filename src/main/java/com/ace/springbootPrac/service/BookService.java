package com.ace.springbootPrac.service;

import com.ace.springbootPrac.domain.Book;
import com.ace.springbootPrac.dto.BookDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface BookService {

    BookDto createUpdateBook(String isbn, BookDto bookDto);

    List<BookDto> findAll();

    Page<Book> findAll(Pageable pageable);

    Optional<BookDto> findBook(String isbn);

    boolean isExists(String isbn);

    BookDto partialUpdate(String isbn, BookDto bookDto);

    void delete(String isbn);
}
