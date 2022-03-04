const sideMenu = document.getElementById("sideMenu")
const foraDoMenu = document.querySelector("[foraMenu]")
var sideMenuOpened = false;

console.log(sideMenu)

function openSideMenu(){
    console.log("Abrir ou fechar menu...")
    sideMenuOpened = !sideMenuOpened;

    if(sideMenuOpened){
        sideMenu.style.animation = "abrindo-menu 1000ms forwards"
        sideMenu.classList.add("show")
        foraDoMenu.classList.add("show")
        return
    }
    sideMenu.style.animation = "fechando-menu 1000ms forwards"
    foraDoMenu.classList.remove("show")
    sideMenu.classList.remove("show")
}