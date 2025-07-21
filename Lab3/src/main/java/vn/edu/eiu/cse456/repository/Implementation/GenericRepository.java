package vn.edu.eiu.cse456.repository.Implementation;

import jakarta.persistence.EntityManager;
import vn.edu.eiu.cse456.infra.JpaUtil;
import vn.edu.eiu.cse456.repository.Interfaces.IGenericRepository;

import java.util.List;

public class GenericRepository<T> implements IGenericRepository<T> {
    private Class<T> entityClass;

    public GenericRepository(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

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
    public T findById(Object id) {
        EntityManager em = JpaUtil.getEntityManager();
        T result = em.find(entityClass, id);
        em.close();
        return result;
    }

    @Override
    public List<T> findAll() {
        EntityManager em = JpaUtil.getEntityManager();
        List<T> result = em.createQuery("SELECT e FROM " + entityClass.getSimpleName() + " e", entityClass).getResultList();
        em.close();
        return result;
    }


}
