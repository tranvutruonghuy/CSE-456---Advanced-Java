package vn.edu.eiu.cse456.repo;

import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Component;
import vn.edu.eiu.cse456.entity.Invoice;
import vn.edu.eiu.cse456.infra.JpaUtil;

import java.util.ArrayList;
import java.util.List;

@Component
public class InvoiceRepo implements IGenericRepo<Invoice>{
    @Override
    public void createEntity(Invoice entity) {
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void deleteEntity(int id) {
        EntityManager em = JpaUtil.getEntityManager();
        Invoice entity = em.find(Invoice.class, id);
        if (entity == null) {
            System.out.println("Can not find Invoice with id = " + id);
            return;
        }
        em.getTransaction().begin();
        em.remove(entity);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void updateEntity(Invoice newEntity) {
        EntityManager em = JpaUtil.getEntityManager();

        Invoice entity = em.find(Invoice.class, newEntity.getId());
        if (entity == null) {
            System.out.println("Can not find Invoice with id = " + newEntity.getId());
            return;
        }
        entity.setCustomer(newEntity.getCustomer());
        entity.setProducts(new ArrayList<>(newEntity.getProducts()));


        em.getTransaction().begin();
        em.merge(entity);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public Invoice findEntity(int id) {
        EntityManager em = JpaUtil.getEntityManager();
        Invoice entity = em.find(Invoice.class, id);
        if (entity == null) {
            System.out.println("Can not find Invoice with id = " + id);
            return null;
        }
        em.close();
        return entity;
    }

    @Override
    public List<Invoice> findAllEntities() {
        EntityManager em = JpaUtil.getEntityManager();
        List<Invoice> list = em.createQuery("SELECT c FROM tbl_invoice c", Invoice.class).getResultList();
        em.close();
        return list;
    }
}
