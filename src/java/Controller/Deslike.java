/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entities.Usuario;
import Model.UsuarioModel;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author lucas
 */
@WebServlet(name = "Deslike", urlPatterns = {"/Deslike"})
public class Deslike extends HttpServlet {
    
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession sessao = request.getSession(true);
        Usuario u = (Usuario) sessao.getAttribute("usuario");
        if (u == null) {
            request.getRequestDispatcher("login.jsp").forward(request, response);
        } else {
            int idUsuario = Integer.parseInt(request.getParameter("id"));
            UsuarioModel model = new UsuarioModel();
            Usuario perfil = model.getByID(idUsuario);
            List<Usuario> descurtidas = u.getDescurtirdas();
            descurtidas.add(perfil);
            u.setCurtidas(descurtidas);
            model.atualizar(u);

            response.setContentType("text;charset=UTF-8");
            try (PrintWriter out = response.getWriter()) {
                out.println("Você descurtiu o cara ai");
            }
        }

    }
}
