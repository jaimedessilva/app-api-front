package br.com.projeto;

import br.com.projeto.dao.RepositoryDao;
import br.com.projeto.domain.Usuario;

public class M {

	public static void main(String[] args) {
		
		RepositoryDao repository = new RepositoryDao();

		repository.create(new Usuario("Ted Denson",35));
		repository.create(new Usuario("Carlton Banks",39));
		repository.create(new Usuario("Rimory Dor",30));
		repository.create(new Usuario("Tadeu Santos",30));
		
		
		//repository.create(new Usuario("Morais Santos",35));
		
		//repository.update(new Usuario(5,"Romeu",33));
		
		//System.out.println(repository.byId(3));
		//System.out.println(repository.getId(3));
//		
//		int size = repository.listar().size();
//		System.out.println(repository.listar());
		//System.out.println(repository.listar());
		
		//repository.update(new Usuario (5,"Romeu Zema",37));
		
		//repository.delete(9);
		
		
		//repository.listar();
	}

}
