<%-- 
    Document   : DetailPage
    Created on : Mar 20, 2022, 11:55:39 AM
    Author     : rapha
--%>

<%@page import="models.Usuarios"%>
<%@page import="JDBC.ConnectionFactory" %> 
<%@page import="java.util.ArrayList" %>
<%@page import="models.Filme" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>

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

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="../styles/style.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css">
        <title>JSP Page</title>
    </head>
    <body>

        <% 
            int idMovie = Integer.parseInt(request.getParameter("idM"));
            String nome = request.getParameter("nomeM");
            
            ArrayList<Filme> allMovies = new ArrayList<>();
            
            ArrayList<Filme> filme = conexao.getMoviesDataBase("SELECT * FROM filmes WHERE id = " + idMovie + " && nome = '" + nome + "'");
            ArrayList<Filme> series = conexao.getMoviesDataBase("SELECT * FROM series WHERE id = " + idMovie + " && nome = '" + nome + "'");
            
            if(filme.size() > 0){
                allMovies = filme;
            } else if (series.size() > 0) {
                allMovies = series;
            }
            
        %>

        <p id="userName" class="displayNone"><%= user.getNome() %></p>
        <p id="userPassword" class="displayNone"><%= user.getPassword() %></p>
        <p id="idMov" class="displayNone"><%= allMovies.get(0).getId() %></p>
         
        <header class="home__page__header" headerPage>
            <ul>
                <a href="home-page.jsp" style="text-decoration: none;"><li>Voltar</li></a>
            </ul>
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
        </header>

        <section style="padding: 10vh">

            <div id="row" style="justify-content: flex-start; align-items: flex-start;"> 
                <div class="img__card__medium" style="margin-left: 10px;">
                    <img src="<%= allMovies.get(0).getCover() %>" class="size-90p">
                </div>
                <div class="txt_box" style="margin-left: 80px;">
                    <h1 style="color: white;"><%= allMovies.get(0).getNome() %></h1>
                    <div style="max-width: 400px;">
                        <h3 style="color: white;">Sinopse</h3>
                        <p style="color: #9F9F9F; line-height: 23px;"><%= allMovies.get(0).getSinopse() %></p>
                    </div>
                </div>
            </div>

            <div>
                <h3 style="color: white; font-weight: 100;">Genero</h3>
                <p style="color: #9F9F9F;"> <%= allMovies.get(0).gerarStringDoGenero() %></p>
            </div>

            <div style="position: relative; display: grid;" btnDesc>
                <div style="
                    display: flex; 
                    justify-content: space-between; 
                    color: white; 
                    background-color: rgba(225, 225, 225, 0.25); 
                    padding: 5px; 
                    align-items: center;
                    border-radius: 10px;"
                >
                    <h2>Descrição</h2>
                    <div style="position: absolute; right: 10px; font-size: 25px;" id="arrowBtn">
                        <i class='fa-solid fa-chevron-up'></i>
                    </div>
                </div>
                <p style="color: #9F9F9F; text-transform: capitalize; line-height: 23px;" class="hide" id="descText"><%= allMovies.get(0).getDescricao() %></p>
                <%@include file="./components/comentarios-component.jsp" %>
            </div>

            <div>
                <section id="row__vStart" style="margin-top: 2.5vh;">
                    <img src="<%= user.getAvatar() %>" class="avatar__user__img">
                    <div class="coments__bar bg_grey full_width" style="margin-left: 1.5vh; align-items: flex-start;">
                        <h1 class="color_grey none__marginTop">Comentário</h1>

                        <textarea 
                            type="text" 
                            class="transparent_bg color_grey full_width" 
                            placeholder="Adicione um comentário"
                            id="txtComent"
                        ></textarea>

                    </div>
                </section>
                
                <div id="relative" class="full_width">
                    <button 
                        class="end_button transparent_bg color_grey" 
                        style="padding: 5px;" 
                        id="btnAddComent"
                        onclick="addComentPOST()"
                    >Adicionar</button>
                </div>

            </div>

            <section comentsContainerList></section>
            
        </section>
            
        
        <script src="../scripts/searchBar.js"></script>
        <script src="../scripts/Ajax.js"></script>
        <script src="../scripts/show-hide-desc.js"></script>
        <script src="../scripts/getCommentsHttp.js"></script>
    </body>
</html>
