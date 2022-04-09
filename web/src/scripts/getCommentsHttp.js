let comentsContainerList = document.querySelector("[comentsContainerList]")
let txtComent = document.getElementById("txtComent")

let userName = document.getElementById("userName")
let userPassword = document.getElementById("userPassword")
let idMov = document.getElementById("idMov")

var ajaxRequest = new window.XMLHttpRequest();
function makePOSTRequest(url){
    if (window.XMLHttpRequest) {
        ajaxRequest = new XMLHttpRequest();
    } else if (window.ActiveXObject) {
        ajaxRequest = new ActiveXObject("Microsoft.XMLHTTP");
    }

    ajaxRequest.open('POST', url, true)
    ajaxRequest.setRequestHeader("Content-Type", "application/x-www-form-urlencoded") 
    ajaxRequest.send()
    ajaxRequest.onreadystatechange = setTimeout(() => respostaDoServidor(), 500)
}

async function respostaDoServidor() {
    var resposta = ajaxRequest.responseText
    comentsContainerList.innerHTML = resposta;
}

makePOSTRequest("http://localhost:8080/projeto_faculdade/getCommentsHttp");

function addComentPOST() {
    var url = `
        localhost:8080/projeto_faculdade/ComentsHTTP?
        comentUser=${txtComent.value}&
        usuario=${userName.value}&
        password=${userPassword.value}&
        idFilme=${idMov.value}
    `
    makePOSTRequest(url)
    console.log(userName.value)
}   