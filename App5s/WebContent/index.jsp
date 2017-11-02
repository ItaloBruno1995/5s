<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/Ceuma.css">
<meta http-equiv="content-type" content="text/html;charset=utf-8" /> 
<meta name="viewport" content="width=device-width">

<title>Login</title>
</head>
<body>


<div class="form-style-10">

		<div class="section">
		<form action="loginUsuarioServlet" method="get">
		<!-- RETORNO DO LOGIN(MENSAGEM DE ERRO) -->
			<%if(request.getAttribute("status")== null) 
			request.setAttribute("status", "");
			%>
			
         <center><p style="color: red;"><%=request.getAttribute("status")%></p></center> 
				<center>Login:<input type="email" name="email" placeholder="exemplo@gmail.com" required="required"></center>
				<center>Senha:<input type="password" name="senha" placeholder="***********"></center><br>
				<center><a href="esqueceusenha.jsp">Esqueceu sua senha?</a></center>
				<center><a href="cadastrousuario.jsp">Cadastro</a></center><br>
				<center><input type="submit" value="Entrar"></center>
				</form>
		</div>
	</div>

</body>
</html>