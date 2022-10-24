package Controller;

import Entities.Arquivo;
import Entities.Usuario;
import Globals.Globals;
import Model.EscolaridadeModel;
import Model.UsuarioModel;
import Util.Retorno;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.util.UUID;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

@WebServlet(name = "Cadastro", urlPatterns = {"/Cadastro"})
@MultipartConfig
public class Cadastro extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        EscolaridadeModel model = new EscolaridadeModel();
        request.setAttribute("escolaridades", model.getEscolaridades());
        request.getRequestDispatcher("cadastro.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        String nome = request.getParameter("nome");
        String data = request.getParameter("data");
        String email = request.getParameter("email");
        String institucao = request.getParameter("instituicao");
        String senha = request.getParameter("senha");
        String confsenha = request.getParameter("confsenha");
        String idEscolaridade = request.getParameter("id_escolaridade");

        if (idEscolaridade == null) {
            idEscolaridade = "0";
        }
        Retorno<Arquivo, Path> retorno = this.CriarArquivo(request);
        Arquivo fotoperfil = retorno.getChave();
        UsuarioModel model = new UsuarioModel();
        Retorno<String, Usuario> r = model.adicionarUsuario(nome, data, email, institucao, senha, confsenha, idEscolaridade, fotoperfil);

        if (r.getValor() != null) {
            adicionar(request, retorno.getValor());
            HttpSession sessao = request.getSession(true);
            sessao.setAttribute("usuario", r.getValor());
            response.sendRedirect("PosCadastro");
        } else {
            response.sendRedirect("Cadastro?mensagem=" + r.getChave());
        }

    }

    private Retorno<Arquivo, Path> CriarArquivo(HttpServletRequest request)
            throws IOException, ServletException {

        Part filePart;
        filePart = request.getPart("imagemperfil");

        String folder = Globals.filePath;
        //String nome = filePart.getSubmittedFileName();
        String nome = UUID.randomUUID().toString();
        String tipo = filePart.getContentType().split("/")[1];
        Path path = Paths.get(folder.concat("/" + nome + "." + tipo));
        nome = "/" + nome + "." + tipo;
        
        
        Arquivo img = new Arquivo();
        if (filePart.getSize() == 0){
            img = null;
        }else{
            img.setNome(nome);
            img.setContentType(filePart.getContentType());
        }
        
       
        

        return new Retorno<Arquivo, Path>(img, path);
    }

    private void adicionar(HttpServletRequest request, Path path) 
            throws IOException, ServletException {
        
        Part filePart;
        filePart = request.getPart("imagemperfil");
        Files.copy(filePart.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);

    }

}
