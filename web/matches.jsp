
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
        <script type="text/javascript" src="js/perfis.js"></script>
        <script type="text/javascript" src="js/script.js"></script>
        <link rel="preconnect" href="https://fonts.gstatic.com">
        <link href="https://fonts.googleapis.com/css2?family=Dosis:wght@200&display=swap" rel="stylesheet">
        <title>Scio - Matches</title>
    </head>
    <body style="background-color: #523E7A;" class="backgroundRoxo">

        <div class="container-fluid h-100">
            <div class="row h-100">
                <div class="col-auto col-md-4 col-xl-2  px-0 bgsidebar" id="sidebar">
                    <div class="d-flex flex-column align-items-center align-items-sm-start px-2 pt-2 text-white min-vh-100">
                        <span class="fs-5 d-none d-sm-inline mx-auto"><strong>Menu</strong></span>
                        <ul class="nav nav-pills flex-column mb-sm-auto mb-0 align-items-center align-items-sm-start" id="menu">
                            <li class="nav-item">
                                <a href="Perfis" class="nav-link align-middle px-0">
                                    <i class="fs-4 bi-house "></i> <span class="ms-1 d-none  text-white d-sm-inline">Perfis</span>
                                </a>
                            </li>
                            <li class="nav-item">
                                <a href="#" class="nav-link align-middle px-0">
                                    <i class="fs-4 bi-house "></i> <span class="ms-1 d-none  text-white d-sm-inline">Perfil</span>
                                </a>
                            </li>


                        </ul>
                        <hr>
                        <div class="dropdown pb-2">
                            <a href="#" class="d-flex align-items-center text-white text-decoration-none dropdown-toggle" id="dropdownUser1" data-bs-toggle="dropdown" aria-expanded="false">
                                <img src="ExibirArquivo?id=${usuario.foto_de_perfil.id}" alt="Foto de perfil" width="25%" height="25%" class="rounded-circle">
                                <span class="d-none d-sm-inline mx-1">${usuario.nome}</span>
                            </a>
                            <ul class="dropdown-menu dropdown-menu-dark text-small shadow">
                                <%-- ver como acaba a sessao --%>
                                <li><a class="dropdown-item" href="Login?sair=true">Sair</a></li>
                            </ul>
                        </div>
                    </div>
                </div>
                <div class="col-md-10">
                    <div class="col-md-11 mx-auto  caixapf my-auto mt-4  overflow-auto" style="background-color: #FFFFFF">
                        <c:forEach var="perfil" items="${matches}">
                            <div class="row mt-4 ms-2">
                            <div class="col-md-2 mb-1"><img src="ExibirArquivo?id=${perfil.foto_de_perfil.id}" alt="ImagemPerfil" title="Imagem" class="imgMatches"></div>
                            <div class="col-md-4 my-auto">

                                <h1>${perfil.nome}</h1>
                                <small>${perfil.biografia}</small>
                            </div>
                            <div class="col-md-5 ms-5 my-auto d-flex justify-content-end">
                                <a href="Perfis" class="d-flex justify-content-end" title="Entrar no chat">
                                    <svg xmlns="http://www.w3.org/2000/svg" fill="currentColor"  class="bi bi-chat-dots-fill iconmatch" viewBox="0 0 16 16">
                                    <path d="M16 8c0 3.866-3.582 7-8 7a9.06 9.06 0 0 1-2.347-.306c-.584.296-1.925.864-4.181 1.234-.2.032-.352-.176-.273-.362.354-.836.674-1.95.77-2.966C.744 11.37 0 9.76 0 8c0-3.866 3.582-7 8-7s8 3.134 8 7zM5 8a1 1 0 1 0-2 0 1 1 0 0 0 2 0zm4 0a1 1 0 1 0-2 0 1 1 0 0 0 2 0zm3 1a1 1 0 1 0 0-2 1 1 0 0 0 0 2z"/>
                                    </svg>
                                </a>

                            </div>
                            <hr class="mt-1"/>
                        </div>
                        </c:forEach>
                        
                    </div>

                </div>


            </div>
        </div>


    </body>
</html>
