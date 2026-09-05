package com.ace.springbootPrac.dto;

import com.ace.springbootPrac.domain.Author;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class AuthorDto {

    private Long id;

    private String name;

    private Integer age;

    public static AuthorDto fromEntity(Author author){
        AuthorDto authorDto = new AuthorDto();
        authorDto.id = author.getId();
        authorDto.name = author.getName();
        authorDto.age = author.getAge();

        return authorDto;
    }

    public static Author fromDto(AuthorDto authorDto){
        Author author = new Author();
        author.setId(authorDto.getId());
        author.setName(authorDto.getName());
        author.setAge(authorDto.getAge());

        return author;
    }

}
