const form = document.getElementById("form")
const mensagemDeError = document.querySelectorAll("[error]")
const inputForm = document.querySelectorAll("[fieldForm]")

const nomeUsuario = formularioCad.usuario;
const email = formularioCad.email;
const senha = formularioCad.password;
const confirmarSenha = formularioCad.conf_password;

const errorFormRequest = document.querySelector('[errorRequest]')

form.addEventListener('submit', (e) => {
    e.preventDefault();

    if(!validarCadastro()){
        return
    }

    let url = 'http://localhost:8080/projeto_faculdade/CadastroHttp'
    let values = `user=${nomeUsuario.value}&password=${senha.value}&email=${email.value}`;

    makePOSTRequest(url, values)
})

function validarCadastro() {
    if(nomeUsuario.value.trim() == "") {
        setMensagemDeError(0, "Usuário inválido!", false)
        return false;
    } else {
        setMensagemDeError(0, "", true)
    }
 
    if(email.value.trim() == "") {
        setMensagemDeError(1, "E-mail inválido!", false)
        return false;
    } else {
        setMensagemDeError(1, "", true)
    }

    if(senha.value.trim() == "") {
        setMensagemDeError(2, "Senha inválida!", false)
        return false;
    } else {
        setMensagemDeError(2, "", true)
    }

    if(confirmarSenha.value.trim() == "") {
        setMensagemDeError(3, "Senha inválida!", false)
        return false;
    } else {
        setMensagemDeError(3, "", false)
    }

    if(senha.value !== confirmarSenha.value){
        setMensagemDeError(3, "Senhas diferentes!", false)
        return false;
    } else {
        setMensagemDeError(3, "", true)
    }

    return true
}

function setMensagemDeError(index, value, isNotInvalid) {
    if(isNotInvalid){
        mensagemDeError[index].classList.remove("error")
        inputForm[index].classList.remove("error")
        mensagemDeError[index].innerHTML = "";
        return
    }
    mensagemDeError[index].innerHTML = `<p>${value}</p>`
    mensagemDeError[index].classList.add("error")
    inputForm[index].classList.add("error")
}

var ajaxRequest = new window.XMLHttpRequest();

//String, String
function makePOSTRequest(url, values){
    if (window.XMLHttpRequest) {
        ajaxRequest = new XMLHttpRequest();
    } else if (window.ActiveXObject) {
        ajaxRequest = new ActiveXObject("Microsoft.XMLHTTP");
    }

    ajaxRequest.open('POST', url, true)
    ajaxRequest.setRequestHeader("Content-Type", "application/x-www-form-urlencoded") //Cabeçalho para enviar conteúdo de formulário
    ajaxRequest.send(values)
    ajaxRequest.onreadystatechange = setTimeout(() => respostaDoServidor(), 1000) // Isso deve ser chamado após o OPEN() E SEND()
}

function respostaDoServidor() {
    var resposta = ajaxRequest.responseText;

    if(Boolean(resposta)){
        errorFormRequest.innerHTML = "<p style='color: green'>Usuário cadastrado!</p>"
        return
    }

    errorFormRequest.innerHTML = "<p style='color: red'>Error</p>"
}