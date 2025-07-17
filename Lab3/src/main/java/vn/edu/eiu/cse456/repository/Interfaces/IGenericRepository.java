package vn.edu.eiu.cse456.repository.Interfaces;

import vn.edu.eiu.cse456.entity.Student;

public interface IGenericRepository<T> {
    void save(T entity);
    void update(T entity);
    void remove(T entity);
    T findById(T entity);
    Iterable<T> findAll();
}
