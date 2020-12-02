package br.com.projeto.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.sun.istack.NotNull;

/**
 * api-rest
 * @author jaime Des
 * Em: 28 de nov de 2020
 * 
 */

@Entity
@Table (name= "tb_usuario")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotBlank
	@NotNull
	private String nome;
	@NotNull
	private int idade;
	
	/* Construct: id, nome, idade*/
	public Usuario(int id, String nome, int idade) {
		this.id = id;
		this.nome = nome;
		this.idade = idade;
	}
	/* Construct nome: idade*/
	public Usuario() {}
	public Usuario(String nome, int idade) {
		super();
		this.nome = nome;
		this.idade = idade;
	}
	/* Getter */
	public int getId() {
		return id;
	}
	/* Setter */
	public void setId(int id) {
		this.id = id;
	}
	/* Getter */
	public String getNome() {
		return nome;
	}
	/* Setter */
	public void setNome(String nome) {
		this.nome = nome;
	}
	/* Getter */
	public int getIdade() {
		return idade;
	}
	/* Setter */
	public void setIdade(int idade) {
		this.idade = idade;
	}
	@Override
	public String toString() {
		return 
				"id:" + id 
				+ "\n nome:" + nome 
				+ "\n idade:" + idade + "\n";
	}
}
