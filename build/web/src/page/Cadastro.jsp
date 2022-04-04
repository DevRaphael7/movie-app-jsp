<!DOCTYPE html>
<html lang="pt-BR">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="../styles/style.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css">
        <title>Cadastro</title>
    </head>
    <body>
        <section id="center__page">
            <div id="form-container" style="height: 700px;">
            <div class="boas__vindas">
                <img src="../assets/popcorn.png" class="boas__vindas__img">
                <h2 class="boas__vindas__txt">Cadastra-se é de graça!</h2>
                <form id="form" name="formularioCad" method="post" action="#">
                    <div id="center__horizontal">
                        <label class="form__container__label">Nome do usuário</label>
                        <div class="form__container" fieldForm>
                            <input type="text" name="usuario" placeholder="Digite seu apelido" autocomplete="off">
                        </div>
                        <span error></span>
                        <label class="form__container__label">E-mail</label>
                        <div class="form__container" fieldForm>
                            <input type="text" name="email" placeholder="Digite seu email" autocomplete="off">
                        </div>
                        <span error></span>
                        <label class="form__container__label">Senha</label>
                        <div class="form__container" fieldForm>
                            <input type="password" name="password" placeholder="Senha" autocomplete="off">
                            <span id="passBtn" onclick="changeTypeInputPassword()"><i class="fa-solid fa-lock"></i></span>
                        </div>
                        <span error></span>
                        <label class="form__container__label">Confirmar senha</label>
                        <div class="form__container" fieldForm>
                            <input type="password" name="conf_password" placeholder="Senha" autocomplete="off">
                            <span id="passBtn" onclick="changeTypeInputPassword()"><i class="fa-solid fa-lock"></i></span>
                        </div>
                        <span error></span>
                        <div class="btn-container bottom-3">
                            <div id="center__horizontal" style="margin-right: 10px;">
                                <button class="form__button">
                                    <p>Finalizar</p>
                                </button>
                            </div>
                            <p style="text-align: center; margin-top: 6vh;" class="cad__text">J� � cadastrado? <a href="login-page.jsp" target="_parent">Clique aqui!</a></p>
                        </div>
                        <span style="margin-top: 10px" errorRequest><span>
                    </div>
                </form>
            </div>
        </div>
    </section>
        <script src="../scripts/AJax-cadastro.js"></script>
    </body>
</html>