package com.tcs.springbootdemo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tcs.springbootdemo.model.Book;


@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
	Optional<Book> findByIsnb(String isbn);
}
