package br.com.biblioteca.controll.action;

import javax.servlet.http.HttpServletRequest;

import br.com.biblioteca.model.entity.Genero;

public class InserirGenero implements Action{

	@Override
	public String executar(HttpServletRequest request) {
		try{
			Genero genero = new Genero();
			
			request.setAttribute("genero", genero);
			
			return "formGenero.jsp";
		}catch(Exception error){
			error.printStackTrace();
		}
		return null;
	}
}
