const ativoNavBarButton = document.querySelectorAll("[active]")
const headerPage = document.querySelector("[headerPage]")
const secaoFilme = document.querySelectorAll("[secaoFilme]")
const detaqueMovie = document.getElementById("detaqueMovie")

const imgRowF = document.querySelectorAll('[imgRowF]')
const imgRowS = document.querySelectorAll('[imgRowS]')
// 159357Am@$

const infoMovF = document.querySelectorAll("[infoMovF]")
const infoMovS = document.querySelectorAll('[infoMovS]')

const leftButtonF = document.getElementById("img-scroll-left-f")
const rightButtonF = document.getElementById('img-scroll-right-f')

const leftButtonS = document.getElementById('img-scroll-left-s')
const rightButtonS = document.getElementById('img-scroll-right-s')

imgRowF[0].classList.add('active')
infoMovF[0].classList.add('active')

ativoNavBarButton.forEach((value, index) => {
    value.addEventListener('click', () => {
        value.id = 'active'
        
        secaoFilme[index].classList.add("active")

        for(let i = 0;i < ativoNavBarButton.length;i++){
            if(i !== index){
                ativoNavBarButton[i].removeAttribute('id')
                secaoFilme[i].classList.remove("active")
            }
        }
    })       
})

leftButtonF.addEventListener('click', () => {
    
    let ind = 0;
    
    imgRowF.forEach((value, index) => {
        if(value.classList.contains('active')){
            ind = index;
        }
    })
    
    imgRowF[ind].classList.remove('active')
    infoMovF[ind].classList.remove('active')
    imgRowF[ind === 0 ? imgRowF.length - 1 : ind - 1].classList.add('active')
    infoMovF[ind === 0 ? imgRowF.length - 1 : ind - 1].classList.add('active')
})

leftButtonS.addEventListener('click', () => {
    
    let ind = 0;
    
    imgRowS.forEach((value, index) => {
        if(value.classList.contains('active')){
            ind = index
        }
    })
    
    imgRowS[ind].classList.remove('active')
    infoMovS[ind].classList.remove('active')
    imgRowS[ind === 0 ? imgRowS.length - 1 : ind - 1].classList.add('active')
    infoMovS[ind === 0 ? imgRowS.length - 1 : ind - 1].classList.add('active')
})

rightButtonF.addEventListener('click', () => {

    let ind = 0;

    imgRowF.forEach((value, index) => {
        if(value.classList.contains('active')){
            ind = index
        }
    })

    imgRowF[ind].classList.remove('active')
    infoMovF[ind].classList.remove('active')
    imgRowF[ind + 1 === imgRowF.length ? 0 : ind + 1].classList.add('active')
    infoMovF[ind + 1 === infoMovF.length ? 0 : ind + 1].classList.add('active')
})

rightButtonS.addEventListener('click', () => {
    let ind = 0;
    let indInfoMov = 0

    imgRowS.forEach((value, index) => {
        if(value.classList.contains('active')){
            ind = index
        }
    })

    imgRowS[ind].classList.remove('active')
    infoMovS[ind].classList.remove('active')
    imgRowS[ind + 1 === imgRowS.length ? 0 : ind + 1].classList.add('active')
    infoMovS[ind + 1 === infoMovS.length ? 0 : ind + 1].classList.add('active')
})

