package br.com.caelum.livraria.bean;

import java.util.List;

import br.com.caelum.livraria.dao.AutorDao;
import br.com.caelum.livraria.modelo.Autor;

@Stateless
public class AutorService {

	@Inject
	AutorDao dao;
	
	public void adiciona(Autor autor) {
		this.dao.salva(autor);
	}
	
	public List<Autor> todosAutores() {
		return this.dao.todosAutores();
	}

}
