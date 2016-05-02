<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"
	import="br.com.biblioteca.model.entity.Genero">

<title>Cadastro de Genero</title>
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
					
					<li class="dropdown"><a href="#"
						class="dropdown-toggle" data-toggle="dropdown">Livro<span
							class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="/biblioteca/servlet?acao=InserirLivro">Cadastrar</a></li>
							<li><a href="/biblioteca/servlet?acao=ListarLivro">Listar</a></li>
						</ul></li>
					
					<li class="dropdown"><a href="#"
						class="dropdown-toggle" data-toggle="dropdown">Autor<span
							class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="/biblioteca/servlet?acao=InserirAutor">Cadastrar</a></li>
							<li><a href="/biblioteca/servlet?acao=ListarAutor">Listar</a></li>
						</ul></li>
				</ul>
			</div>
		</div>
	</div>
	<div class="container">
		<div class="row">
			<h1 align="center">Cadastrar Autores</h1>
			<div align="left" class="span6">
				<br> <br>
				<form class="form-horizontal" method='post'
					action='/biblioteca/servlet'>
					<input type='hidden' name='acao' value='GravarGenero'> <input
						type='hidden' name='id' value='${genero.id }'>

					<div class="form-group">
						<label class="col-sm-2 control-label">Descrição: </label>
						<div class="col-md-8">
							<input type='text' name='descricao' value='${genero.descricao}'
								class="form-control" placeholder="Digite a descricao" data-error="Por favor, informe uma descrição." required>
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-2 col-md-10">
							<button type="submit" class="btn btn-success">Salvar</button>
							<button type="reset" class="btn btn-danger">Limpar</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
	<script src="bootstrap/js/bootstrap.min.js"></script>

</body>
</html>