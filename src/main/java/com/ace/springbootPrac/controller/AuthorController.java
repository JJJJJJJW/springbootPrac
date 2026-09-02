package com.ace.springbootPrac.controller;

import com.ace.springbootPrac.domain.Author;
import com.ace.springbootPrac.dto.AuthorDto;
import com.ace.springbootPrac.service.AuthorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthorController {

    private AuthorService authorService;

    public AuthorController(AuthorService authorService){
        this.authorService = authorService;
    }

    @PostMapping(path = "/authors")
    public ResponseEntity<AuthorDto> createAuthor(@RequestBody AuthorDto author){

        return new ResponseEntity<>(authorService.createAuthor(author), HttpStatus.CREATED);

    }

}
