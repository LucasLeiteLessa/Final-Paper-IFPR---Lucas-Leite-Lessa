package DAO;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class BaseDAO<Pk, Entity> {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("ScioBD");
    EntityManager em;

    public BaseDAO() {
        this.em = emf.createEntityManager();
    }

    public void create(Entity e) {
        em.getTransaction().begin();
        em.persist(e);
        em.getTransaction().commit();
        em.close();
    }

    public Entity flushcreate(Entity e) {
        em.getTransaction().begin();
        em.persist(e);
        em.flush();
        em.getTransaction().commit();
        em.close();
        return e;
    }

    public Entity get(Pk pk) {
        Entity entity = (Entity) em.find(getTypeClass(), pk);
        em.close();

        return entity;
    }

    public void update(Entity e) {
        em.getTransaction().begin();
        em.merge(e);
        em.getTransaction().commit();

        em.close();
    }

    public Entity flushupdate(Entity e) {
        em.getTransaction().begin();
        em.merge(e);
        em.flush();
        em.getTransaction().commit();

        em.close();

        return e;

    }

    public List<Entity> findAll() {
        return em.createQuery("FROM " + getTypeClass().getName()).getResultList();
    }

    public void remove(Pk pk) {
        Entity cadastrada = (Entity) em.find(getTypeClass(), pk);
        em.getTransaction().begin();
        em.remove(cadastrada);
        em.getTransaction().commit();
        em.close();

    }

    private Class<?> getTypeClass() {
        Class<?> clazz = (Class<?>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
        return clazz;
    }

}
