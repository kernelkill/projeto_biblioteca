package br.com.biblioteca.controll.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import br.com.biblioteca.model.Conexao;
import br.com.biblioteca.model.dao.LivroDAO;
import br.com.biblioteca.model.entity.Livro;

public class PesquisarLivro implements Action{
	private LivroDAO livroDAO;

	@Override
	public String executar(HttpServletRequest request) {
		try{
			livroDAO = new LivroDAO(Conexao.getConnection());
			
			List<Livro> livros = new ArrayList<>();
			livros = livroDAO.getPesquisar(request.getParameter("pesquisar"));
			
			request.setAttribute("lista", livros);
			
			return "listaLivro.jsp";
		}catch(Exception error){
			error.printStackTrace();
		}
		return "erro.jsp";
	}
}
