package br.com.projeto.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.projeto.domain.Usuario;

/**
 * api-rest
 * @author jaime
 * 29 de nov de 2020
 * https://github.com/jaimedessilva/api-user-rest
 */
public class RepositoryInMemoria {
	
	private final List<Usuario> lista = new ArrayList<Usuario>();
	/*
	 * GET Usuario
	 */
	public Usuario get(Usuario usuario) {
		lista.contains(usuario);
		return usuario;
	}
	/*
	 * Listar
	 */
	public List<Usuario> lista() {

		lista.add(new Usuario(1,"Solano Dias", 33));
		lista.add(new Usuario(2,"Marcos Pontes", 32));
		lista.add(new Usuario(3,"Caio Tesla", 50));
		lista.add(new Usuario(4,"Pitolomeu Aguiar", 48));
		lista.add(new Usuario(5,"Ronaldo Tom", 45));
		
		return lista;
	}
	/*
	 * Create
	 */
	public void add(Usuario usuario) {
		lista.add(usuario);
		}
	/*
	 * Update
	 */
	public void update (Usuario usuario) {
		lista.add(usuario);
	}
	/*
	 * Delete
	 */
	public void delete (long id) {
		lista.remove(id);
	}

}
