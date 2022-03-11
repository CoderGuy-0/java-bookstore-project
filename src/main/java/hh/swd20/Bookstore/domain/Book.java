package hh.swd20.Bookstore.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Book {
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private long id;
	//String title,String Author, int year,String isbn
	
	private String title, author, isbn;
	private int year;
	
	@ManyToOne
	@JsonIgnoreProperties("books")
    @JoinColumn(name = "categoryid")
	private Category category;

	
	//getters
	public long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}

	public String getIsbn() {
		return isbn;
	}

	public int getYear() {
		return year;
	}

	public Category getCategory() {
		return category;
	}

	//setters
	public void setId(long id) {
		this.id = id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	//konstruktori parametreillä
	public Book(String title, String author, String isbn, int year, Category category) {
		super();
		this.title = title;
		this.author = author;
		this.isbn = isbn;
		this.year = year;
		this.category = category;
	}

	//parametritön konstruktori
	public Book() {
		super();
	}

	@Override
	public String toString() {
		if (this.category != null) 
		return "Book [id=" + id + ", title=" + title + ", author=" + author + ", isbn=" + isbn + ", year=" + year
				+ ", category=" + this.getCategory() + "]";
		else return "Book [id=" + id + ", title=" + title + ", author=" + author + ", isbn=" + isbn + ", year=" + year + "]";
	}
	
	
	
}
