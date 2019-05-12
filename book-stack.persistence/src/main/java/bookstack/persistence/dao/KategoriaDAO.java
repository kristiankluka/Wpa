package bookstack.persistence.dao;

import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import bookstack.persistence.entities.Kategoria;

@Stateless
public class KategoriaDAO extends AbstractDAO<Kategoria> {

	public KategoriaDAO() {
		super(Kategoria.class);
	}
	public Kategoria getKategoriaByName(String nazov) {
		TypedQuery<Kategoria> query = em.createNamedQuery("findBooksByKate", Kategoria.class);
		query.setParameter("nazov", nazov);
		try {
			return query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}

	}

}
