package Model;

import DAO.EscolaridadeDAO;
import java.util.List;

public class EscolaridadeModel {

    public List getEscolaridades() {
        EscolaridadeDAO dao = new EscolaridadeDAO();
        List lista = dao.findAll();
        return lista;

    }

}
