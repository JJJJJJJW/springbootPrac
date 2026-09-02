package com.ace.springbootPrac.service.impl;

import com.ace.springbootPrac.domain.Author;
import com.ace.springbootPrac.dto.AuthorDto;
import com.ace.springbootPrac.repository.AuthorRepository;
import com.ace.springbootPrac.service.AuthorService;
import org.springframework.stereotype.Service;

@Service
public class AuthorServiceImpl implements AuthorService {

    private AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public AuthorDto createAuthor(AuthorDto author) {
        Author authorEntity = new Author(author.getId(),author.getName(),author.getAge());
        authorEntity = authorRepository.save(authorEntity);
        return AuthorDto.fromEntity(authorEntity);
    }

}
