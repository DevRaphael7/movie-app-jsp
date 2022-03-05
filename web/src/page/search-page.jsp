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
        <link rel="stylesheet" href="../styles/side-menu.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css">
        <title>Pesquisa</title>
    </head>
    <body>
        <% 
            ConnectionFactory conexao = new ConnectionFactory();
            String valorPesquisa = request.getParameter("searchField");
            ArrayList<Filme> allMovies = conexao.getMoviesDataBase(
                "SELECT * FROM filmes WHERE LOWER(genero) LIKE '" + valorPesquisa.toLowerCase() + "%'" +
                "|| LOWER(nome) LIKE '" + valorPesquisa.toLowerCase() + "%'" +
                "|| SUBSTRING_INDEX(dataLanc, '-', 1) = '" + valorPesquisa.toLowerCase() + "'" +
                "LOWER(SUBSTRING_INDEX(nome, ' ', 1)) LIKE '" + valorPesquisa.toLowerCase() + "';"
            );
        %>
        <nav class="side__menu">
            <div class="foraDoMenu" foraMenu onclick="openSideMenu()"></div>
            <div class="menu" id="sideMenu">
                <div class="informacoes_usuario">
                    <div class="user__data">
                        <img
                            src="data:image/jpeg;base64,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">
                        <div class="user__info">
                            <h3>Raphael</h3>
                            <p>raphael@email.com</p>
                        </div>
                    </div>
                    <div class="search__bar">
                        <input type="search" placeholder="Busca" style="width: 220px;">
                        <i class="fa-solid fa-magnifying-glass"></i>
                    </div>
                </div>
            </div>
        </nav>
        
        <header class="home__page__header" headerPage>
            <form name="formularioPesquisa" method="post" action="search-page.jsp">
                <div class="search__bar">
                    <input type="search" placeholder="Busca" name="searchField">
                    <button 
                        type="submit"
                        style="
                            background-color: transparent;
                            border: none;
                        "
                    ><i class="fa-solid fa-magnifying-glass" style="padding-right: 2.5vh;"></i></button>
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
        
        <script src="../scripts/sideMenu.js"></script>
        <script src="../scripts/homePage.js"></script>
        <script src="../scripts/searchBar.js"></script>
    </body>
</html>
