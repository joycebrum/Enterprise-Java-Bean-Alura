package br.com.caelum.livraria.dao;

import java.util.List;

import javax.ejb.Stateless;

import br.com.caelum.livraria.modelo.Autor;

@Stateless
public class AutorDao {

	@PersistenceContext
	private EntityManager em;

	@TransactionAttribute(TransactionAttributeType.MANDATORY)
	public void salva(Autor autor) {
		this.em.persist(autor);
	}
	
	@TransactionAttribute(TransactionAttributeType.MANDATORY)
	public List<Autor> todosAutores() {
		return this.em.createQuery("select a from Autor a", Autor.class)
	            .getResultList();
	}
	
	@TransactionAttribute(TransactionAttributeType.MANDATORY)
	public Autor buscaPelaId(Integer autorId) {
		Autor autor = this.em.find(Autor.class, autorId);
		return autor;
	}
	
	@PostConstruct
	void aposCriacao() {
	    System.out.println("[INFO] AutorDao foi criado.");
	}
	
}
