package br.com.caelum.livraria.dao;

import javax.ejb.Stateless;

import br.com.caelum.livraria.modelo.Usuario;

@Stateless
public class UsuarioDao {

	@PersistenceContext
	private EntityManager em;

	public Usuario buscaPeloLogin(String login) {
		return (Usuario) this.em.createQuery("select u from Usuario where u.login=:pLogin")
								.setParameter("pLogin", login).getSingleResult();
	}
	
}
