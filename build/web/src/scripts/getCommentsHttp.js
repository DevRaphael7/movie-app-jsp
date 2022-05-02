let comentsContainerList = document.querySelector("[comentsContainerList]")
let txtComent = document.getElementById("txtComent")

let userName = document.getElementById("userName")
let userPassword = document.getElementById("userPassword")
let idMov = document.getElementById("idMov")
const loading = document.querySelector("[loading]")
console.log(userName.innerHTML)

var ajaxRequest = new window.XMLHttpRequest();
function makeComentPOSTRequest(url){
    loading.classList.add("show")
    if (window.XMLHttpRequest) {
        ajaxRequest = new XMLHttpRequest();
    } else if (window.ActiveXObject) {
        ajaxRequest = new ActiveXObject("Microsoft.XMLHTTP");
    }

    ajaxRequest.open('POST', url, true)
    ajaxRequest.setRequestHeader("Content-Type", "application/x-www-form-urlencoded") 
    ajaxRequest.send()
    ajaxRequest.onreadystatechange = setTimeout(() => respostaDoServidorGetComment(), 500)
    loading.classList.remove("show")
}

async function respostaDoServidorGetComment() {
    var resposta = ajaxRequest.responseText
    comentsContainerList.innerHTML = resposta;
}

makeComentPOSTRequest(`http://localhost:8080/projeto_faculdade/getCommentsHttp?idMov=${idMov.innerHTML}`);

function addComentPOST() {
    loading.classList.add("show")
    if(txtComent.value.length == 0){
        return
    }
    var url = `http://localhost:8080/projeto_faculdade/ComentsHTTP?comentUser=${txtComent.value}&usuario=${userName.innerHTML}&password=${userPassword.innerHTML}&idFilme=${idMov.innerHTML}`

    if (window.XMLHttpRequest) {
        ajaxRequest = new XMLHttpRequest();
    } else if (window.ActiveXObject) {
        ajaxRequest = new ActiveXObject("Microsoft.XMLHTTP");
    }

    ajaxRequest.open('POST', url, true)
    ajaxRequest.setRequestHeader("Content-Type", "application/x-www-form-urlencoded") 
    ajaxRequest.send()
    ajaxRequest.onreadystatechange = setTimeout(() => {
        makeComentPOSTRequest(`http://localhost:8080/projeto_faculdade/getCommentsHttp?idMov=${idMov.innerHTML}`)
    }, 500)
    
}   