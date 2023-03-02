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
@Table(name = "book_publishers")
public class Publisher {
	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private Long publisher_id;
      private String publisher_name;
      
      @OneToMany(mappedBy = "publisher",fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
  	  private List<BookModel> book;
	  public Publisher() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Publisher(Long publisher_id, String publisher_name) {
		super();
		this.publisher_id = publisher_id;
		this.publisher_name = publisher_name;
	}
	public Long getPublisher_id() {
		return publisher_id;
	}
	public void setPublisher_id(Long publisher_id) {
		this.publisher_id = publisher_id;
	}
	public String getPublisher_name() {
		return publisher_name;
	}
	public void setPublisher_name(String publisher_name) {
		this.publisher_name = publisher_name;
	}
	@Override
	public String toString() {
		return "Publisher [publisher_id=" + publisher_id + ", publisher_name=" + publisher_name + "]";
	}
      

}
