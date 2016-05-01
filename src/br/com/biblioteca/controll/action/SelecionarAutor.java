package br.com.biblioteca.controll.action;

import javax.servlet.http.HttpServletRequest;

import br.com.biblioteca.model.Conexao;
import br.com.biblioteca.model.dao.AutorDAO;
import br.com.biblioteca.model.entity.Autor;

public class SelecionarAutor implements Action {

	@Override
	public String executar(HttpServletRequest request) {
		try{
			int id =Integer.parseInt(request.getParameter("id"));
			AutorDAO autorDAO = new AutorDAO(Conexao.getConnection());
			Autor autor = autorDAO.getById(id);
			
			request.setAttribute("autor", autor);
			
			return "formAutor.jsp";
		}catch (Exception error) {
			
			error.printStackTrace();
		}
		return "erro.jsp";
	}
	

}
