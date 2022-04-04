<%-- 
    Document   : login-page
    Created on : 03/03/2022, 20:14:10
    Author     : rapha
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="pt-br">
    <% 
        Cookie[] cookies = request.getCookies();

        /* if(cookies != null){
            response.sendRedirect("home-page.jsp");
        } */
    %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="../styles/style.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css">
        <title>Login</title>
    </head>
    <body>
        <section id="center__page">
        <div id="form-container">
            <div class="boas__vindas">
                <img src="../assets/movie.png" class="boas__vindas__img">
                <h2 class="boas__vindas__txt">Olá, Tudo bem?</h2>
                <form id="form" name="formularioLogin" method="post" action="home-page.jsp">
                    <div id="center__horizontal">
                        <label class="form__container__label">Usuário</label>
                        <div class="form__container" fieldForm>
                            <input type="text" name="usuario" placeholder="Nome ou email" autocomplete="off">
                        </div>
                        <span error></span>
                        <label class="form__container__label">Senha</label>
                        <div class="form__container" fieldForm>
                            <input type="password" name="password" placeholder="Senha" autocomplete="off">
                            <span id="passBtn" onclick="changeTypeInputPassword()"><i class="fa-solid fa-lock"></i></span>
                        </div>
                        <span error></span>
                        <div class="btn-container">
                            <div id="center__horizontal" style="margin-right: 10px;">
                                <button class="form__button">
                                    <p>Login</p>
                                </button>
                            </div>
                            <p style="text-align: center; margin-top: 6vh;" class="cad__text">Não é cadastrado? 
                                <a href="./Cadastro.jsp">Cadastra-se!</a></p>
                        </div>
                        <span style="margin-top: 10px" errorRequest><span>
                    </div>
                </form>
            </div>
        </div>
    </section>
    <script src="../scripts/login.js"></script>
    </body>
</html>
