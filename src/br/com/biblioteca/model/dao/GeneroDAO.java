package br.com.biblioteca.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.biblioteca.model.entity.Genero;

public class GeneroDAO {

	private Connection conexao;

	public GeneroDAO(Connection conexao) {
		this.conexao = conexao;
	}

	public void insert(Genero genero) {
		try {
			PreparedStatement preparedst = conexao.prepareStatement("insert into genero(descricao) values(?)");
			preparedst.setString(1, genero.getDescricao());
			preparedst.executeUpdate();
			preparedst.close();
		} catch (Exception error) {
			error.printStackTrace();
		}
	}

	public void update(Genero genero) {
		try{
		PreparedStatement preparedst = conexao.prepareStatement("update genero set descricao = ? where  id = ?");
		preparedst.setString(1, genero.getDescricao());
		preparedst.setInt(2, genero.getId());
		preparedst.executeUpdate();
		preparedst.close();
		}catch(Exception error){
			error.printStackTrace();
		}
	}

	public void delete(int id) {
		try {
			PreparedStatement preparedst = conexao.prepareStatement("delete from genero where id = ?");
			preparedst.setInt(1, id);
			preparedst.executeUpdate();
			preparedst.close();
		} catch (Exception error) {
			error.printStackTrace();
		}
	}
	
	public Genero getById(int id) {
		Genero genero =null;
		try{
			PreparedStatement preparedst = conexao.prepareStatement(
					"select * from genero where id = ?");
			preparedst.setInt(1, id);
			ResultSet rs = preparedst.executeQuery();
			if(rs.next()){
				genero = getGenero(rs);
			}
			preparedst.close();
		}catch(Exception error){
			error.printStackTrace();
		}
		return genero;
	}

	private Genero getGenero(ResultSet rs) {
		Genero genero = null;
		try {
			genero = new Genero();
			genero.setId(rs.getInt("id"));
			genero.setDescricao(rs.getString("descricao"));
		} catch (Exception error) {
			error.printStackTrace();
		}
		return genero;
	}

	public List<Genero> list() {
		List<Genero> generos = new ArrayList<Genero>();
		Genero genero = null;
		try {
			PreparedStatement preparedst = conexao.prepareStatement("select * from genero order by descricao");
			ResultSet rs = preparedst.executeQuery();
			while (rs.next()) {
				genero = getGenero(rs);
				generos.add(genero);
			}
			preparedst.close();
		} catch (Exception error) {
			error.printStackTrace();
		}
		return generos;
	}
}
