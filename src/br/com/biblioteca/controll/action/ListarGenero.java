package br.com.biblioteca.controll.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import br.com.biblioteca.model.Conexao;
import br.com.biblioteca.model.dao.GeneroDAO;
import br.com.biblioteca.model.entity.Genero;

public class ListarGenero implements Action {

	@Override
	public String executar(HttpServletRequest request)  {
		try{
			
			GeneroDAO generoDAO = new GeneroDAO(Conexao.getConnection());
			List<Genero> generos = generoDAO.list();
			
			request.setAttribute("lista", generos);
			
			return "listaGenero.jsp";
		}catch (Exception error) {
			error.printStackTrace();
		}
		return "erro.jsp";
	}

}
