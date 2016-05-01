package br.com.biblioteca.controll.action;

import javax.servlet.http.HttpServletRequest;

import br.com.biblioteca.model.Conexao;
import br.com.biblioteca.model.dao.GeneroDAO;
import br.com.biblioteca.model.entity.Genero;

public class GravarGenero implements Action{
	@Override
	public String executar(HttpServletRequest request){
		try{
			int id = Integer.parseInt(request.getParameter("id"));
			String descricao = request.getParameter("descricao");
			
			Genero genero = new Genero();
			genero.setId(id);
			genero.setDescricao(descricao);
			
			GeneroDAO generoDAO = new GeneroDAO(Conexao.getConnection());
			if(id== 0 ){
				generoDAO.insert(genero);
			}else{
				generoDAO.update(genero);
			}
			request.setAttribute("proximaAcao", "ListarGenero");
			return "cadastroEfetuado.jsp";
		}catch(Exception error){
			error.printStackTrace();
		}
		return "erro.jsp";
	}
}
