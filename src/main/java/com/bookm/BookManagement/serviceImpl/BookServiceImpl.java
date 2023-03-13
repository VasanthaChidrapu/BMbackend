package com.bookm.BookManagement.serviceImpl;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookm.BookManagement.model.BookModel;
import com.bookm.BookManagement.model.Genre;
import com.bookm.BookManagement.model.Publisher;
import com.bookm.BookManagement.repository.BookRepository;
import com.bookm.BookManagement.repository.GenreRepository;
import com.bookm.BookManagement.repository.PublisherRepository;
import com.bookm.BookManagement.service.BookService;

@Service
public class BookServiceImpl implements BookService {
	@Autowired
	private BookRepository bookRepository;
	@Autowired
	private GenreRepository genreRepository;
	@Autowired
	private PublisherRepository publisherRepository;
	@Autowired
	private EntityManager entityManager;

	@Override
	public BookModel addBook(Long genereId, Long publisherId, BookModel book) {
		Publisher publisher = publisherRepository.findById(publisherId).get();
		Genre genre = genreRepository.findById(genereId).get();
		book.setPublisher(publisher);
		book.setGenre(genre);
		return bookRepository.save(book);
	}

//	@Override
//	public BookModel updateBook(Long genreId, Long publisherId,Long id, BookModel updatedBook) {
//		// TODO Auto-generated method stub
//		BookModel book = bookRepository.findById(id)
//	            .orElseThrow(() -> new ResourceNotFoundException("Book not found with ID " + id));
//	    Publisher publisher = publisherRepository.findById(publisherId).get();
//		Genre genre=genreRepository.findById(genreId).get();
//		book.setPublisher(publisher);
//		book.setGenre(genre);
//	    book.setBook_name(updatedBook.getBook_name());
//	    book.setBook_author(updatedBook.getBook_author());
//	    book.setBook_ratings(updatedBook.getBook_ratings());
//
//	    return bookRepository.save(book);
//	}

	@Override
	public BookModel getBookById(Long book_id) {
		// TODO Auto-generated method stub
		return bookRepository.findById(book_id).orElse(null);
	}

	@Override
	public List<BookModel> getAllBooks() {
		return bookRepository.findAll();
	}

	@Override
	public void deleteBook(Long book_id) {
		bookRepository.deleteById(book_id);
	}

//	@Override
//	public BookModel updateBook(BookModel book) {
//		if (bookRepository.existsById(book.getBook_id())) {
//			BookModel updatedBook = bookRepository.save(book);
//			return updatedBook;
//		}
//		return book;
//
//	}

//	  @Override
//	    public void deleteAllBooks() {
//	        bookRepository.deleteAll();
//	    }
	@Override
	public List<Genre> getAllGenres() {
		return genreRepository.findAll();
	}

	@Override
	public List<Publisher> getAllPublishers() {
		// TODO Auto-generated method stub
		return publisherRepository.findAll();
	}

	@Override
	public BookModel updateBook(Long genreId, Long publisherId, Long book_id, BookModel updatedBook) {
		// TODO Auto-generated method stub
		BookModel book = bookRepository.findById(book_id)
				.orElseThrow(() -> new ResourceNotFoundException("Book not found with ID " + book_id));
		Publisher publisher = publisherRepository.findById(publisherId).get();
		Genre genre = genreRepository.findById(genreId).get();
		book.setPublisher(publisher);
		book.setGenre(genre);
		book.setBook_name(updatedBook.getBook_name());
		book.setBook_author(updatedBook.getBook_author());
		book.setBook_ratings(updatedBook.getBook_ratings());
		return bookRepository.save(book);
	}
}
