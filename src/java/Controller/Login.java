package Controller;

import Entities.Usuario;
import Model.UsuarioModel;
import Util.Retorno;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class Login extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String sair = request.getParameter("sair");
        if (sair != null) {
            if (sair.equals("true")) {
                System.out.println("entro no if");
                HttpSession sessao = request.getSession();
                sessao.setAttribute("usuario", null);
                sessao.invalidate();
            }
        }

        request.getRequestDispatcher("login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");

        UsuarioModel model = new UsuarioModel();

        Retorno retorno = model.entrar(email, senha);
        HttpSession sessao = request.getSession(true);

        if (retorno.getChave() == null) {
            response.sendRedirect("Login?mensagem=" + retorno.getValor());
        } else {

            sessao.setAttribute("usuario", retorno.getChave());
            response.sendRedirect("Perfis");
        }
    }

}
