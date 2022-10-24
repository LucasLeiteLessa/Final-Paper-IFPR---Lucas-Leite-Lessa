/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import DAO.InteresseDAO;
import Entities.Interesse;
import java.util.List;

/**
 *
 * @author lucas
 */
public class InteresseModel {

    public List getInteresses() {
        InteresseDAO dao = new InteresseDAO();
        List lista = dao.findAll();
        return lista;

    }
    
    public Interesse getById(int id){
        InteresseDAO dao = new InteresseDAO();
        return dao.get(id);
    }
}
