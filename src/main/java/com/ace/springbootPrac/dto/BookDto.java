package com.ace.springbootPrac.dto;

import com.ace.springbootPrac.domain.Author;
import com.ace.springbootPrac.domain.Book;
import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class BookDto {

    private String isbn;

    private String title;

    private AuthorDto author;

    public static BookDto fromEntity(Book book){
        BookDto bookDto = new BookDto();
        bookDto.isbn = book.getIsbn();
        bookDto.title = book.getTitle();
        if (book.getAuthor() != null) {
            bookDto.author = AuthorDto.fromEntity(book.getAuthor());
        }

        return bookDto;
    }
}
