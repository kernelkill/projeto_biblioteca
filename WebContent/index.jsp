<!-- 
    *Document   : Autor
    *Created on : Apr 24, 2016
    *Author     : Joabe Kachorroski
-->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SYSBI - BI</title>

<link rel="stylesheet" type="text/css"
	href="bootstrap/css/style-footer.css">
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
	<div class="navbar navbar-default navbar-fixed-top">
		<div class="container-fluid">
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">

					<li class="active"><a href="index.jsp">Home</a></li>

					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown">Genero<span class="caret"></span></a>
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
		<h1 align="center">SYSBI - Sistema de Cadastro de Biblioteca</h1>
		<img src="bootstrap/img/biblioteca.png"
			class="img-responsive img-rounded" alt="biblioteca" align="top">
	</div>
	<br>
	<br>
	<br>
	<br>
    <footer class="footer">
      <div class="container">
        <p class="text-muted" align="center">Software sob licença do Joabe Kachorroski.</p>
      </div>
    </footer>
</body>
</html>