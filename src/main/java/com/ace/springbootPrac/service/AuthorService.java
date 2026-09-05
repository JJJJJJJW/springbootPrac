package com.ace.springbootPrac.service;

import com.ace.springbootPrac.dto.AuthorDto;

import java.util.List;
import java.util.Optional;

public interface AuthorService {
    AuthorDto saveAuthor(AuthorDto authorDto);

    List<AuthorDto> findAll();

    Optional<AuthorDto> findAuthor(Long id);

    boolean isExists(Long id);

    AuthorDto partialUpdate(Long id, AuthorDto authorDto);

    void delete(Long id);
}
