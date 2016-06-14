package br.com.biblioteca.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.biblioteca.model.Conexao;
import br.com.biblioteca.model.entity.Livro;

public class LivroDAO {

	private Connection conexao;
	private AutorDAO autorDAO;
	private GeneroDAO generoDAO;

	public LivroDAO(Connection conexao) {
		this.conexao = conexao;
	}

	public void insert(Livro livro) {
		try {
			PreparedStatement preparedst = conexao.prepareStatement(
					"insert into livro(titulo, descricao, anolancamento, idautor, idgenero) values (?, ?, ?, ?, ?)");
			preparedst.setString(1, livro.getTitulo());
			preparedst.setString(2, livro.getDescricao());
			preparedst.setInt(3, livro.getAnoLancamento());
			preparedst.setInt(4, livro.getAutor().getId());
			preparedst.setInt(5, livro.getGenero().getId());
			preparedst.executeUpdate();
			preparedst.close();
		} catch (Exception error) {
			error.printStackTrace();
		}
	}

	public void update(Livro livro) {
		try {
			PreparedStatement preparedst = conexao
					.prepareStatement("update livro set titulo = ?, descricao = ?, anolancamento = ?,"
							+ " idautor = ?, idgenero = ? where isbn =?");
			preparedst.setString(1, livro.getTitulo());
			preparedst.setString(2, livro.getDescricao());
			preparedst.setInt(3, livro.getAnoLancamento());
			preparedst.setInt(4, livro.getAutor().getId());
			preparedst.setInt(5, livro.getGenero().getId());
			preparedst.setInt(6, livro.getIsbn());
			preparedst.executeUpdate();
			preparedst.close();
		} catch (Exception error) {
			error.printStackTrace();
		}
	}

	private Livro getLivro(ResultSet rs) {
		Livro livro = null;
		try {
			autorDAO = new AutorDAO(Conexao.getConnection());
			generoDAO = new GeneroDAO(Conexao.getConnection());
			livro = new Livro();
			livro.setIsbn(rs.getInt("isbn"));
			livro.setTitulo(rs.getString("titulo"));
			livro.setDescricao(rs.getString("descricao"));
			livro.setAnoLancamento(rs.getInt("anolancamento"));
			livro.setGenero(generoDAO.getById(rs.getInt("idgenero")));
			livro.setAutor(autorDAO.getById(rs.getInt("idautor")));
		} catch (Exception error) {
			error.printStackTrace();
		}
		return livro;
	}

	public List<Livro> list() {
		List<Livro> livros = new ArrayList<>();
		Livro livro = null;
		try {
			PreparedStatement preparedst = conexao.prepareStatement("select * from livro order by livro");
			ResultSet rs = preparedst.executeQuery();
			while (rs.next()) {
				livro = getLivro(rs);
				livros.add(livro);
			}
			preparedst.close();
		} catch (Exception error) {
			error.printStackTrace();
		}
		return livros;
	}

	public Livro getByIsbn(int isbn) {
		Livro livro = null;
		try {
			PreparedStatement preparedst = conexao.prepareStatement("select * from livro where  isbn = ?");
			preparedst.setInt(1, isbn);
			ResultSet rs = preparedst.executeQuery();
			if (rs.next()) {	
				livro = getLivro(rs);
			}
			preparedst.close();
		} catch (Exception error) {
			error.printStackTrace();
		}
		return livro;
	}

	public void delete(int isbn) {
		try {
			PreparedStatement pstmt = conexao.prepareStatement("delete from  livro where isbn = ?");
			pstmt.setInt(1, isbn);
			pstmt.executeUpdate();
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Livro> getPesquisar(String pesquisar) {
		List<Livro> livros = new ArrayList<>();
		try{
			PreparedStatement preparedst = conexao.prepareStatement(" select * from livro where upper(titulo) like upper(?)");
			preparedst.setString(1, "%" + pesquisar + "%");
			ResultSet st = preparedst.executeQuery();
			Livro livro = null;
			while (st.next()) {
				livro = getLivro(st);
				livros.add(livro);
			}
			preparedst.close();
		}catch(Exception error){
			error.printStackTrace();
		}
		return livros;
	}
}
