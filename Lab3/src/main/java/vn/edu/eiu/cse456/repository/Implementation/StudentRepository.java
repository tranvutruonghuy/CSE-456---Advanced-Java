package vn.edu.eiu.cse456.repository.Implementation;

import vn.edu.eiu.cse456.entity.Student;

public class StudentRepository extends GenericRepository<Student> {
    public StudentRepository(Class<Student> entityClass) {
        super(entityClass);
    }
}
