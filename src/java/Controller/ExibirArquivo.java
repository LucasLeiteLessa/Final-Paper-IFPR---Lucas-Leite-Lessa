
package Controller;

import Entities.Arquivo;
import Globals.Globals;
import Model.ArquivoModel;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "ExibirArquivo", urlPatterns = {"/ExibirArquivo"})
public class ExibirArquivo extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int idArquivo = Integer.parseInt(request.getParameter("id"));
        
        ArquivoModel model = new ArquivoModel();
        
        Arquivo arquivo = model.getById(idArquivo);
        
        byte[] imageData = carregarArquivo(arquivo.getNome());
        
        response.setContentType(arquivo.getContentType());
        
        response.getOutputStream().write(imageData);        
        
    }
    
    private static byte[] carregarArquivo(String name) throws FileNotFoundException, IOException {        
        byte[] image;
        File file = new File(Globals.filePath + name);//Acessando meu arquivo
        image = new byte[(int)file.length()];
        FileInputStream fileInputStream = new FileInputStream(file);
        fileInputStream.read(image);
        fileInputStream.close();
        return image;
    }

}
