package bookstack.persistence.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

@Table(uniqueConstraints = @UniqueConstraint(columnNames = { "nazov" }))
@Entity
@NamedQueries({
		@NamedQuery(name = "findBooksByKate", query = "SELECT a FROM Kategoria a WHERE a.nazov LIKE :nazov") })
public class Kategoria {

	@Id
	@GeneratedValue
	private int ID_kat;

	@Column(name = "nazov")
	private String nazov;


	@OneToMany(mappedBy = "kategoria") 
	private List<Book> books;

	public Kategoria() {
	}

	public Kategoria(String nazov) {
		this.nazov = nazov;
		this.books = new ArrayList<>();
	}

	public String getNazov() {
		return nazov;
	}

	public void setNazov(String nazov) {
		this.nazov = nazov;
	}


	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public int getId() {
		return	ID_kat;
	}

	public void setId(int ID_kat) {
		this.ID_kat = ID_kat;
	}


}