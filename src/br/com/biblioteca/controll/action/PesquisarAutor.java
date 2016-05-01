package br.com.biblioteca.controll.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import br.com.biblioteca.model.Conexao;
import br.com.biblioteca.model.dao.AutorDAO;
import br.com.biblioteca.model.entity.Autor;

public class PesquisarAutor implements Action{
	
	private AutorDAO autorDAO;
		
	public String executar(HttpServletRequest request){
		try{
			autorDAO = new AutorDAO(Conexao.getConnection());
			
			List<Autor> autores = new ArrayList<>();
			autores = autorDAO.getPesquisa(request.getParameter("pesquisar"));
			
			request.setAttribute("lista", autores);
			
			return "listaAutor.jsp";
		}catch(Exception error){
			error.printStackTrace();
		}
		return "erro.jsp";
		
	}

}
