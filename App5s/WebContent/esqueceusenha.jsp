<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>


<link rel="stylesheet" type="text/css" href="./css/Ceuma.css">
	<meta http-equiv="content-type" content="text/html;charset=utf-8" /> 
	<meta name="viewport" content="width=device-width">

<title>Esqueceu Senha</title>
</head>
<body>
<div class="form-style-10">
		<div class="section">
			<form method="get" action="RecuperarSenhaServlet">
			
			<!-- RETORNO DO VALIDAR EMAIL(MENSAGEM DE ERRO) -->
			<%if(request.getAttribute("validarEmail")== null) 
			request.setAttribute("validarEmail", "");
			%>
			
				<center>E-mail:<input type="email" name="email" placeholder="exemplo@gmail.com" required="">
				<!-- VALIDAR EMAIL -->
				<p style="color: red";> <%=request.getAttribute("validarEmail") %></p>	
					<k>Já tem conta?&ensp;</k><a href="">Fazer Login</a><br><br>			
					<input type="submit" value="Recuperar"><br>
					<k>Passo 1-3</k>
				</center>
			</form>
		</div>
	</div>
</body>
</html>