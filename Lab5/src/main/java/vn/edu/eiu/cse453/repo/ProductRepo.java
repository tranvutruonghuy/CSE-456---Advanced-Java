package vn.edu.eiu.cse453.repo;

import jakarta.persistence.EntityManager;
import vn.edu.eiu.cse453.entity.Product;
import vn.edu.eiu.cse453.entity.Product;
import vn.edu.eiu.cse453.infra.JpaUtil;

import java.util.ArrayList;
import java.util.List;

public class ProductRepo implements IGenericRepo<Product>{
    @Override
    public void createEntity(Product entity) {
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void deleteEntity(int id) {
        EntityManager em = JpaUtil.getEntityManager();
        Product entity = em.find(Product.class, id);
        if (entity == null) {
            System.out.println("Can not find Product with id = " + id);
            return;
        }
        em.getTransaction().begin();
        em.remove(entity);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void updateEntity(Product newEntity) {
        EntityManager em = JpaUtil.getEntityManager();

        Product entity = em.find(Product.class, newEntity.getId());
        if (entity == null) {
            System.out.println("Can not find Product with id = " + newEntity.getId());
            return;
        }
        entity.setName(newEntity.getName());
        entity.setPrice(newEntity.getPrice());
        entity.setQuantity(newEntity.getQuantity());
        entity.setDescription(newEntity.getDescription());
        entity.setInvoice(newEntity.getInvoice());


        em.getTransaction().begin();
        em.merge(entity);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public Product findEntity(int id) {
        EntityManager em = JpaUtil.getEntityManager();
        Product entity = em.find(Product.class, id);
        if (entity == null) {
            System.out.println("Can not find Product with id = " + id);
            return null;
        }
        em.close();
        return entity;
    }

    @Override
    public List<Product> findAllEntities() {
        EntityManager em = JpaUtil.getEntityManager();
        List<Product> list = em.createQuery("SELECT c FROM tbl_product c", Product.class).getResultList();
        em.close();
        return list;
    }
}
