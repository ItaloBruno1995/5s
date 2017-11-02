<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<link rel="stylesheet" type="text/css" href="./css/Ceuma.css">
	<meta http-equiv="content-type" content="text/html;charset=utf-8" /> 
	<meta name="viewport" content="width=device-width, height=device-height, initial-scale=1, maximum-scale=1, user-scalable=no" />

<title>Cadastro de Usuario</title>
</head>
<body>
<div class="form-style-10">
		<div class="section">
			<form method="post" action="cadastroUsuarioServlet">
				<center>Nome Completo:<input type="text" name="nome" id="" required=""></center>
				<center>E-mail:<input type="email" name="email" id="" placeholder="exemplo@gmail.com" required=""></center>
				<center>Senha:<input type="password" name="senha" id="" placeholder="***********"></center>
				<center>Data de Nascimento:<input type="date" name="dataNascimento" id="" placeholder="***********"></center>
				<center><k>Já tem conta?&ensp;</k><a href="index.jsp">Fazer Login</a></center><br>
				<center><input type="submit" value="Salvar"><center>
			</form>
		</div>
	</div>
</body>
</html>