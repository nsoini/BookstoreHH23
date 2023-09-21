package hh.sof.BookstoreS23.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import hh.sof.BookstoreS23.domain.Book;
import hh.sof.BookstoreS23.domain.BookRepository;
//import hh.sof.BookstoreS23.domain.CategoryRepository;

@RestController
public class RestBookController {
	
	@Autowired
	private BookRepository bookRepository; 
	
	//@Autowired
	//private CategoryRepository catRepository;
	
	//Rest list all books
		@GetMapping(value="/books")
		public List<Book> bookListRest(){
			return (List<Book>) bookRepository.findAll();
		}
		
	// Rest find one book by Id
		@GetMapping(value="/book/{id}")
		public Optional<Book> findBookRest(@PathVariable("id") Long id) {
			return bookRepository.findById(id);
		}
	
	// add a new book
		@PostMapping(value="book")
		public Book addBookRest(@RequestBody Book book) {
			return bookRepository.save(book);
		}
		
	// Rest delete a book
		@DeleteMapping(value="/book/{id}")
		public List<Book> deleteBookRest(@PathVariable("id") Long id) {
			bookRepository.deleteById(id);
			return (List<Book>) bookRepository.findAll();
		}
		
	// edit a book
	
		

}
