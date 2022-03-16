<%-- 
    Document   : search-page
    Created on : Mar 5, 2022, 6:37:06 PM
    Author     : rapha
--%>
<%@page import="JDBC.ConnectionFactory" %> 
<%@page import="models.Filme" %>
<%@page import="java.util.ArrayList" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="pt-BR">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="../styles/style.css">
        <%-- <link rel="stylesheet" href="../styles/side-menu.css"> --%>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css">
        <title>Pesquisa</title>
    </head>
    <body>
        <% 
            String url = "http://localhost:8080/projeto_faculdade/SerchTxtFieldHttpRequest";
            ConnectionFactory conexao = new ConnectionFactory();
            String valorPesquisa = request.getParameter("searchField").isEmpty() ? request.getParameter("selectedGenre") : request.getParameter("searchField");
            ArrayList<Filme> allMovies = new ArrayList<>();
            if(valorPesquisa.equals("Todos")){
                allMovies = conexao.getMoviesDataBase("SELECT * FROM filmes");
            } else {
                allMovies = conexao.getMoviesDataBase(
                    "SELECT * FROM filmes WHERE LOWER(genero) LIKE '" + valorPesquisa.toLowerCase() + "%'" +
                    "|| LOWER(nome) LIKE '" + valorPesquisa.toLowerCase() + "%'" +
                    "|| SUBSTRING_INDEX(dataLanc, '-', 1) = '" + valorPesquisa.toLowerCase() + "'" + 
                    "|| LOWER(SUBSTRING_INDEX(genero, ', ', -1)) LIKE '" + valorPesquisa.toLowerCase() + "%'" +
                    "|| SUBSTRING_INDEX(nome, ' ', -1) LIKE '" + valorPesquisa.toLowerCase() + "%'" +
                    "|| genero LIKE '" + valorPesquisa + "'"
                );
            }
        %>
        
        <header class="home__page__header" headerPage>
            <form name="formularioPesquisa" method="post" action="search-page.jsp">
                <div class="search__bar" onblur="desfazerPesquisaSearchBar()" searchBarContainer>
                    <div style='display: flex'>
                        <input type="search" placeholder="Busca" name="searchField" onkeydown="makePOSTRequest('<%=url%>')"
                            autocomplete="off">
                        <button 
                            type="submit"
                            style="
                                background-color: transparent;
                                border: none;
                            "
                        ><i class="fa-solid fa-magnifying-glass" style="padding-right: 2.5vh;"></i></button>
                    </div>
                    <div class="imgSearchCont" searchMovieCont></div>
                </div>
            </form>
            <button class="menu__button" onclick="openSideMenu()">
                <i class="fa-solid fa-bars"></i>
            </button>
        </header>

        <section style="padding: 5vh;">
            <p class="boas__vindas__txt"><strong>Pesquisado por: <%= valorPesquisa %></strong></p>
            <div class="grid-movie">
                <% for(Filme mov: allMovies){ %>
                    <div class="img__card__medium" style="margin-left: 10px;">
                        <img src="<%= mov.getCover() %>">
                        <div class="txt_box">
                            <p class="name"><%= mov.getNome() %></p>
                            <p class="year"><%= mov.getDataLancamento().split("-")[0] %></p>
                        </div>
                    </div>
                <% } %>
            </div>
        </section>
        
        <%-- <script src="../scripts/sideMenu.js"></script> --%>
        <script src="../scripts/homePage.js"></script>
        <script src="../scripts/searchBar.js"></script>
        <script src="../scripts/Ajax.js"></script>
    </body>
</html>
