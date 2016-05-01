package br.com.biblioteca.controll.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import br.com.biblioteca.model.Conexao;
import br.com.biblioteca.model.dao.AutorDAO;
import br.com.biblioteca.model.dao.GeneroDAO;
import br.com.biblioteca.model.entity.Autor;
import br.com.biblioteca.model.entity.Genero;
import br.com.biblioteca.model.entity.Livro;

public class InserirLivro  implements Action{

	@Override
	public String executar(HttpServletRequest request) {
		try{
			Livro livro = new Livro();
			AutorDAO autorDAO = new AutorDAO(Conexao.getConnection());
			List<Autor> autores = autorDAO.list();
			
			GeneroDAO generoDAO = new GeneroDAO(Conexao.getConnection());
			List<Genero> generos = generoDAO.list();
			
			request.setAttribute("livro", livro);
			request.setAttribute("listaGenero", generos);
			request.setAttribute("listaAutor", autores);
			
			return "formLivro.jsp";
		}catch(Exception error){
			error.printStackTrace();
		}
		return "erro.jsp";
	}

}
