<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"
	import="br.com.biblioteca.model.entity.Genero">

<title>Listar Generos</title>
<link rel="stylesheet" type="text/css"
	href="bootstrap/css/bootstrap.css">
<link rel="stylesheet" type="text/css"
	href="bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="bootstrap/css/bootstrap-theme.min.css">
<script src="bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
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
					<li class="active" class="dropdown"><a href="#"
						class="dropdown-toggle" data-toggle="dropdown">Genero<span
							class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="/biblioteca/servlet?acao=InserirGenero">Cadastrar</a></li>
							<li><a href="/biblioteca/servlet?acao=ListarGenero">Listar</a></li>
						</ul></li>

					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown">Livro<span class="caret"></span></a>
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
				</ul>
			</div>
		</div>
	</div>
	<div class="container">
		<h1 align="center">Generos Cadastrados</h1>
		<table class="table table-hover">
			<thead>
				<tr>
					<th>Descrição:</th>
					<th>Ação</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="genero" items="${lista }">
					<tr>
						<td style="width: 800px">${genero.descricao}</td>
						<div class="col-sd-10">
							<div class="btn-group">
								<td><a
									href="/biblioteca/servlet?acao=SelecionarGenero&id=${genero.id }"
									class="btn btn-primary"> <span
										class="glyphicon glyphicon-pencil"></span> Editar
								</a> <a
									href="/biblioteca/servlet?acao=RemoverGenero&id=${genero.id}"
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