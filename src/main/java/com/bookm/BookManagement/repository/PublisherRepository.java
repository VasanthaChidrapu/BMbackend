package com.bookm.BookManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bookm.BookManagement.model.Publisher;

public interface PublisherRepository extends JpaRepository<Publisher,Long>{

}
