<%@page import="models.Usuarios"%>
<%@page import="JDBC.ConnectionFactory" %> 
<%@page import="models.Filme" %>
<%@page import="provider.Search" %>
<%@page import="models.Serie" %>
<%@page import="java.util.ArrayList" %>
<%@page import="java.time.LocalDate" %>
<%@page language="java" contentType="text/html" pageEncoding="UTF-8" %>

    <!DOCTYPE html>
    <html lang="pt-BR">

    <% 
        String url = "http://localhost:8080/projeto_faculdade/SerchTxtFieldHttpRequest";
        ConnectionFactory conexao = new ConnectionFactory();
        
        String nomeEmail = "";
        String senha = "";
        Cookie[] usuario = request.getCookies();
        for(Cookie item: usuario){
            if(item.getName().equals("nome")){
                nomeEmail = item.getValue();
            }
            
            if(item.getName().equals("senha")){
                senha = item.getValue();
            }
        }
        
        Usuarios user = conexao.getUserDB(new Usuarios(nomeEmail, senha));
    %>

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="../styles/style.css">
        <link rel="stylesheet" href="../styles/side-menu.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css">
        <title>Página principal</title>
    </head>

    <body>
        
        <% 
            ArrayList<Filme> allMovies = conexao.getMoviesDataBase("SELECT * FROM filmes;");
            ArrayList<Serie> allSeries = conexao.getSerie("SELECT * FROM series");
            Search pesquisa = new Search();
            LocalDate dataAtual = LocalDate.now();
        %>

        <nav class="side__menu">
            <div class="foraDoMenu"></div>
            <div class="menu">
                <div class="informacoes_usuario">
                    <div class="user__data">
                        <img
                            src="<%= user.getAvatar() %>">
                    </div>
                </div>
            </div>
        </nav>
        
        <header class="home__page__header" headerPage>
            <ul>
                <li active id="active">Filmes</li>
                <li active>Series</li>
                <%-- <li class="categoriaBtn">Categorias <i class="fa-solid fa-arrow-down" style="margin-left: 5px;"></i>
                </li> --%>
            </ul>
            <form name="formularioPesquisa" method="POST" action="search-page.jsp" id="row">
                <select name="selectedGenre" class="categoria__list">
                    <option value="Todos" onclick="submitSelectedGenre(value)" selected>Todos</option>
                    <% for(String genre : conexao.getUniqueGenre("mov")){ 
                        if(genre == null){
                            break;
                        }
                    %>
                        <option value="<%= genre %>" onclick="submitSelectedGenre()"><%= genre %></option>
                    <% } %>
                </select>
                <div class="search__bar" searchBarContainer>
                    <div style='display: flex'>
                        <input type="search" placeholder="Busca" name="searchField" onkeyup="makePOSTRequest('<%=url%>')" 
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
            <div style="display: flex; align-items: flex-start;" class="user__info__container">
                <img class="avatar__user__img" src="<%= user.getAvatar() %>">
                <p class="user__container__info"><%=user.getNome()%></p>
            </div>
        </header>

        <!-- Filmes -->
        <section class="secao-filmes active" id="detaqueMovie" secaoFilme>
            <div class="filmes__destaque">
                <h3>Destaque</h3>
                <div id="row" style="justify-content: space-around; align-items: center;">
                    <i class="fa-solid fa-chevron-left" id="img-scroll-left-f"></i>
                    <% for(Filme item : allMovies){ %>

                    <% if(Integer.parseInt(item.getDataLancamento().split("-")[0]) == dataAtual.getYear() 
                        &&
                        Integer.parseInt(item.getDataLancamento().split("-")[1]) == dataAtual.getMonthValue()) { %>
                    <div class="img__card__big" imgRowF>
                        <img
                            src="<%= item.getCover() %>">
                        <div class="txt_box">
                            <p class="name"><%= item.getNome() %></p>
                            <p class="year"><%= item.getDataLancamento() %></p>
                        </div>
                        <div class="botao__assistir">
                            <i class="fa-solid fa-play"></i>
                            <p>Assistir</p>
                        </div>
                    </div>
                    <div class="info-movie-row" infoMovF>
                        <div id="row" style="align-items: center;">
                            <p class="name_mov"><%= item.getNome() %></p>
                            <div class="small-line"></div>
                            <p class="year_mov"><%= item.getFaixaEtaria() %></p>
                        </div>
                        <div style="color: #fff;">
                            <p class="genre_mov">Genero</p>
                            <p class="genres_mov"><%= item.gerarStringDoGenero() %></p>
                        </div>
                        <!-- <div style="display: flex;">
                            <img src="" style="
                                width: 180px;
                                height: 100px;
                                object-fit: cover;
                            ">
                        </div> -->
                    </div>
                    <% } 
                    }
                    %>
                    <i class="fa-solid fa-chevron-right" id="img-scroll-right-f"></i>
                </div>
            </div>

            <div class="filmes__destaque">
                <% for(String genre : conexao.getUniqueGenre("mov")){ %>
                    <h3 style="margin-top: 6.5vh;"><%= genre %></h3>
                    <div id="row" style="justify-content: flex-start; align-items: center;">
                        <% for(Filme filme : pesquisa.searchMovieByGenre(genre, allMovies)){ %>    
                                <div class="img__card__medium" style="margin-left: 10px;">
                                    <a href="http://localhost:8080/projeto_faculdade/src/page/DetailPage.jsp?idM=<%= filme.getId() %>&nomeM=<%= filme.getNome() %>"><img src="<%= filme.getCover() %>"></a>
                                    <div class="txt_box">
                                        <p class="name"><%= filme.getNome() %></p>
                                        <p class="year"><%= filme.getDataLancamento().split("-")[0] %></p>
                                    </div>
                                </div>
                        <% } %>
                    </div>
                <% } %>
            </div>
        </section>
           

        <!-- Séries -->
        <section class="secao-filmes" secaoFilme>
            <div class="filmes__destaque">
                <h3>Destaque</h3>
                <div id="row" style="justify-content: space-around; align-items: center;">
                    <i class="fa-solid fa-chevron-left" id="img-scroll-left-s"></i>
                    <% for(Serie sItem: allSeries) { %>
                    <div class="img__card__big" imgRowS>
                        <img src="<%= sItem.getCover() %>">
                        <div class="txt_box">
                            <p class="name"><%= sItem.getNome() %></p>
                            <p class="year"><%= sItem.getDataLancamento() %></p>
                        </div>
                        <div class="botao__assistir">
                            <i class="fa-solid fa-play"></i>
                            <p>Assistir</p>
                        </div>
                    </div>
                    <div class="info-movie-row" infoMovS>
                        <div id="row" style="align-items: center;">
                            <p class="name_mov"><%= sItem.getNome() %></p>
                            <div class="small-line"></div>
                            <p class="year_mov"><%= sItem.getFaixaEtaria() %></p>
                        </div>
                        <div style="color: #fff;">
                            <p class="genre_mov">Genero</p>
                            <p class="genres_mov">Animação</p>
                        </div>
                    </div>
                    <% } %>
                    <i class="fa-solid fa-chevron-right" id="img-scroll-right-s"></i>
                </div>
            </div>
        
            <div class="filmes__destaque">
                <% for(String genre : conexao.getUniqueGenre("ser")){ %>
                    <h3><%= genre %></h3>
                    <div id="row" style="justify-content: flex-start; align-items: center;">
                        <% 
                            for(Serie serie : pesquisa.searchSerieByGenre(genre, allSeries)){ 
                        %>
                            <div class="img__card__medium">
                                <a href="http://localhost:8080/projeto_faculdade/src/page/DetailPage.jsp?idM=<%= serie.getId() %>&nomeM=<%= serie.getNome() %>">
                                    <img src="<%= serie.getCover() %>">
                                </a>
                                <div class="txt_box">
                                    <p class="name"><%= serie.getNome() %></p>
                                    <p class="year"><%= serie.getDataLancamento() %></p>
                                </div>
                            </div>
                        <% } %>
                    </div>
                <% } %>
            </div>
        </section>

        <div id="testeF"></div>

        <!-- <script src="../scripts/sideMenu.js"></script> -->
        <script src="../scripts/homePage.js"></script>
        <script src="../scripts/searchBar.js"></script>
        <script src="../scripts/Ajax.js"></script>
    </body>

    </html>