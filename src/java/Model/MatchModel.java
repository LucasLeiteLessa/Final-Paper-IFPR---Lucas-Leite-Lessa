/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import DAO.MatchDAO;
import Entities.Match;
import Entities.Usuario;

/**
 *
 * @author lucas
 */
public class MatchModel {
    
    
    public void adicionarMatch(Usuario u, Usuario u2){
        Match m = new Match(u, u2);
        MatchDAO dao = new MatchDAO();
        dao.create(m);
    }
}
