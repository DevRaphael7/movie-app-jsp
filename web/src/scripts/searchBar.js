const btnSearch = formularioPesquisa;
const searchField = formularioPesquisa.searchField;

btnSearch.addEventListener('submit', e => {
    if(searchField.value.trim() === ""){
        e.preventDefault();
    }
})