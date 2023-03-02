package com.bookm.BookManagement.service;

import java.util.List;

import com.bookm.BookManagement.model.BookModel;
import com.bookm.BookManagement.model.Genre;
import com.bookm.BookManagement.model.Publisher;

public interface BookService {
	public BookModel addBook(Long genereId, Long publisherId, BookModel book);

	public BookModel getBookById(Long book_id);

	public List<BookModel> getAllBooks();

	public void deleteBook(Long book_id);

	public BookModel updateBook(BookModel book);

	// public void deleteAllBooks();
	public List<Genre> getAllGenres();

	public List<Publisher> getAllPublishers();

}
