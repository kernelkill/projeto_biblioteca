package br.com.biblioteca.controll.action;

import javax.servlet.http.HttpServletRequest;

import br.com.biblioteca.model.Conexao;
import br.com.biblioteca.model.dao.AutorDAO;
import br.com.biblioteca.model.entity.Autor;

public class GravarAutor implements Action {
	
	public String executar(HttpServletRequest request) {
		try{
			 //1. ler dados da pagina e mapea como objeto autor
			int id = Integer.parseInt(request.getParameter("id"));
			String nome = request.getParameter("nome");
			String email = request.getParameter("email");
			
			Autor autor = new Autor();
			autor.setId(id);
			autor.setNome(nome);
			autor.setEmail(email);
			
			 //2. gravar dados
			AutorDAO autordao = new AutorDAO(Conexao.getConnection());
			if(id == 0){
				autordao.insert(autor);
			}else{
				autordao.update(autor);
			}
			
			//3. encaminhar para o JSP especifico
			request.setAttribute("proximaAcao", "InserirAutor");
			return "cadastroEfetuado.jsp";
			}catch(Exception error){
			error.printStackTrace();
		}
		return "erro.jsp";
	}
}
