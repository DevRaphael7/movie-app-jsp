let searchMovieCont = document.querySelector('[searchMovieCont]')
let searchBarContainer = document.querySelector('[searchBarContainer')


console.log(searchBarContainer)
console.log(formularioPesquisa.searchField)

formularioPesquisa.searchField.addEventListener('blur', () => {
    searchBarContainer.addEventListener('mouseleave', (e) => {   
        searchMovieCont.classList.remove("show")
        return
    })
});

var ajaxRequest = new window.XMLHttpRequest();
function makePOSTRequest(url){
    if(formularioPesquisa.searchField.value.length === 0){
        return
    }

    if (window.XMLHttpRequest) {
        ajaxRequest = new XMLHttpRequest();
    } else if (window.ActiveXObject) {
        ajaxRequest = new ActiveXObject("Microsoft.XMLHTTP");
    }

    ajaxRequest.open('POST', url, true)
    ajaxRequest.setRequestHeader("Content-Type", "application/x-www-form-urlencoded") //Cabeçalho para enviar conteúdo de formulário
    ajaxRequest.send(`value=${formularioPesquisa.searchField.value}`)
    ajaxRequest.onreadystatechange = setTimeout(() => respostaDoServidor(), 500) // Isso deve ser chamado após o OPEN() E SEND()
}

async function respostaDoServidor() {
    var resposta = ajaxRequest.responseText
    if(resposta) searchMovieCont.classList.add("show")
    searchMovieCont.innerHTML = resposta
}