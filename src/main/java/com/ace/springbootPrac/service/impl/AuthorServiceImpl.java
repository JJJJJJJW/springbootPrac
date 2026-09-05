package com.ace.springbootPrac.service.impl;

import com.ace.springbootPrac.domain.Author;
import com.ace.springbootPrac.dto.AuthorDto;
import com.ace.springbootPrac.repository.AuthorRepository;
import com.ace.springbootPrac.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public AuthorDto saveAuthor(AuthorDto authorDto) {
        Author authorEntity = new Author(authorDto.getId(),authorDto.getName(),authorDto.getAge());
        Author savedAuthorEntity = authorRepository.save(authorEntity);
        return AuthorDto.fromEntity(savedAuthorEntity);
    }

    @Override
    public List<AuthorDto> findAll() {
        List<Author> authors = authorRepository.findAll();
        return authors.stream()
                .map(AuthorDto::fromEntity)
                .toList();
    }

    @Override
    public Optional<AuthorDto> findAuthor(Long id) {
        return authorRepository.findById(id)
                .map(AuthorDto::fromEntity);
    }

    @Override
    public boolean isExists(Long id) {
        return authorRepository.existsById(id);
    }

    @Override
    public AuthorDto partialUpdate(Long id, AuthorDto authorDto) {
        authorDto.setId(id);
        return authorRepository.findById(id)
            .map(existingAuthor->{
                Optional.ofNullable(authorDto.getName()).ifPresent(existingAuthor::setName);
                Optional.ofNullable(authorDto.getAge()).ifPresent(existingAuthor::setAge);
                return AuthorDto.fromEntity(authorRepository.save(existingAuthor));
            }).orElseThrow(()->new RuntimeException("Author does not exist"));
    }

    @Override
    public void delete(Long id) {
        authorRepository.deleteById(id);
    }

}
