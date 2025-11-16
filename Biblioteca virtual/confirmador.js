/**
 * Confirmação de exclusão de um livro
 * @author Laura
 * @param idcon 
 */

function confirmar(idcon){
	let resposta = confirm("Excluir este livro?")
	if (resposta === true){
		window.location.href = "delete?idcon=" + idcon 
	}
}