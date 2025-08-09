package vn.edu.eiu.cse456.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.eiu.cse456.entity.Product;
import vn.edu.eiu.cse456.repo.IGenericRepo;
import vn.edu.eiu.cse456.repo.ProductRepo;

import java.util.List;

@Service
public class ProductSerivce {
    private IGenericRepo repo;

    @Autowired
    public ProductSerivce(ProductRepo repo) {
        this.repo = repo;
    }
    public void createProduct(Product entity) {
        repo.createEntity(entity);
    }
    public void updateProduct(Product entity) {
        repo.updateEntity(entity);
    }

    public void deleteProduct(int id) {
        repo.deleteEntity(id);
    }
    public Product findProductById(int id){
        return (Product) repo.findEntity(id);
    }

    public List<Product> findAllProducts(){
        return repo.findAllEntities();
    }
}
