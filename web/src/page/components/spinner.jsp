<%-- 
    Document   : spinner
    Created on : May 2, 2022, 7:29:57 PM
    Author     : rapha
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>
<html>
    <head>
        <title>Modelo base de todo html</title>

        <meta charset="utf-8">
        <meta name="pagina teste" content="pagina em branco">
        <meta name="keywords" content="uma pagina em branco">
        <style>
       

@keyframes configure-xclockwise {
  0% {
    transform: rotate(45deg);
  }
  25% {
    transform: rotate(-45deg);
  }
  50% {
    transform: rotate(-135deg);
  }
  75% {
    transform: rotate(-225deg);
  }
  100% {
    transform: rotate(-315deg);
  }
}

@keyframes pulse {
  from {
    opacity: 1;
    transform: scale(1);
  }
  to {
    opacity: .25;
    transform: scale(.75);
  }
}
            .configure-border-2 {
  width: 45px;
  height: 45px;
  padding: 3px;
  left: -115px;
  display: flex;
  justify-content: center;
  align-items: center;
  background: rgb(20, 20, 20);
  transform: rotate(45deg);
  animation: configure-xclockwise 3s ease-in-out 0s infinite alternate;
}

.configure-core {
  width: 100%;
  height: 100%;
  background-color: #193b61;
}

.spinner-box{
    display: none;
}

.spinner-box.show{
    display: block;
}
        </style>
    </head>
    <body>
        <div class="spinner-box" id="loading">
            <div>
            <div class="configure-border-1">
              <div class="configure-core"></div>
            </div>
            <div class="configure-border-2">
              <div class="configure-core"></div>
            </div> 
          </div>
        <h1>Loading...</h1>
        </div>
    </body>
</html>
