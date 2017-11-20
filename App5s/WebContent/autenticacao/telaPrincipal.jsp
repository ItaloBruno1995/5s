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

	<header> <a
		href="autenticacao/cadastrardepartamento.jsp"><button>Criar
			Departamento</button></a>
	<br>
	<br>
	<a href="javascript:window.history.go(-1)"><button>Voltar</button></a>
	<br>
	</header>
	<div class="form-style-10">
		<br>
		<%int contador = 0;
			double somatorio = 0;	
		%>
		
<% List <BeanDepartamento> listaDepartamento =(List<BeanDepartamento>) request.getAttribute("departamentos"); 
%>
		<table class="tabela" align="center">
			<caption>Minhas Avaliações</caption>
			<thead>
				<tr>
					<td>Código</td>
					<td>Departamento</td>
					<td>Data</td>
					<td>Avaliação</td>
				
				</tr>
			</thead>
			<tbody>
			<%for(BeanDepartamento departamento : listaDepartamento){ %>
				<tr>
					<td><%= departamento.getId()%></td>
					<td><a href="MostraDadosServlet?departamento=<%=departamento.getNome()%>"><%= departamento.getNome()%></a></td>
					<td><%=departamento.getDataCriado() %></td>
					<!-- Bucar dados em outra tabela -->
					<td><%=departamento.getTotal()%>%</td>
					
					<% contador++;
					somatorio= somatorio +departamento.getTotal(); %>
				</tr>
				<%} %>

			</tbody>
		</table>
		
		<br> <b>Média Geral: <%=somatorio/contador%></b><br>
		<br> <b>Situação:</b>
		<table class="tabela" style="margin: -60px 100px">
			<tbody>
				<tr>
					<td><%=request.getAttribute("mediaGeral") %>%</td>
				</tr>
			</tbody>
		</table>
		<table class="tabela" style="margin: -160px 100px">
			<tbody>
				<tr>
					<td>-</td>
				</tr>
			</tbody>
		</table>
	</div>



</body>
</html>