package br.com.biblioteca.controll.action;

import javax.servlet.http.HttpServletRequest;
import br.com.biblioteca.model.Conexao;
import br.com.biblioteca.model.dao.AutorDAO;

public class RemoverAutor implements Action{

	
	public String executar(HttpServletRequest request)  {
		try{
			
			int id = Integer.parseInt(request.getParameter("id"));
			
			AutorDAO autorDAO = new AutorDAO(Conexao.getConnection());
			autorDAO.delete(id);
			
			return new ListarAutor().executar(request);
		}catch(Exception error){
			error.printStackTrace();
		}
		return "erro.jsp";
	}

}
