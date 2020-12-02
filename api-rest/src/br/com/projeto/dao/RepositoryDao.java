package br.com.projeto.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.projeto.db.JpaUtil;
import br.com.projeto.domain.Usuario;

/**
 * api-rest
 * @author jaime
 * 30 de nov de 2020
 * https://github.com/jaimedessilva/api-user-rest
 */

public class RepositoryDao {
	
	private List<Usuario> ls = new ArrayList<>();
	private JpaUtil jpa = new JpaUtil();
	private EntityManager db = jpa.getEntityManager();
	
	/*
	 * READ JPA
	 */
	public Usuario getId(int id) {
		return db.find(Usuario.class, id);
	}
	/*
	 *   READ NATIVE SQL
	 */
	public Usuario byId(int id) {
		String sql = "select id,nome,idade from tb_usuario where id = ?";
		Query query = db.createNativeQuery(sql, Usuario.class);
		query.setParameter(1, id);
		return (Usuario) query.getSingleResult();
	}
	@SuppressWarnings("unchecked")
	public List<Usuario> listar() {

		String sql = "select * from tb_usuario  order by id asc";
		Query query = db.createNativeQuery(sql, Usuario.class);
		ls = query.getResultList();
		jpa.JpaClose();
		return ls;
	}
	/*
	 * CREATE
	 */
	public void create(Usuario usuario) {
			db.getTransaction().begin();
			db.persist(usuario);
			db.getTransaction().commit();
			jpa.JpaClose();
	}

	/*
	 * UPDATE
	 */
	public Usuario update(Usuario usuario) {
		db.getTransaction().begin();
		db.merge(usuario);
		db.getTransaction().commit();
		db.close();
		return usuario;

	}
	/*
	 * DELETE
	 */
	public void delete(int id) {
		Usuario usuario = getId(id);
		db.getTransaction().begin();
		db.remove(usuario);
		db.getTransaction().commit();
		jpa.JpaClose();
	}
	
}
