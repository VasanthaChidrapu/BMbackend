package com.bookm.BookManagement.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Book")
public class BookModel {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	private Long book_id;
	private String book_name;
	// private String book_genre;
	private String book_author;
	// private String book_publishers;
	private float book_ratings;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	@JoinColumn(name = "genre_id")
	private Genre genre;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	@JoinColumn(name = "publisher_id")
	private Publisher publisher;

	public BookModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BookModel(Long book_id, String book_name, String book_author, float book_ratings) {
		super();
		this.book_id = book_id;
		this.book_name = book_name;
		this.book_author = book_author;
		this.book_ratings = book_ratings;
	}

	public Long getBook_id() {
		return book_id;
	}

	public void setBook_id(Long book_id) {
		this.book_id = book_id;
	}

	public String getBook_name() {
		return book_name;
	}

	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}

	public String getBook_author() {
		return book_author;
	}

	public void setBook_author(String book_author) {
		this.book_author = book_author;
	}

	public float getBook_ratings() {
		return book_ratings;
	}

	public void setBook_ratings(float book_ratings) {
		this.book_ratings = book_ratings;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	public Publisher getPublisher() {
		return publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}

	@Override
	public String toString() {
		return "BookModel [book_id=" + book_id + ", book_name=" + book_name + ", book_author=" + book_author
				+ ", book_ratings=" + book_ratings + "]";
	}

}
