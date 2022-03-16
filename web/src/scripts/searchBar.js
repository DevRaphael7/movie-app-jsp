const btnSearch = formularioPesquisa;
const searchField = formularioPesquisa.searchField;
const selectedGenre = formularioPesquisa.selectedGenre;

btnSearch.addEventListener('submit', e => {
    if(searchField.value.trim() === ""){
        e.preventDefault();
    }
})

function submitSelectedGenre(value){
    searchField.value = "";
    btnSearch.submit()
}

selectedGenre.addEventListener('submit', e => {
    btnSearch.value = "";
    e.submit();
})

function goToSearchPage(value) {
    searchField.value = `http://localhost:8080/projeto_faculdade/SerchTxtFieldHttpRequest?searchField=${value}`
    btnSearch.submit()
}