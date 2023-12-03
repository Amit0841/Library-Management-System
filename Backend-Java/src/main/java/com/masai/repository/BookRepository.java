package com.masai.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.model.Book;

public interface BookRepository extends JpaRepository<Book, Integer>{


}
