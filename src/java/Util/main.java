/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import DAO.EscolaridadeDAO;
import Entities.Escolaridade;

/**
 *
 * @author lucas
 */
public class main {
    public static void main(String[] args) {
        Escolaridade e = new Escolaridade();
        EscolaridadeDAO dao = new EscolaridadeDAO();
        e.setDescricao("vai ser teste");
        dao.create(e);
    }
}
