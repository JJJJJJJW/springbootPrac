package com.ace.springbootPrac.service.impl;

import com.ace.springbootPrac.domain.Book;
import com.ace.springbootPrac.dto.AuthorDto;
import com.ace.springbootPrac.dto.BookDto;
import com.ace.springbootPrac.repository.BookRepository;
import com.ace.springbootPrac.service.BookService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public BookDto createUpdateBook(String isbn, BookDto bookDto) {
        Book bookEntity = new Book(bookDto.getIsbn(),bookDto.getTitle());
        bookEntity.setIsbn(isbn);
        if (bookDto.getAuthor() != null) {
            bookEntity.setAuthor(AuthorDto.fromDto(bookDto.getAuthor()));
        }
        Book savedBookEntity = bookRepository.save(bookEntity);
        return BookDto.fromEntity(savedBookEntity);
    }

    @Override
    public List<BookDto> findAll() {
        List<Book> books = bookRepository.findAll();
        return books.stream()
                .map(BookDto::fromEntity)
                .toList();
    }

    @Override
    public Page<Book> findAll(Pageable pageable) {
        return bookRepository.findAll(pageable);
    }

    @Override
    public Optional<BookDto> findBook(String isbn) {
        return bookRepository.findById(isbn)
                .map(BookDto::fromEntity);
    }

    @Override
    public boolean isExists(String isbn) {
        return bookRepository.existsById(isbn);
    }

    @Override
    public BookDto partialUpdate(String isbn, BookDto bookDto) {
        bookDto.setIsbn(isbn);
        return bookRepository.findById(isbn)
                .map(existingBook -> {
                    Optional.ofNullable(bookDto.getTitle()).ifPresent(existingBook::setTitle);
                    return BookDto.fromEntity(bookRepository.save(existingBook));
                }).orElseThrow(() -> new RuntimeException("Book not found") );
    }

    @Override
    public void delete(String isbn) {
        bookRepository.deleteById(isbn);
    }
}
