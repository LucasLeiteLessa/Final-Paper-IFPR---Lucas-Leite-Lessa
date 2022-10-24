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
        <link rel="preconnect" href="https://fonts.gstatic.com">
        <link href="https://fonts.googleapis.com/css2?family=Dosis:wght@200&display=swap" rel="stylesheet">
        <title>Scio - Cadastro</title>
    </head>
    <body style="background-color: #523E7A;" class="backgroundRoxo">
        <div class="container-fluid h-100">
            <div class="row h-100">
                <div class="col-md-4">

                </div>
                <div class="col-md-4  my-auto caixapc text-center" style="background-color: #FFFFFF">
                    <img src="ExibirArquivo?id=${usuario.foto_de_perfil.id}" alt="Imagem perfil" title="Imagem perfil" class="imgPerfil mt-2">
                    <form method="post" action="PosCadastro">

                        <textarea class="mt-3 mb-3" cols="30" rows="4" placeholder="Descreva seu curriculo" name="curriculo"></textarea>
                        </br>
                        <p><strong style="color: #362951">Selecione seus interesses</strong></p>

                        <c:forEach var="interesse" items="${interesses}">
                            <div class="d-inline-block me-2">
                                <input type="checkbox" id="${interesse.id}" name="interesse[]" value="${interesse.id}">
                                <label for="${interesse.id}">${interesse.descricao}</label>
                            </div>

                        </c:forEach>
                        <br>
                        <div class="mt-5">
                            <input class="mt-1" type="submit" value="Finalizar Cadastro">
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
