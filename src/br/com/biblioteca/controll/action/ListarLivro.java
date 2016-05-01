package br.com.biblioteca.controll.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import br.com.biblioteca.model.Conexao;
import br.com.biblioteca.model.dao.LivroDAO;
import br.com.biblioteca.model.entity.Livro;

public class ListarLivro implements Action {

	@Override
	public String executar(HttpServletRequest request) {
		try{
			LivroDAO livroDAO = new LivroDAO(Conexao.getConnection());
			List<Livro> livros = livroDAO.list();
			
			request.setAttribute("lista", livros);
			
			return "listaLivro.jsp";
		}catch (Exception error) {
			error.printStackTrace();
		}
		return "erro.jsp";
	}

}
