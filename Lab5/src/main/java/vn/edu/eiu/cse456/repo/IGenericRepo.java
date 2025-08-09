package vn.edu.eiu.cse456.repo;

import java.util.List;

public interface IGenericRepo<T> {
    void createEntity(T entity);
    void deleteEntity(int id);
    void updateEntity(T entity);
    T findEntity(int id);
    List<T> findAllEntities();
}
