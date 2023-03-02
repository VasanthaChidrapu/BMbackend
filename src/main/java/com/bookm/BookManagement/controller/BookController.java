package com.bookm.BookManagement.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookm.BookManagement.model.BookModel;
import com.bookm.BookManagement.model.Genre;
import com.bookm.BookManagement.model.Publisher;
import com.bookm.BookManagement.repository.GenreRepository;
import com.bookm.BookManagement.repository.PublisherRepository;
import com.bookm.BookManagement.service.BookService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
//@CrossOrigin(origins = "http://localhost:4200")
public class BookController {
	@Autowired
	private BookService bookService;

	@PostMapping("/books/{genereId}/{publisherId}")
	public ResponseEntity<BookModel> addBook(@PathVariable Long publisherId, @PathVariable Long genereId,
			@RequestBody BookModel book) {
		BookModel savedBook = bookService.addBook(genereId, publisherId, book);
		return new ResponseEntity<>(savedBook, HttpStatus.CREATED);
	}

	@GetMapping("/books/{id}")
	public ResponseEntity<BookModel> getBookById(@PathVariable(value = "id") Long book_id) {
		BookModel book = bookService.getBookById(book_id);
		if (book == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(book, HttpStatus.OK);
	}

	@GetMapping("/books")
	public ResponseEntity<List<BookModel>> getAllBooks() {
		List<BookModel> books = bookService.getAllBooks();
		return new ResponseEntity<>(books, HttpStatus.OK);
	}

	@DeleteMapping("/books/{id}")
	public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
		bookService.deleteBook(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

//    @DeleteMapping("/deleteAll/")
//    public ResponseEntity<Void> deleteAllBooks() {
//        bookService.deleteAllBooks();
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//    }
	@PutMapping("/books/{id}")
	public ResponseEntity<BookModel> updateBook(@PathVariable Long id, @RequestBody BookModel book) {
		book.setBook_id(id);
		BookModel updatedBook = bookService.updateBook(book);
		return new ResponseEntity<>(updatedBook, HttpStatus.OK);
	}

	@Autowired
	private GenreRepository genreRepository;
	@Autowired
	private PublisherRepository publisherRepository;

	@GetMapping("/genres")
	public List<Genre> getAllGenres() {
		return genreRepository.findAll();
	}

	@GetMapping("/publishers")
	public List<Publisher> getAllPublishers() {
		return publisherRepository.findAll();
	}

	@PostMapping("/genres")
	public Genre addGenre(@RequestBody Genre genre) {
		return genreRepository.save(genre);
	}

	@PostMapping("/publishers")
	public Publisher addPublisher(@RequestBody Publisher publisher) {
		return publisherRepository.save(publisher);
	}

}
