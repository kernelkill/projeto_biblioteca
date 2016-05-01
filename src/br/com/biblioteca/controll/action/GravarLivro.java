package br.com.biblioteca.controll.action;

import javax.servlet.http.HttpServletRequest;

import br.com.biblioteca.model.Conexao;
import br.com.biblioteca.model.dao.AutorDAO;
import br.com.biblioteca.model.dao.GeneroDAO;
import br.com.biblioteca.model.dao.LivroDAO;
import br.com.biblioteca.model.entity.Autor;
import br.com.biblioteca.model.entity.Genero;
import br.com.biblioteca.model.entity.Livro;

public class GravarLivro implements Action{

	@Override
	public String executar(HttpServletRequest request) {
		try{
			int isbn = Integer.parseInt(request.getParameter("isbn"));
			String titulo = request.getParameter("titulo");
			String descricao = request.getParameter("descricao");
			int anoLancamento = Integer.parseInt(request.getParameter("anolancamento"));
			int idAutor = Integer.parseInt(request.getParameter("idAutor"));
			int idGenero = Integer.parseInt(request.getParameter("idGenero"));
			
			Livro livro = new Livro();
			livro.setIsbn(isbn);
			livro.setTitulo(titulo);
			livro.setDescricao(descricao);
			livro.setAnoLancamento(anoLancamento);
			
			AutorDAO autorDAO = new AutorDAO(Conexao.getConnection());
			Autor autor = autorDAO.getById(idAutor);
			livro.setAutor(autor);
			
			GeneroDAO generoDAO = new GeneroDAO(Conexao.getConnection());
			Genero genero = generoDAO.getById(idGenero);
			livro.setGenero(genero);
			
			LivroDAO livroDAO = new LivroDAO(Conexao.getConnection());
			if(isbn == 0){
				livroDAO.insert(livro);
			}else{
				livroDAO.update(livro);
			}
			request.setAttribute("proximaAcao", "InserirLivro");
			return "cadastroEfetuado.jsp";
		}catch(Exception error){
			error.printStackTrace();
		}
		return "erro.jsp";
	}

}
