/* 
    *Document   : Autor
    *Created on : Apr 24, 2016
    *Author     : Joabe Kachorroski
*/

package br.com.biblioteca.model.entity;

public class Autor {
	
	private int id;
	private String nome;
	private String email;
	
	//Getters and Setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

}
