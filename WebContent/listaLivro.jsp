<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="br.com.biblioteca.model.entity.Autor"
	import="br.com.biblioteca.model.entity.Genero"
	import="br.com.biblioteca.model.entity.Livro"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Listar Livro</title>

<link rel="stylesheet" type="text/css"
	href="bootstrap/css/bootstrap.css">
<link rel="stylesheet" type="text/css"
	href="bootstrap/css/bootstrap.min.css">
<script type="text/javascript" src="bootstrap/js/bootstrap.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<script src="bootstrap/js/bootstrap.js" type="text/javascript"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$('.dropdown-toggle').dropdown();
	})
</script>
</head>
<body>
	<br>
	<br>
	<div class="navbar navbar-default navbar-fixed-top">
		<div class="container-fluid">
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<li><a href="index.jsp">Home</a></li>
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown">Genero<span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="/biblioteca/servlet?acao=InserirGenero">Cadastrar</a></li>
							<li><a href="/biblioteca/servlet?acao=ListarGenero">Listar</a></li>
						</ul></li>

					<li class="active" class="dropdown"><a href="#"
						class="dropdown-toggle" data-toggle="dropdown">Livro<span
							class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="/biblioteca/servlet?acao=InserirLivro">Cadastrar</a></li>
							<li><a href="/biblioteca/servlet?acao=ListarLivro">Listar</a></li>
						</ul></li>

					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown">Autor<span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="/biblioteca/servlet?acao=InserirAutor">Cadastrar</a></li>
							<li><a href="/biblioteca/servlet?acao=ListarAutor">Listar</a></li>
						</ul></li>
					<form class="navbar-form nav  navbar-right" role="search"
						method='post' action='/biblioteca/servlet'>
						<input type='hidden' name='acao' value='PesquisarLivro'>
						<div class="form-group">
							<input type="text" name="pesquisar" value="${pesquisar}"
								class="form-control" placeholder="Pesquisar">
						</div>
						<button type="submit" class="btn btn-default">Pesquisar</button>
					</form>
				</ul>
			</div>
		</div>
	</div>
	<div class="container">
		<h1 align="center">Livros Cadastrados</h1>
		<table class="table table-hover">
			<thead>
				<tr>
					<th>Titulo</th>
					<th>Descrição</th>
					<th>Ano de lancamento</th>
					<th>Genero</th>
					<th>Autor</th>
					<th>Açoes</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="livro" items="${lista }">
					<tr>
						<td>${livro.titulo}</td>
						<td>${livro.descricao}</td>
						<td style="width: 100px">${livro.anoLancamento}</td>
						<td>${livro.genero.descricao}</td>
						<td>${livro.autor.nome}</td>
						<div class="col-sd-10">
							<div class="btn-group">
								<td style="width: 200px"><a
									href="/biblioteca/servlet?acao=SelecionarLivro&isbn=${livro.isbn }"
									class="btn btn-primary"> <span
										class="glyphicon glyphicon-pencil"></span> Editar
								</a> <a
									href="/biblioteca/servlet?acao=RemoverLivro&isbn=${livro.isbn}"
									class="btn btn-danger"> <span
										class="glyphicon glyphicon-trash"></span> Excluir
								</a></td>
							</div>
						</div>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>