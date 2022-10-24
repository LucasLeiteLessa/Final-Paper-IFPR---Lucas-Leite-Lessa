/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entities.Usuario;
import Model.UsuarioModel;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "Perfil", urlPatterns = {"/Perfil"})
public class Perfil extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession sessao = request.getSession(true);
        Usuario u = (Usuario) sessao.getAttribute("usuario");

        if (u == null) {
            request.getRequestDispatcher("login.jsp").forward(request, response);
        } else {
            UsuarioModel model = new UsuarioModel();
            List<Usuario> perfis = model.getPerfis(u);

            if (perfis.isEmpty()) {
                response.setContentType("text;charset=UTF-8");
                try (PrintWriter out = response.getWriter()) {
                    out.println("Vazio");
                }
            } else {
                Usuario perfil = perfis.get(0);

                perfil.setCurtidas(new ArrayList<Usuario>());
                perfil.setDescurtirdas(new ArrayList<Usuario>());
                perfil.setSenha("");

                String json = new Gson().toJson(perfil);

                response.setContentType("text/json;charset=UTF-8");
                try (PrintWriter out = response.getWriter()) {
                    out.println(json);
                }
            }
        }

    }

}
