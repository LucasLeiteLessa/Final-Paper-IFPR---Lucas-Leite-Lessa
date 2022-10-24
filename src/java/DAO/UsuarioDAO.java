package DAO;

import Entities.Interesse;
import Entities.Usuario;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

public class UsuarioDAO extends BaseDAO<Integer, Usuario> {

    public UsuarioDAO() {
    }

    public Usuario getComFetch(int id) {
        TypedQuery<Usuario> query = em.createQuery("SELECT u FROM Usuario u WHERE u.id = :id", Usuario.class);
        query.setParameter("id", id);
        Usuario u = query.getSingleResult();
        u.getCurtidas().size();
        return u;
    }
    
    public void curtir(int u, int destino){
        em.getTransaction().begin();
        Usuario a = em.find(Usuario.class, u);
        Usuario b = em.find(Usuario.class, destino);
        a.getCurtidas().add(b);
        em.getTransaction().commit();        
    }

    public Usuario buscarPorEmail(String email) {
        TypedQuery<Usuario> query = em.createQuery("SELECT u FROM Usuario u WHERE u.email = :email", Usuario.class);
        query.setParameter("email", email);

        Usuario u = null;
        try {
            u = query.getSingleResult();
        } catch (NoResultException e) {

        }

        return u;
    }

}
