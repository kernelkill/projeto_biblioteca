package br.com.biblioteca.controll.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import br.com.biblioteca.model.Conexao;
import br.com.biblioteca.model.dao.AutorDAO;
import br.com.biblioteca.model.dao.GeneroDAO;
import br.com.biblioteca.model.dao.LivroDAO;
import br.com.biblioteca.model.entity.Autor;
import br.com.biblioteca.model.entity.Genero;
import br.com.biblioteca.model.entity.Livro;

public class SelecionarLivro implements Action{

	@Override
	public String executar(HttpServletRequest request)  {
		try{
			int isbn = Integer.parseInt(request.getParameter("isbn"));
			LivroDAO livroDAO = new LivroDAO(Conexao.getConnection());
			Livro livro = livroDAO.getByIsbn(isbn);
			
			AutorDAO autorDAO = new AutorDAO(Conexao.getConnection());
			List<Autor> autores = autorDAO.list();
			
			GeneroDAO generoDAO = new GeneroDAO(Conexao.getConnection());
			List<Genero> generos = generoDAO.list();
			
			request.setAttribute("livro", livro);
			request.setAttribute("listaAutor", autores);
			request.setAttribute("listaGenero", generos);
			
			return "formLivro.jsp";
		}catch (Exception error) {
			error.printStackTrace();
		}
		return "erro.jsp";
	}

}
