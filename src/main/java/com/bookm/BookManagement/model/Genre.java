package com.bookm.BookManagement.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "book_genre")
public class Genre {
	@Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private Long genre_id;

	  private String book_genre;
	  
	  @OneToMany(mappedBy = "genre", fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
  	  private List<BookModel> book;

	public Long getGenre_id() {
		return genre_id;
	}

	public void setGenre_id(Long genre_id) {
		this.genre_id = genre_id;
	}

	public String getBook_genre() {
		return book_genre;
	}

	public void setBook_genre(String book_genre) {
		this.book_genre = book_genre;
	}

	public Genre() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Genre(Long genre_id, String book_genre) {
		super();
		this.genre_id = genre_id;
		this.book_genre = book_genre;
	}

	@Override
	public String toString() {
		return "Genre [genre_id=" + genre_id + ", book_genre=" + book_genre + "]";
	}
	  
	  
	  

}
