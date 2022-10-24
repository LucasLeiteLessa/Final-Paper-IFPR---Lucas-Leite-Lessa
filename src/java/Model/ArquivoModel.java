
package Model;

import DAO.ArquivoDAO;
import Entities.Arquivo;

public class ArquivoModel {
    
    
    public Arquivo getById(int id){
        ArquivoDAO dao = new ArquivoDAO();
        return dao.get(id);
    }
}
