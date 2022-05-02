const form = document.getElementById("form")
const formUser = formularioLogin.usuario;
const formPassword = formularioLogin.password;
const mensagemDeError = document.querySelectorAll("[error]")
const inputForm = document.querySelectorAll("[fieldForm]")
const submitButton = document.getElementById("submitButton")
const passwordHideBtn = document.getElementById("passBtn")
const errorFormRequest = document.querySelector('[errorRequest]')
const loading = document.querySelector("[loading]")

let hideOrShowPassword = false;

form.addEventListener('submit', e => {
    loading.classList
    errorFormRequest.innerHTML  = ""
    if(!validarFormulario()){
        e.preventDefault();
        return
    }
    
    postLoginUser()
    e.preventDefault();
})

function validarFormulario() {
    if(formUser.value.trim() === ""){
        setMensagemDeError(0, "Usuário não informado!", false)
        formUser.focus()
        return false
    } else {
        setMensagemDeError(0, "Usuário não informado!", true)
    }

    if(formPassword.value.trim() === ""){
        setMensagemDeError(1, "Senha não informada!", false)
        formPassword.focus()
        return false
    } else {
        setMensagemDeError(1, "Senha não informada!", true)
    }
    return true
}

function setMensagemDeError(index, value, isNotInvalid){
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

function changeTypeInputPassword() {
    hideOrShowPassword = !hideOrShowPassword;
    if(hideOrShowPassword){
        formularioLogin.password.type = 'text'
        passwordHideBtn.innerHTML = '<i class="fa-solid fa-unlock"></i>'
    } else {
        formularioLogin.password.type = 'password'
        passwordHideBtn.innerHTML = '<i class="fa-solid fa-lock"></i>'
    }
}

var ajaxRequest = new window.XMLHttpRequest();

function postLoginUser(){
    if (window.XMLHttpRequest) {
        ajaxRequest = new XMLHttpRequest();
    } else if (window.ActiveXObject) {
        ajaxRequest = new ActiveXObject("Microsoft.XMLHTTP");
    }
    
    ajaxRequest.open('POST', "http://localhost:8080/projeto_faculdade/loginDataBase", true)
    ajaxRequest.setRequestHeader("Content-Type", "application/x-www-form-urlencoded")
    ajaxRequest.send(`usuario=${formUser.value}&senha=${formPassword.value}`)
    ajaxRequest.onreadystatechange = setTimeout(() => respostaDoServidor(), 1000)
}

function respostaDoServidor() {
    var resposta = ajaxRequest.responseText
    if(parseInt(resposta) === -1){
        form.submit();
        return
    }

    if(!resposta) {
        errorFormRequest.innerHTML = '<p style="text-align: center; color: #db483c;">Error na conexão com banco de dados</p>'
        return
    }
    errorFormRequest.innerHTML = `<p style="text-align: center; color: #db483c;">${resposta}</p>`
}