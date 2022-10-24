
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js" integrity="sha384-b5kHyXgcpbZJO/tY9Ul7kGkf1S0CWuKcCD38l8YkeH8z8QjE0GmW1gYU5S9FOnJ0" crossorigin="anonymous"></script>
        <link rel="stylesheet" type="text/css" href="css/css.css">
        <link rel="shortcut icon" href="images/logo.png" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <script src="js/jquery-3.6.0.min.js"></script>
        <script src="js/script.js"></script>
        <title>Scio - Login</title>
        <link rel="preconnect" href="https://fonts.gstatic.com">
        <link href="https://fonts.googleapis.com/css2?family=Dosis:wght@200&display=swap" rel="stylesheet">

    </head>
    <body onload="Toasty()" style="background-color: #f2f2f2 ">


        <div class="container-fluid h-100">
            <div class="row h-100">
                <div class="col-md-8 backgroundRoxo">
                    <div class="row  mx-auto mt-5 mt-center">
                        <!-- ver como que colocar a imagem menor de maneira responsiva-->
                        <img src="images/logo.png" alt="logo" class="mx-auto w-20">
                    </div> <!-- Para imagem-->
                    <div class="row w-75 text-center mt-5 mx-auto ">
                        <p class="textoinicial">
                            <strong>Olá!</strong> O <big>Scio</big> é o local perfeito para você encontrar colegas que tenham os mesmos interesses acadêmicos que você. Dê <strong>likes</strong>, converse pelo chat e monte seu <strong>grupo de estudos</strong> virtual e/ou presencial. Bons estudos pra você!
                        </p>
                    </div>
                </div>
                <div class="col-md-4 my-auto">
                    <div class="row mt-3 ">
                        <svg xmlns="http://www.w3.org/2000/svg" fill="#523E7A" class="bi bi-person-fill iconu mx-auto"
                             viewBox="0 0 16 16">
                        <path d="M3 14s-1 0-1-1 1-4 6-4 6 3 6 4-1 1-1 1H3zm5-6a3 3 0 1 0 0-6 3 3 0 0 0 0 6z" />
                        </svg>
                    </div>
                    <div class="row mt-4">
                        <form class="text-center" method="post" action="Login">
                            <c:if test="${param.mensagem != null}">
                                <div class="position-fixed bottom-0 end-0 p-3" style="z-index: 5">
                                    <div id="EpicToast" class="toast hide text-white bg-purple border-0" role="alert" aria-live="assertive" aria-atomic="true">
                                        <div class="toast-header">
                                            <img src="images/logo.png" class="rounded me-2" alt="..." width="10%" height="10%">
                                            <strong class="me-auto">Ocorreu um erro! :( </strong>
                                            <small>Scio</small>
                                            <button type="button" class="btn-close" data-bs-dismiss="toast" aria-label="Close"></button>
                                        </div>
                                        <div class="toast-body">
                                            ${param.mensagem}
                                        </div>
                                    </div>
                                </div>
                            </c:if> 
                            <svg xmlns="http://www.w3.org/2000/svg" fill="#523E7A" class="bi bi-envelope-fill iconc me-4"
                                 viewBox="0 0 16 16">
                            <path
                                d="M.05 3.555A2 2 0 0 1 2 2h12a2 2 0 0 1 1.95 1.555L8 8.414.05 3.555zM0 4.697v7.104l5.803-3.558L0 4.697zM6.761 8.83l-6.57 4.027A2 2 0 0 0 2 14h12a2 2 0 0 0 1.808-1.144l-6.57-4.027L8 9.586l-1.239-.757zm3.436-.586L16 11.801V4.697l-5.803 3.546z" />
                            </svg>
                            <input class="mx-auto mb-4" type="email" placeholder="E-mail" name="email">
                            <br>
                            <svg xmlns="http://www.w3.org/2000/svg" fill="#523E7A" class="bi bi-lock-fill iconc me-4 pb-2"
                                 viewBox="0 0 16 16">
                            <path
                                d="M8 1a2 2 0 0 1 2 2v4H6V3a2 2 0 0 1 2-2zm3 6V3a3 3 0 0 0-6 0v4a2 2 0 0 0-2 2v5a2 2 0 0 0 2 2h6a2 2 0 0 0 2-2V9a2 2 0 0 0-2-2z" />
                            </svg>
                            <input class="mx-auto mt-4" type="password" placeholder="Senha" name="senha">
                            <br>
                            <input class="mt-4 mb-4" type="submit" value="Entrar" name="entrar">
                            <br>
                            <p>Não possui conta? <a class="" href="Cadastro">Cadastre-se</a></p>

                        </form>

                    </div>
                </div>
            </div>

    </body>
</html>
