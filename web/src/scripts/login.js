const form = document.getElementById("form")
const formUser = formularioLogin.usuario;
const formPassword = formularioLogin.password;
const mensagemDeError = document.querySelectorAll("[error]")
const inputForm = document.querySelectorAll("[fieldForm]")
const submitButton = document.getElementById("submitButton")
const passwordHideBtn = document.getElementById("passBtn")

let hideOrShowPassword = false;

console.log(inputForm)

form.addEventListener('submit', e => {
    if(!validarFormulario()){
        e.preventDefault();
    }
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
        //passwordHideBtn.innerHTML = '<i class="fa-solid fa-eye-slash"></i>'
        passwordHideBtn.innerHTML = '<i class="fa-solid fa-unlock"></i>'
    } else {
        formularioLogin.password.type = 'password'
        //passwordHideBtn.innerHTML = '<i class="fa-solid fa-eye"></i>'
        passwordHideBtn.innerHTML = '<i class="fa-solid fa-lock"></i>'
    }
}