package hh.swd20.Bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import hh.swd20.Bookstore.domain.Book;
import hh.swd20.Bookstore.domain.BookRepository;
import hh.swd20.Bookstore.domain.Category;
import hh.swd20.Bookstore.domain.CategoryRepository;
import hh.swd20.Bookstore.domain.User;
import hh.swd20.Bookstore.domain.UserRepository;

@SpringBootApplication
public class BookstoreApplication {

	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner bookDemo(BookRepository repository, CategoryRepository crepository, UserRepository urepository)
	{
		return (args) -> {
			
			log.info("tallennan pari kategoriaa");
			Category c1 = new Category(1, "Dystopian");
			crepository.save(c1);
			Category c2 = new Category(2, "Adventure");
			crepository.save(c2);
			Category c3 = new Category(3, "Science Fiction");
			crepository.save(c3);
			
			log.info("tallennan pari kirjaa");
			//String title, author, isbn;
			Book b1 = new Book("Moi", "Joku", "vvvv", 1980, c1);
			repository.save(b1);
			Book b2 = new Book("lorem ipsum", "Someone", "1234", 1990, c2);
			repository.save(b2);
			Book b3 = new Book("Uusi kirja", "Joku", "5678", 2000, c3);
			repository.save(b3);
			
			log.info("hae kaikki kirjat");
			for (Book book : repository.findAll()) {
				log.info(book.toString());
			}
				
			log.info("hae kaikki Kategoriat");
			for (Category category : crepository.findAll()) {
				log.info(category.toString());
			}
			

			User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
			urepository.save(user1);
			User user2 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");
			urepository.save(user2);
			
			
			
		
	};
		
	}

}
