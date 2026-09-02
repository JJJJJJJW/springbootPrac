package com.ace.springbootPrac.service;

import com.ace.springbootPrac.dto.BookDto;

public interface BookService {

    BookDto createBook(String isbn, BookDto bookDto);

}
