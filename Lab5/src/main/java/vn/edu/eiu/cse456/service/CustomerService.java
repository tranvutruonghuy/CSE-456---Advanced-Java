package vn.edu.eiu.cse456.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.eiu.cse456.entity.Customer;
import vn.edu.eiu.cse456.repo.CustomerRepo;
import vn.edu.eiu.cse456.repo.IGenericRepo;

import java.util.List;

@Service
public class CustomerService {
    private IGenericRepo repo;

    @Autowired
    public CustomerService(CustomerRepo repo) {
        this.repo = repo;
    }

    public void createCustomer(Customer entity) {
        repo.createEntity(entity);
    }
    public void updateCustomer(Customer entity) {
        repo.updateEntity(entity);
    }

    public void deleteCustomer(int id) {
        repo.deleteEntity(id);
    }
    public Customer findCustomerById(int id){
        return (Customer) repo.findEntity(id);
    }

    public List<Customer> findAllCustomers(){
        return repo.findAllEntities();
    }
}
