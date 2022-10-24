/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entities.Usuario;
import Model.MatchModel;
import Model.UsuarioModel;
import com.google.gson.Gson;
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
@WebServlet(name = "Like", urlPatterns = {"/Like"})
public class Like extends HttpServlet {

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
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
            
            String curtiu = model.curtir(u.getIdUsuario(), idUsuario);
            
            response.setContentType("text;charset=UTF-8");
            try (PrintWriter out = response.getWriter()) {
                out.print(curtiu);
            }

        }

    }

}
