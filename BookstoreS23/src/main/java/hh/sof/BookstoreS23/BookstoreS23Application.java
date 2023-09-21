package hh.sof.BookstoreS23;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.sof.BookstoreS23.domain.BookRepository;
import hh.sof.BookstoreS23.domain.Category;
import hh.sof.BookstoreS23.domain.CategoryRepository;
import hh.sof.BookstoreS23.domain.Book;


@SpringBootApplication
public class BookstoreS23Application {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreS23Application.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(BookRepository bookRepository, CategoryRepository catRepository) {
		return (args) -> {
			catRepository.save(new Category("Scifi"));
			catRepository.save(new Category("Adventure"));
			catRepository.save(new Category("Crime"));
			
			
			bookRepository.save(new Book("ABC", "Malli Mllikas", "1234-1234", 2021, 10, catRepository.findByName("Horror").get(0)));
			bookRepository.save(new Book("DEF", "Molli Mollinen", "1234-5674", 2022, 20, catRepository.findByName("Crime").get(0)));
			bookRepository.save(new Book("GHI", "Salli Sallila", "45434-1234", 2023, 30, catRepository.findByName("Scifi").get(0)));
		
		
		};
	
	}
	}

