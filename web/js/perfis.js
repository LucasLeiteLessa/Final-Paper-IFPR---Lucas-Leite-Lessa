
let options = [
    backdrop = true,
    keyboard = true,
    focus = true
]

function mostrarModal(){
    var myModalEl = document.getElementById('modal');
    var myModal = new bootstrap.Modal(myModalEl, options)
    myModal.show()
}


function carregarPerfil() {
    var xhttp = new XMLHttpRequest();
       xhttp.onreadystatechange = function () {
        if (this.readyState == 4) {
            try {
                let perfil = JSON.parse(this.responseText);
                document.getElementById('nome').innerHTML = ''+perfil.nome+'</strong>';
                document.getElementById('biografia').innerHTML = '<p class="me-2 ms-2">'+perfil.biografia+'</p>';
                document.getElementById('perfil').src = 'ExibirArquivo?id=' + perfil.foto_de_perfil.id;
                document.getElementById('idLike').value = perfil.idUsuario;
                document.getElementById('escolaridade').innerHTML = '<strong>Escolaridade: </strong>' + perfil.idEscolaridade.descricao + ', ' + perfil.instituicao;
                
                var interesses = document.getElementById('interesses');
                interesses.innerHTML = "";
                for (var i = 0; i < perfil.interesses.length; i++) {
                    interesses.innerHTML += `<div class="badge bginteresse text-wrap text-dark me-2 mb-3" style="width: 6rem;">
                    <p class="my-auto">${perfil.interesses[i].descricao}</p></div>`;
                }
            } catch (error) {
                document.getElementById('content').innerHTML = '<div class="mt-5  my-auto"><h5>Não temos perfis disponíveis para você no momento :( </h5></div>';
                document.getElementById('content').innerHTML += '<button class="botaomatch btn mt-5"><a href="Matches">Meus Matches</a></button>';
                document.getElementById('botaoLike').style.display = 'none';
                document.getElementById('botaoDeslike').style.display = 'none';
            }


        }
    }

    xhttp.open("GET", "Perfil");
    xhttp.send();
}




function lick() {
    event.preventDefault();
    var xhttp = new XMLHttpRequest();

    xhttp.onreadystatechange = function () {
        if (this.readyState == 4) {
            let like = this.responseText;
            if (like === "match"){
                let nome = document.getElementById('nome').innerHTML;
                document.getElementById('mensagemModal').innerHTML = `Você e ${nome} podem iniciar os estudos agora mesmo!`;
                mostrarModal();
            }
            carregarPerfil();
        }
    }

    xhttp.open("POST", "Like");
    xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xhttp.send("id=" + document.getElementById('idLike').value);
}

function deslick() {
    event.preventDefault();
    var xhttp = new XMLHttpRequest();

    xhttp.onreadystatechange = function () {
        if (this.readyState == 4) {
            
            carregarPerfil();
        }
    }

    xhttp.open("POST", "Deslike");
    xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xhttp.send("id=" + document.getElementById('idLike').value);
}

