package vn.edu.eiu.cse456.repository.Implementation;

import jakarta.persistence.EntityManager;
import vn.edu.eiu.cse456.infra.JpaUtil;
import vn.edu.eiu.cse456.repository.Interfaces.IGenericRepository;

public class GenericRepository implements IGenericRepository {

    @Override
    public void save(Object entity) {
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void update(Object entity) {
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        em.merge(entity);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void remove(Object entity) {
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        em.remove(em.merge(entity));
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public Object findById(Object entity) {
        return null;
    }

    @Override
    public Iterable findAll() {
        return null;
    }


}
