package vn.edu.eiu.cse453.repo;


import jakarta.persistence.EntityManager;
import vn.edu.eiu.cse453.entity.Customer;
import vn.edu.eiu.cse453.infra.JpaUtil;

import java.util.ArrayList;
import java.util.List;

public class CustomerRepo implements IGenericRepo<Customer>{
    @Override
    public void createEntity(Customer entity) {
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void deleteEntity(int id) {
        EntityManager em = JpaUtil.getEntityManager();
        Customer entity = em.find(Customer.class, id);
        if (entity == null) {
            System.out.println("Can not find customer with id = " + id);
            return;
        }
        em.getTransaction().begin();
        em.remove(entity);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void updateEntity(Customer newEntity) {
        EntityManager em = JpaUtil.getEntityManager();

        Customer entity = em.find(Customer.class, newEntity.getId());
        if (entity == null) {
            System.out.println("Can not find customer with id = " + newEntity.getId());
            return;
        }
        entity.setName(newEntity.getName());
        entity.setEmail(newEntity.getEmail());
        entity.setInvoices(new ArrayList<>(newEntity.getInvoices()));

        em.getTransaction().begin();
        em.merge(entity);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public Customer findEntity(int id) {
        EntityManager em = JpaUtil.getEntityManager();
        Customer entity = em.find(Customer.class, id);
        if (entity == null) {
            System.out.println("Can not find customer with id = " + id);
            return null;
        }
        em.close();
        return entity;
    }

    @Override
    public List<Customer> findAllEntities() {
        EntityManager em = JpaUtil.getEntityManager();
        List<Customer> list = em.createQuery("SELECT c FROM tbl_customer c", Customer.class).getResultList();
        em.close();
        return list;
    }
}
