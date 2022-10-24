package Controller;

import DAO.InteresseDAO;
import Entities.Interesse;
import Entities.Usuario;
import Globals.Globals;
import Model.InteresseModel;
import Model.UsuarioModel;
import Util.Retorno;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "PosCadastro", urlPatterns = {"/PosCadastro"})
public class PosCadastro extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        request.setCharacterEncoding("UTF-8");
        HttpSession sessao = request.getSession(true);
        Usuario u = (Usuario) sessao.getAttribute("usuario");
        if (u != null) {
            InteresseModel model = new InteresseModel();
            request.setAttribute("interesses", model.getInteresses());
            request.getRequestDispatcher("poscadastro.jsp").forward(request, response);
        }else{
            
            String error = URLEncoder.encode("Realize seu cadastro primeiro", "ISO-8859-1");
            
            response.sendRedirect("Login?mensagem=" + error);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        request.setCharacterEncoding("UTF-8");
        String curriculo = request.getParameter("curriculo");
        HttpSession sessao = request.getSession(true);
        Usuario u = (Usuario) sessao.getAttribute("usuario");
        UsuarioModel model = new UsuarioModel();
        InteresseModel intModel = new InteresseModel();
        List<Interesse> listaUsuario = new ArrayList<Interesse>();
        Interesse iadicionar;
        String[] interesses = request.getParameterValues("interesse[]");
        if (interesses != null) {
            for (String id : interesses) {
                iadicionar = intModel.getById(Integer.parseInt(id));
               listaUsuario.add(iadicionar);
            }
        }

        Retorno<String, Usuario> retorno = model.posCadastro(u, curriculo, listaUsuario);

        if (retorno.getValor() != null) {
            sessao.setAttribute("usuario", retorno.getValor());
            response.sendRedirect("Perfis");

        } else {
            sessao.setAttribute("usuario", u);
            request.setAttribute("mensagem", retorno.getChave());
            request.setAttribute("interesses", intModel.getInteresses());
            request.getRequestDispatcher("poscadastro.jsp").forward(request, response);

        }
    }
    
   

}
