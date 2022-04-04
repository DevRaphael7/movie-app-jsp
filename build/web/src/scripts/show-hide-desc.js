const descButton = document.querySelector("[btnDesc]")
const btnArrow = document.getElementById("arrowBtn")
const descricaoText = document.getElementById("descText")

var showDesc = false;

console.log(descButton)

descButton.addEventListener('click', () => {

    if(showDesc){
        btnArrow.innerHTML = "<i class='fa-solid fa-chevron-down'></i>" 
        descricaoText.classList.remove("hide")
        descricaoText.classList.add("show")
    } else {
        btnArrow.innerHTML = "<i class='fa-solid fa-chevron-up'></i>" 
        descricaoText.classList.remove("show")
        descricaoText.classList.add("hide")
    }
    
    showDesc = !showDesc
})