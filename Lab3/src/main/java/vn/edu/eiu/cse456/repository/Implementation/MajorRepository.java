package vn.edu.eiu.cse456.repository.Implementation;

import vn.edu.eiu.cse456.entity.Major;

public class MajorRepository extends GenericRepository<Major>{
    public MajorRepository(Class<Major> entityClass) {
        super(entityClass);
    }
}
