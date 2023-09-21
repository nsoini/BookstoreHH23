package hh.sof.BookstoreS23.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import hh.sof.BookstoreS23.domain.Book;
import hh.sof.BookstoreS23.domain.BookRepository;
import hh.sof.BookstoreS23.domain.CategoryRepository;


@Controller
public class BookController {
	
	@Autowired
	private BookRepository bookRepository; 
	
	@Autowired
	private CategoryRepository catRepository;
	
	//list all books
	@GetMapping(value = {"/", "/booklist"})
	public String bookStore(Model model) {
		model.addAttribute("books", bookRepository.findAll());
		return "booklist";
	}
	
	//edit a book
	@GetMapping(value = "/edit/{id}")
	public String editBook(@PathVariable("id") Long bookId, Model model) {
		model.addAttribute("book", bookRepository.findById(bookId));
		model.addAttribute("categorys", catRepository.findAll());
		return "editbook";
	}
	
	//delete a book
	@GetMapping(value = "/delete/{id}")
	public String deleteBook(@PathVariable("id") Long bookId) {
		bookRepository.deleteById(bookId);
		return "redirect:/booklist";
	}
	
	//add a new book
	@RequestMapping(value = "/add")
	public String addBook(Model model) {
		model.addAttribute("book", new Book());
		model.addAttribute("categorys", catRepository.findAll());
		return "addbook";
	}
	
	//save a new book
	@PostMapping(value = "/save")
	public String save(@ModelAttribute Book book) {
		bookRepository.save(book);
		return "redirect:/booklist";
	}


}
