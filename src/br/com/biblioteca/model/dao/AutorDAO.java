package br.com.biblioteca.model.dao;

import br.com.biblioteca.model.entity.Autor;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AutorDAO {

	private Connection conexao;

	public AutorDAO(Connection conexao) {
		this.conexao = conexao;
	}

	public void insert(Autor autor) {
		try {
			PreparedStatement preparedst = conexao.prepareStatement("insert into autor (nome, email) values (?, ?)");
			preparedst.setString(1, autor.getNome());
			preparedst.setString(2, autor.getEmail());
			preparedst.executeUpdate();
			preparedst.close();
		} catch (Exception error) {
			error.printStackTrace();
		}
	}

	public void update(Autor autor) {
		 try {
		      PreparedStatement preparedst = conexao.prepareStatement(
		        "update autor set nome = ?, email = ? where id = ?");
		      preparedst.setString(1, autor.getNome());
		      preparedst.setString(2, autor.getEmail());
		      preparedst.setInt(3, autor.getId());
		      preparedst.executeUpdate();
		      preparedst.close();
		    } catch (Exception e) {
		      e.printStackTrace();
		    }
	}
	
	public void delete(int id) {
		try{
			PreparedStatement preparedst = conexao.prepareStatement(
					"delete from autor where id = ?");
			preparedst.setInt(1, id);
			preparedst.executeUpdate();
			preparedst.close();
		}catch(Exception error){
			error.printStackTrace();
		}
	}
	public Autor getById(int id) {
		    Autor autor = null;
		    try {
		      PreparedStatement pstmt = conexao.prepareStatement(
		        "select * from autor where id = ?");
		      pstmt.setInt(1, id);
		      ResultSet rs = pstmt.executeQuery();
		      if (rs.next()) {
		        autor = getAutor(rs);
		      }
		      pstmt.close();
		    } catch (Exception e) {
		      e.printStackTrace();
		    }
		    return autor;
		  }

	private Autor getAutor(ResultSet rs){
		Autor autor = null;
		try{
		autor = new Autor();
		autor.setId(rs.getInt("id"));
		autor.setNome(rs.getString("nome"));
		autor.setEmail(rs.getString("email"));
		}catch(Exception error){
			error.printStackTrace();
		}
		return autor;
	}

	public List<Autor> list() {
		List<Autor> autores = new ArrayList<Autor>();
		Autor autor = null;
		try{
			PreparedStatement preparedst = conexao.prepareStatement(
					"select * from autor order by nome");
			ResultSet rs = preparedst.executeQuery();
			while(rs.next()){
				autor = getAutor(rs);
				autores.add(autor);
			}
			preparedst.close();
		}catch(Exception erro){
			erro.printStackTrace();
		}
		return autores;
	}

	public List<Autor> getPesquisa(String pesquisar ) {
		List<Autor> autores = new ArrayList<>();
		try{
			PreparedStatement preparedst = conexao.prepareStatement("select * from autor where upper(nome) like upper(?)");
			preparedst.setString(1, "%" + pesquisar + "%");
			ResultSet rs = preparedst.executeQuery();
			Autor autor =null;
			while (rs.next()) {
				autor = getAutor(rs);
				autores.add(autor);
			}
			preparedst.close();
		}catch(Exception error){
			error.printStackTrace();
		}
		return autores;
	}
}
