package com.ace.springbootPrac.repository;

import com.ace.springbootPrac.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, String> {

}
