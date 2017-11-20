
<%@page import="model.BeanResultado"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="Ceuma.css">
	<meta name="viewport" content="width=device-width">
<title>Resultado</title>
</head>
<body>


<header>
		<center><h1>Resultado</h1></center>
		
	</header>
	<div class="form-style-10">
		<br>
		<% List <BeanResultado> listaResultados =(List<BeanResultado>) request.getAttribute("resultado"); %>
		
		<table class="tabela" align="center" style="width: 70%">
			<caption>Minhas Avaliações</caption>

			<thead style="width: auto">
			
			
			
				<tr>
					<td>   Itens Avaliados</td>
					<td>Pontos</td><br>
					
				</tr>
			</thead>
			<% int contador=0;
				double somatorio=0;
				%>
			<tbody style="height: 100px;">
			<%for(BeanResultado resultado : listaResultados){ %>
				<tr>
					<td>     Seletividade</td>
					<td > <%= resultado.getS1() %></td>					
				</tr>
				<tr>
					<td>   Sistematização</td>
					<td > <%=resultado.getS2() %></td>					
				</tr>
				<tr>
					<td>     Sem Sujeira</td>
					<td > <%= resultado.getS3() %></td>					
				</tr>
				<tr>
					<td>     Saúde</td>
					<td > <%=resultado.getS4() %></td>					
				</tr>
				<tr>
					<td>     Socialização</td>
					<td ><%=resultado.getS5() %></td>					
				</tr>
						<% contador++;
						somatorio = contador +resultado.getS1()+resultado.getS2()+resultado.getS3()+resultado.getS4()+resultado.getS5(); 
						 %>				
				<%} %>				
			</tbody>
		</table><br>
		<h4>Total Aproveitamento: <%=somatorio/5%>  </h4>
		<center><a href="./TelaInicialServlet"><input type="submit" name="" id="" value="Salvar e Finalizar"></a></center><br>
	</div>


</body>
</html>

