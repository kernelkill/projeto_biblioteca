package br.com.biblioteca.controll.action;

import javax.servlet.http.HttpServletRequest;

import br.com.biblioteca.model.Conexao;
import br.com.biblioteca.model.dao.GeneroDAO;
import br.com.biblioteca.model.entity.Genero;

public class SelecionarGenero implements Action{

	@Override
	public String executar(HttpServletRequest request) {
		try{
			int id = Integer.parseInt(request.getParameter("id"));
			GeneroDAO generoDAO = new GeneroDAO(Conexao.getConnection());
			Genero genero = generoDAO.getById(id);
			
			request.setAttribute("genero", genero);
			
			return "formGenero.jsp";
		}catch(Exception error){
			error.printStackTrace();
		}
		return "erro.jsp";
	}

	
}
