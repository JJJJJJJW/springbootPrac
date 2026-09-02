package com.ace.springbootPrac.repository;

import com.ace.springbootPrac.domain.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

    Iterable<Author> ageLessThan(Integer age);

    @Query("SELECT a FROM Author a where a.age > ?1")
    Iterable<Author> findAuthorsWithAgeGreaterThan(Integer age);

}
