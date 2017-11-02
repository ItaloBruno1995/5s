<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="../css/Ceuma.css">
	<meta http-equiv="content-type" content="text/html;charset=utf-8" /> 
	<meta name="viewport" content="width=device-width">
<title>Cadastrar Departamento</title>
</head>
<body>

<div class="form-style-10">
		<div class="section">
			<form method="post" action="../CadastarDepartamentoServlet?acao=cadastrar">
				<center>Nome:<input type="text" name="nome" placeholder="Ex: Sala de Aula, Laboratório..." required=""></center>
				<br>
				<center>Data de Hoje:<input type="date" name="data" id="" placeholder="***********"></center>


				<center><input type="submit" value="Avançar"></center>
			</form>
			<!-- "CadastarDepartamentoServlet?acao=cadastrar" -->
			<k>Passo 1-6</k>
		</div>
	</div>

</body>
</html>