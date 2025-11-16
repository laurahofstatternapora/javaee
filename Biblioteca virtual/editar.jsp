<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Catálogo de livros</title>
<link rel="icon" href="imagens/book1.png">
<link rel="stylesheet" href="style.css">
</head>
</body>
<h1>Editar livro</h1>
<form name="frmLivro" action="update">
	<table>
		<td><input type="text" name="idcon" id="caixa" readonly
			value="<%out.print(request.getAttribute("idcon"));%>"></td>
		<tr>
			<td><input type="text" name="nome" class="Caixa"
				value="<%out.print(request.getAttribute("nome"));%>"></td>
		</tr>
		<tr>
			<td><input type="text" name="autor" class="Caixa"
				value="<%out.print(request.getAttribute("autor"));%>"></td>
		</tr>
		<tr>
			<td><input type="text" name="sinopse" class="Caixa"
				value="<%out.print(request.getAttribute("sinopse"));%>"></td>
		</tr>
		<tr>
			<td><input type="text" name="ano" class="Caixa"
				value="<%out.print(request.getAttribute("ano"));%>"></td>
		</tr>
		<tr>
			<td><input type="text" name="genero" class="Caixa"
				value="<%out.print(request.getAttribute("genero"));%>"></td>
		</tr>
	</table>
	<input type="button" value="Salvar" class="Botao1" onclick="validar()">
</form>
<script src="scripts/validador.js"></script>
</body>
</html>