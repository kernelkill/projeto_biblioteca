package br.com.biblioteca.controll.action;

import javax.servlet.http.HttpServletRequest;

import br.com.biblioteca.model.Conexao;
import br.com.biblioteca.model.dao.GeneroDAO;

public class RemoverGenero  implements Action{

	@Override
	public String executar(HttpServletRequest request) {
		try{
			
			int id = Integer.parseInt(request.getParameter("id"));
			
			GeneroDAO generoDAO = new GeneroDAO(Conexao.getConnection());
			generoDAO.delete(id);
			
			return new ListarGenero().executar(request);
		}catch(Exception error){
			error.printStackTrace();
		}
		return "erro.jsp";
	}

}
