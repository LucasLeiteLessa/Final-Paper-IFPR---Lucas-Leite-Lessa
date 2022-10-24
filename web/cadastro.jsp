<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
        <title>Scio - Cadastro</title>
        <link rel="preconnect" href="https://fonts.gstatic.com">
        <link href="https://fonts.googleapis.com/css2?family=Dosis:wght@200&display=swap" rel="stylesheet">

    </head>
    <body onload="Toasty()">
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
                </div>                <div class="col-md-4">
                    <div class="text-end mt-3 me-2 pentrar">
                        <p>Entrar
                            <a href="Login">
                                <svg xmlns="http://www.w3.org/2000/svg" fill="#523E7A"
                                     class="bi bi-box-arrow-in-right iconcc" viewBox="0 0 16 16">
                                <path fill-rule="evenodd"
                                      d="M6 3.5a.5.5 0 0 1 .5-.5h8a.5.5 0 0 1 .5.5v9a.5.5 0 0 1-.5.5h-8a.5.5 0 0 1-.5-.5v-2a.5.5 0 0 0-1 0v2A1.5 1.5 0 0 0 6.5 14h8a1.5 1.5 0 0 0 1.5-1.5v-9A1.5 1.5 0 0 0 14.5 2h-8A1.5 1.5 0 0 0 5 3.5v2a.5.5 0 0 0 1 0v-2z" />
                                <path fill-rule="evenodd"
                                      d="M11.854 8.354a.5.5 0 0 0 0-.708l-3-3a.5.5 0 1 0-.708.708L10.293 7.5H1.5a.5.5 0 0 0 0 1h8.793l-2.147 2.146a.5.5 0 0 0 .708.708l3-3z" />
                                </svg>
                            </a>
                        </p>


                    </div>
                    <div class="row mt-2 text-center">
                        <label for="imagemperfil"> 

                            <svg xmlns="http://www.w3.org/2000/svg"  fill="#523E7A" class="bi bi-person-bounding-box iconuc mx-auto mt-4 mb-4" viewBox="0 0 16 16" title="Adicionar foto de perfil">
                            <path d="M1.5 1a.5.5 0 0 0-.5.5v3a.5.5 0 0 1-1 0v-3A1.5 1.5 0 0 1 1.5 0h3a.5.5 0 0 1 0 1h-3zM11 .5a.5.5 0 0 1 .5-.5h3A1.5 1.5 0 0 1 16 1.5v3a.5.5 0 0 1-1 0v-3a.5.5 0 0 0-.5-.5h-3a.5.5 0 0 1-.5-.5zM.5 11a.5.5 0 0 1 .5.5v3a.5.5 0 0 0 .5.5h3a.5.5 0 0 1 0 1h-3A1.5 1.5 0 0 1 0 14.5v-3a.5.5 0 0 1 .5-.5zm15 0a.5.5 0 0 1 .5.5v3a1.5 1.5 0 0 1-1.5 1.5h-3a.5.5 0 0 1 0-1h3a.5.5 0 0 0 .5-.5v-3a.5.5 0 0 1 .5-.5z"/>
                            <path d="M3 14s-1 0-1-1 1-4 6-4 6 3 6 4-1 1-1 1H3zm8-9a3 3 0 1 1-6 0 3 3 0 0 1 6 0z"/>
                            </svg>
                            <p>Adicione uma foto de perfil</p>


                    </div>

                    <div class="row">
                        <form class="text-center" method="post" action="Cadastro" enctype="multipart/form-data">
                            <div class="image-upload">  
                                <input type="file" name="imagemperfil" id="imagemperfil" accept="image/png, image/jpeg"/> 
                            </div>
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
                            <svg xmlns="http://www.w3.org/2000/svg" fill="#523E7A" class="bi bi-card-heading iconcc me-4"
                                 viewBox="0 0 16 16">
                            <path
                                d="M14.5 3a.5.5 0 0 1 .5.5v9a.5.5 0 0 1-.5.5h-13a.5.5 0 0 1-.5-.5v-9a.5.5 0 0 1 .5-.5h13zm-13-1A1.5 1.5 0 0 0 0 3.5v9A1.5 1.5 0 0 0 1.5 14h13a1.5 1.5 0 0 0 1.5-1.5v-9A1.5 1.5 0 0 0 14.5 2h-13z" />
                            <path
                                d="M3 8.5a.5.5 0 0 1 .5-.5h9a.5.5 0 0 1 0 1h-9a.5.5 0 0 1-.5-.5zm0 2a.5.5 0 0 1 .5-.5h6a.5.5 0 0 1 0 1h-6a.5.5 0 0 1-.5-.5zm0-5a.5.5 0 0 1 .5-.5h9a.5.5 0 0 1 .5.5v1a.5.5 0 0 1-.5.5h-9a.5.5 0 0 1-.5-.5v-1z" />
                            </svg>
                            <input class="" type="text" placeholder="Nome" name="nome">
                            <br>
                            <svg xmlns="http://www.w3.org/2000/svg" fill="#523E7A" class="bi bi-calendar3 iconcc me-4"
                                 viewBox="0 0 16 16">
                            <path
                                d="M14 0H2a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2zM1 3.857C1 3.384 1.448 3 2 3h12c.552 0 1 .384 1 .857v10.286c0 .473-.448.857-1 .857H2c-.552 0-1-.384-1-.857V3.857z" />
                            <path
                                d="M6.5 7a1 1 0 1 0 0-2 1 1 0 0 0 0 2zm3 0a1 1 0 1 0 0-2 1 1 0 0 0 0 2zm3 0a1 1 0 1 0 0-2 1 1 0 0 0 0 2zm-9 3a1 1 0 1 0 0-2 1 1 0 0 0 0 2zm3 0a1 1 0 1 0 0-2 1 1 0 0 0 0 2zm3 0a1 1 0 1 0 0-2 1 1 0 0 0 0 2zm3 0a1 1 0 1 0 0-2 1 1 0 0 0 0 2zm-9 3a1 1 0 1 0 0-2 1 1 0 0 0 0 2zm3 0a1 1 0 1 0 0-2 1 1 0 0 0 0 2zm3 0a1 1 0 1 0 0-2 1 1 0 0 0 0 2z" />
                            </svg>
                            <input class="" type="text" placeholder="Data nascimento" name="data" onfocus="(this.type = 'date')" >
                            <br>
                            <svg xmlns="http://www.w3.org/2000/svg" fill="#523E7A" class="bi bi-envelope-fill iconcc me-4"
                                 viewBox="0 0 16 16">
                            <path
                                d="M.05 3.555A2 2 0 0 1 2 2h12a2 2 0 0 1 1.95 1.555L8 8.414.05 3.555zM0 4.697v7.104l5.803-3.558L0 4.697zM6.761 8.83l-6.57 4.027A2 2 0 0 0 2 14h12a2 2 0 0 0 1.808-1.144l-6.57-4.027L8 9.586l-1.239-.757zm3.436-.586L16 11.801V4.697l-5.803 3.546z" />
                            </svg>
                            <input class="" type="email" placeholder="E-mail" name="email">
                            <br>
                            <svg xmlns="http://www.w3.org/2000/svg" fill="#523E7A" class="bi bi-building iconcc me-4"
                                 viewBox="0 0 16 16">
                            <path fill-rule="evenodd"
                                  d="M14.763.075A.5.5 0 0 1 15 .5v15a.5.5 0 0 1-.5.5h-3a.5.5 0 0 1-.5-.5V14h-1v1.5a.5.5 0 0 1-.5.5h-9a.5.5 0 0 1-.5-.5V10a.5.5 0 0 1 .342-.474L6 7.64V4.5a.5.5 0 0 1 .276-.447l8-4a.5.5 0 0 1 .487.022zM6 8.694 1 10.36V15h5V8.694zM7 15h2v-1.5a.5.5 0 0 1 .5-.5h2a.5.5 0 0 1 .5.5V15h2V1.309l-7 3.5V15z" />
                            <path
                                d="M2 11h1v1H2v-1zm2 0h1v1H4v-1zm-2 2h1v1H2v-1zm2 0h1v1H4v-1zm4-4h1v1H8V9zm2 0h1v1h-1V9zm-2 2h1v1H8v-1zm2 0h1v1h-1v-1zm2-2h1v1h-1V9zm0 2h1v1h-1v-1zM8 7h1v1H8V7zm2 0h1v1h-1V7zm2 0h1v1h-1V7zM8 5h1v1H8V5zm2 0h1v1h-1V5zm2 0h1v1h-1V5zm0-2h1v1h-1V3z" />
                            </svg>
                            <input type="text" placeholder="Instituição" name="instituicao">
                            <br>
                            <svg xmlns="http://www.w3.org/2000/svg" fill="#523E7A" class="bi bi-book-half iconcc me-4"
                                 viewBox="0 0 16 16">
                            <path
                                d="M8.5 2.687c.654-.689 1.782-.886 3.112-.752 1.234.124 2.503.523 3.388.893v9.923c-.918-.35-2.107-.692-3.287-.81-1.094-.111-2.278-.039-3.213.492V2.687zM8 1.783C7.015.936 5.587.81 4.287.94c-1.514.153-3.042.672-3.994 1.105A.5.5 0 0 0 0 2.5v11a.5.5 0 0 0 .707.455c.882-.4 2.303-.881 3.68-1.02 1.409-.142 2.59.087 3.223.877a.5.5 0 0 0 .78 0c.633-.79 1.814-1.019 3.222-.877 1.378.139 2.8.62 3.681 1.02A.5.5 0 0 0 16 13.5v-11a.5.5 0 0 0-.293-.455c-.952-.433-2.48-.952-3.994-1.105C10.413.809 8.985.936 8 1.783z" />
                            </svg>
                            <select class="" name="id_escolaridade"> 
                                <option value="" selected disabled  disabled="disabled">Escolaridade</option>
                                <c:forEach var="escolaridade" items="${escolaridades}">
                                    <option value="${escolaridade.id}">${escolaridade.descricao}</option>
                                </c:forEach>
                            </select>
                            <br>
                            <svg xmlns="http://www.w3.org/2000/svg" fill="#523E7A" class="bi bi-lock-fill iconcc me-4 pb-2"
                                 viewBox="0 0 16 16">
                            <path
                                d="M8 1a2 2 0 0 1 2 2v4H6V3a2 2 0 0 1 2-2zm3 6V3a3 3 0 0 0-6 0v4a2 2 0 0 0-2 2v5a2 2 0 0 0 2 2h6a2 2 0 0 0 2-2V9a2 2 0 0 0-2-2z" />
                            </svg>
                            <input class="" type="password" placeholder="Senha" name="senha">
                            <br>
                            <svg xmlns="http://www.w3.org/2000/svg" fill="#523E7A" class="bi bi-check iconcc me-4"
                                 viewBox="0 0 16 16">
                            <path
                                d="M10.97 4.97a.75.75 0 0 1 1.07 1.05l-3.99 4.99a.75.75 0 0 1-1.08.02L4.324 8.384a.75.75 0 1 1 1.06-1.06l2.094 2.093 3.473-4.425a.267.267 0 0 1 .02-.022z" />
                            </svg>
                            <input class="mb-5" type="password" placeholder="Confirmação senha" name="confsenha">
                            <br>
                            <input type="submit" value="Cadastrar">
                            <br>
                        </form>

                    </div>
                </div>
            </div>

        </div>
    </body>
</html>
