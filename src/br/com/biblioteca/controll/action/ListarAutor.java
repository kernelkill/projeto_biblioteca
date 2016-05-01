package br.com.biblioteca.controll.action;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import br.com.biblioteca.model.Conexao;
import br.com.biblioteca.model.dao.AutorDAO;
import br.com.biblioteca.model.entity.Autor;

public class ListarAutor  implements Action{
	
	private AutorDAO autorDAO;
	private List<Autor> autores;
	
	
	@Override
	public String executar(HttpServletRequest request) {
		try{
			 //1. buscar dado
			autorDAO = new AutorDAO(Conexao.getConnection());
			autores = autorDAO.list();
			
			 //2. colocar dados na requisição
			request.setAttribute("lista", autores);
			
			return "listaAutor.jsp";
		}catch (Exception error) {
			error.printStackTrace();
		}
		return "erro.jsp";
	}
}
