/**
 * Validação de formulário
 * @author Laura
 */

function validar(){
	let nome = frmLivro.nome.value
	let autor = frmLivro.autor.value
	let sinopse = frmLivro.sinopse.value
	let ano = frmLivro.ano.value
	let genero = frmLivro.genero.value
	if (nome === ""){
		alert('Preencha o formulário')
		frmLivro.nome.focus
		return false
	}else if (autor === ""){
		alert('Preencha o formulário')
				frmLivro.autor.focus
				return false
	}else if(sinopse === ""){
		alert('Preencha o formulário')
						frmLivro.sinopse.focus
						return false
	}else if (ano === ""){
		alert('Preencha o formulário')
								frmLivro.ano.focus
								return false
	}else if (genero === ""){
		alert('Preencha o formulário')
						frmLivro.genero.focus
						return false
	}else{
		document.forms["frmLivro"].submit()
	}
}