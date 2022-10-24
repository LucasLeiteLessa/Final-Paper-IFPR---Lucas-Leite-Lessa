<%-- 
    Document   : perfis
    Created on : 31/03/2021, 20:26:43
    Author     : lucas
--%>

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
        <title>Scio - Perfis</title>
    </head>
    <body  style="background-color: #523E7A;" onload="carregarPerfil();" class="backgroundRoxo">
        <div class="container-fluid h-100">
            <div class="row h-100">
                <div class="col-auto col-md-4 col-xl-2  px-0 bgsidebar" id="sidebar">
                    <div class="d-flex flex-column align-items-center align-items-sm-start px-2 pt-2 text-white min-vh-100">
                        <span class="fs-5 d-none d-sm-inline mx-auto"><strong>Menu</strong></span>
                        <ul class="nav nav-pills flex-column mb-sm-auto mb-0 align-items-center align-items-sm-start" id="menu">
                            <li class="nav-item">
                                <a href="Matches" class="nav-link align-middle px-0">
                                    <i class="fs-4 bi-house "></i> <span class="ms-1 d-none  text-white d-sm-inline">Matches</span>
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
                    <div class="modal" tabindex="-1" id ="modal">
                        <div class="modal-dialog modal-dialog-centered">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title mx-auto"><strong>É um match! :)</strong></h5>
                                </div>
                                <div class="modal-body">
                                    <p id="mensagemModal"></p>
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-primary">Iniciar um chat</button>
                                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Continuar navegando</button>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class=" my-auto caixapf text-center mt-4 col-md-5 mx-auto" style="background-color: #FFFFFF" id="content" onload="mostrarModal()">
                        <img src="" alt="Imagem perfil" title="Imagem perfil" class="imgPerfil mt-2" id="perfil">
                        <p><h4 ><strong id="nome"></strong></h4></p>
                        <div>
                            <p id="biografia"></p>
                            <p id="escolaridade"></p>
                            <p id="instituicao"></p>
                        </div>
                        <div class="border border-3 rounded-pill mt-4">
                            <p><h5>Interesses</h5></p>
                            <div id="interesses" >
                            </div>
                        </div>
                        <input type="hidden" id="idLike">
                        <svg  onclick="deslick()" xmlns="http://www.w3.org/2000/svg"  fill="#DB2B2B" class="bi bi-x-lg iconl me-5 mt-3 mb-2" viewBox="0 0 16 16" id="botaoDeslike">
                        <path d="M1.293 1.293a1 1 0 0 1 1.414 0L8 6.586l5.293-5.293a1 1 0 1 1 1.414 1.414L9.414 8l5.293 5.293a1 1 0 0 1-1.414 1.414L8 9.414l-5.293 5.293a1 1 0 0 1-1.414-1.414L6.586 8 1.293 2.707a1 1 0 0 1 0-1.414z"/>
                        </svg>
                        <svg  onclick="lick()" xmlns="http://www.w3.org/2000/svg"  fill="#54db2b" class="bi bi-check-lg iconl mt-3 mb-2" viewBox="0 0 16 16">
                        <path d="M13.485 1.431a1.473 1.473 0 0 1 2.104 2.062l-7.84 9.801a1.473 1.473 0 0 1-2.12.04L.431 8.138a1.473 1.473 0 0 1 2.084-2.083l4.111 4.112 6.82-8.69a.486.486 0 0 1 .04-.045z"/>
                        </svg>
                    </div>

                </div>


            </div>
        </div>
    </div>


</body>
</html>
