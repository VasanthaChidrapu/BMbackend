package com.bookm.BookManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bookm.BookManagement.model.Genre;

public interface GenreRepository extends JpaRepository<Genre,Long> {

}
