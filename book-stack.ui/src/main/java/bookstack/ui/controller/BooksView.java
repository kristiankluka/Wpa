package bookstack.ui.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import bookstack.business.KategoriaService;
import bookstack.business.AuthorService;
import bookstack.business.BookService;
import bookstack.persistence.entities.Author;
import bookstack.persistence.entities.Book;
import bookstack.persistence.entities.Kategoria;

@ViewScoped
@Named
public class BooksView implements Serializable {
	
	private static final long serialVersionUID = 6559129950166292602L;
	
	private String input;
	private Author author;
	private Kategoria kategoria;
	private List<Book> bookList;
	private List<Author> autorList;

	private List<Kategoria> kateList;
	
	@Inject
	private BookService bookService;
	@Inject
	private AuthorService authorService;
	@Inject
	private KategoriaService kateService;
	
	@PostConstruct
	private void init() {
		System.out.println(this.getClass().getName() + " created.");
		bookList = bookService.getAllBooks();
		input = "init hodnota";
		author = new Author();
		autorList = authorService.getAllAuthors();
		kategoria = new Kategoria();

		kateList = kateService.getAllkate();
	}
	
	@PreDestroy
	private void destroy(){
		System.out.println(this.getClass().getName() + " was destroyed.");
	}

	public List<Kategoria> getKateList() {
		return kateList;
	}

	public void setKateList(List<Kategoria> kateList) {
		this.kateList = kateList;
	}

	public List<Book> getBookList() {
		return bookList;
	}
	

	public List<Author> getAutorList() {
		return autorList;
	}

	public void setAutorList(List<Author> autorList) {
		this.autorList = autorList;
	}

	public void setBookList(List<Book> bookList) {
		this.bookList = bookList;
	}

	public String getInput() {
		return input;
	}

	public void setInput(String input) {
		this.input = input;
	}
	public Author getAuthor() {
		return author;
	}
	

	public Kategoria getKategoria() {
		return kategoria;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}
	public void setKategoria(Kategoria kategoria) {
		this.kategoria = kategoria;
	}

	

}
