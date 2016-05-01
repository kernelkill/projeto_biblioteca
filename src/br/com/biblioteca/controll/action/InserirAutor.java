package br.com.biblioteca.controll.action;

import javax.servlet.http.HttpServletRequest;
import br.com.biblioteca.model.entity.Autor;

public class InserirAutor  implements Action{

	public String executar(HttpServletRequest request) {
		try{
			 //1. instanciar um objeto autor
			Autor autor = new Autor();
	     
			//2. inserir objeto na requisicao	
			request.setAttribute("autor", autor );
			
			//3. encaminhar para JSP especifico
			return "formAutor.jsp";
		}catch(Exception error){
		error.printStackTrace();	
		}
		return "erro.jsp";
	}
}
