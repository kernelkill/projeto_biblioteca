package br.com.biblioteca.controll.action;

import javax.servlet.http.HttpServletRequest;

public interface Action {
	public String executar(HttpServletRequest request) throws Exception;

}
