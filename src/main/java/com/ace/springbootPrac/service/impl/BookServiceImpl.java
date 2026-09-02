package com.ace.springbootPrac.service.impl;

import com.ace.springbootPrac.domain.Book;
import com.ace.springbootPrac.dto.AuthorDto;
import com.ace.springbootPrac.dto.BookDto;
import com.ace.springbootPrac.repository.BookRepository;
import com.ace.springbootPrac.service.BookService;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {


    private BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public BookDto createBook(String isbn, BookDto bookDto) {
        Book bookEntity = new Book(bookDto.getIsbn(),bookDto.getTitle());
        bookEntity.setIsbn(isbn);
        bookEntity = bookRepository.save(bookEntity);
        return BookDto.fromEntity(bookEntity);
    }
}
