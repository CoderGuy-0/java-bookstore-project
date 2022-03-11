package hh.swd20.Bookstore.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import hh.swd20.Bookstore.domain.Book;
import hh.swd20.Bookstore.domain.BookRepository;
import hh.swd20.Bookstore.domain.Category;
import hh.swd20.Bookstore.domain.CategoryRepository;

@CrossOrigin
@Controller

public class BookController {
	@Autowired
	private BookRepository repository;
	@Autowired
	private CategoryRepository repo;
	
	
	
	// Show all books
    @RequestMapping(value="/login")
    public String login() {	
        return "login";
    }	
	
	@RequestMapping(value="/booklist", method=RequestMethod.GET)
	public String bookInfo (Model model)
	{
		model.addAttribute("books", repository.findAll());
		
		return "bookstore";
	}
	
	// RESTful service to get all books
    // Java-kielinen Student-luokan oliolista muunnetaan JSON-opiskelijalistaksi ja 
    // lähetetään web-selaimelle vastauksena
    @RequestMapping(value="/books", method = RequestMethod.GET)
    public @ResponseBody List<Book> studentListRest() {	
        return (List<Book>) repository.findAll();
    }
    
 // RESTful service to get book by id
    @RequestMapping(value="/books/{id}", method = RequestMethod.GET)
    public @ResponseBody Optional<Book> findBookRest(@PathVariable("id") Long bookId) {	
    	return repository.findById(bookId);
    }      
    
    // RESTful service to save new book
    @RequestMapping(value="/books", method = RequestMethod.POST)
    public @ResponseBody Book saveStudentRest(@RequestBody Book book) {	
    	return repository.save(book);
    }
	
	@RequestMapping(value="/add")
	public String addBook (Model model)
	{
		model.addAttribute("book", new Book());
		model.addAttribute("categories", repo.findAll());
		return "addbook";
	}
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String saveBook (Book book)
	{
		repository.save(book);
		return "redirect:booklist";
	}
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	public String deleteBook (@PathVariable("id") Long bookId, Model model)
	{
		repository.deleteById(bookId);
		return "redirect:../booklist";
	}
	
	@RequestMapping(value="/edit/{id}")
	public String editBook (@PathVariable("id") Long bookId, Model model, Book book)
	{
		repository.findById(bookId);
		repository.save(book);
		return "redirect:../booklist";
	}
	
	
	}
