package com.bookm.BookManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookm.BookManagement.model.BookModel;

public interface BookRepository extends JpaRepository<BookModel,Long>{

}
