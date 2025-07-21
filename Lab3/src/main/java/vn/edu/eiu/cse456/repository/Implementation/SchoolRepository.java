package vn.edu.eiu.cse456.repository.Implementation;

import vn.edu.eiu.cse456.entity.School;

public class SchoolRepository extends GenericRepository<School> {
    public SchoolRepository(Class<School> entityClass) {
        super(entityClass);
    }
}
