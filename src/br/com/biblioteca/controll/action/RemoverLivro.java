package br.com.biblioteca.controll.action;

import javax.servlet.http.HttpServletRequest;

import br.com.biblioteca.model.Conexao;
import br.com.biblioteca.model.dao.LivroDAO;

public class RemoverLivro implements Action {

	@Override
	public String executar(HttpServletRequest request) {
		try {
		      //1. buscar o id da cidade a ser removida
		      int isbn = Integer.parseInt(request.getParameter("isbn"));
		      
		      //2. remover o objeto cidade informado
		      LivroDAO livroDAO = new LivroDAO(Conexao.getConnection());
		      livroDAO.delete(isbn);
		      
		      //3. encaminhar para JPS especifico
		      return new ListarLivro().executar(request);
		    } catch (Exception e) {
		    }
		    return "erro.jsp";
	}
}
