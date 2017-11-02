<%@page import="model.BeanEmpresa"%>
<%@page import="model.DaoDepartamento"%>
<%@page import="model.BeanDepartamento"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="./css/Ceuma.css">
<meta http-equiv="content-type" content="text/html;charset=utf-8" />
<meta name="viewport" content="width=device-width">

<title>Principal</title>
</head>
<body>

	<header> <a	href="cadastroempresa.jsp"><button>Criar
			Empresa</button></a>
	<br>
	<br>
	<button>Sobre</button>
	<br>
	</header>
	<div class="form-style-10">
		<br>
		
<% List <BeanEmpresa> listaEmpresas =(List<BeanEmpresa>) request.getAttribute("empresas"); 
%>
		<table class="tabela" align="center">
			<caption>Minhas Avaliações</caption>
			<thead>
				<tr>				
					<td>Nome</td>
					<td >Telefone</td>
												
				</tr>
			</thead>
			<tbody>				
			<%for(BeanEmpresa empresa : listaEmpresas){ %>
				<tr>
													         	<!-- MANDANDO A EMPRESA NO PARAMENTRO -->
					<td><a href="CadastroDepartamentoServlet?acao=visualizar&empresa=<%=empresa.getNome()%>"><%= empresa.getNome()%></a></td>
					<td><%=empresa.getTelefone() %></td>
					
					
					
					
				</tr>
				<%} %>

			</tbody>
	
	</div>



</body>
</html>