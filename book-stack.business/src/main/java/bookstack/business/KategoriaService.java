package bookstack.business;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import bookstack.persistence.dao.KategoriaDAO;
import bookstack.persistence.entities.Author;
import bookstack.persistence.entities.Kategoria;

@Stateless
public class KategoriaService {

	@Inject
	private KategoriaDAO kategoriaDAO;
	
	public Kategoria findKategoriaByName(String nazov){
		return this.kategoriaDAO.getKategoriaByName(nazov);
	}
	
	public Kategoria createKategoria(Kategoria kategoria) {
		return this.kategoriaDAO.create(kategoria);
	}
	public List<Kategoria> getAllkate() {
		return kategoriaDAO.findAll();
	}
}