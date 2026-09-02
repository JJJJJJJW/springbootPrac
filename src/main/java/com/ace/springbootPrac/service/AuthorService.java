package com.ace.springbootPrac.service;

import com.ace.springbootPrac.domain.Author;
import com.ace.springbootPrac.dto.AuthorDto;

public interface AuthorService {
    AuthorDto createAuthor(AuthorDto author);
}
