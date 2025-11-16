<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.JavaBeans"%>
<%@ page import="java.util.ArrayList"%>
<%
    @ SuppressWarnings ("unchecked")
    ArrayList<JavaBeans> lista = (ArrayList<JavaBeans>)request.getAttribute("livros");
%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<title>Catálogo de livros</title>
<link rel="icon" href="imagens/book1.png">
<link rel="stylesheet" href="style.css">
</head>
<body>
	<h1>Catálogo de livros</h1>
	<a href="novo.html" class="Botao1">Novo livro</a>
	<table id="tabela">
	<thead>
	<tr>
	<th>Id</th>
	<th>Nome</th>
	<th>Autor</th>
	<th>Sinopse</th>
	<th>Ano</th>
	<th>Gênero</th>
	<th>Opções</th>
	</tr>
	</thead>
	<tbody>
	   <%for (int i = 0; i <lista.size(); i++) { %>
	   <tr>
	      <td><%=lista.get(i).getIdcon()%></td>
	       <td><%=lista.get(i).getNome()%></td>
	       <td><%=lista.get(i).getAutor()%></td>
	       <td><%=lista.get(i).getSinopse()%></td>
	       <td><%=lista.get(i).getAno()%></td>
	       <td><%=lista.get(i).getGenero()%></td>
	       <td><a href="select?idcon=<%=lista.get(i).getIdcon()%>" class=Botao1>Editar</a>
	           <a href="javascript: confirmar(<%=lista.get(i).getIdcon()%>)" class=Botao2>Excluir</a>
	       </td>
	   </tr>
	   <%} %>
	</tbody>
	</table>
	<script src="scripts/confirmador.js"></script>
</body>
</html>