package vn.edu.eiu.cse456.service;

import vn.edu.eiu.cse456.entity.School;
import vn.edu.eiu.cse456.repository.Implementation.SchoolRepository;

public class SchoolService {
    private SchoolRepository schoolRepository;
    public SchoolService(SchoolRepository schoolRepository) {
        this.schoolRepository = schoolRepository;
    }
    public void createSchool(School school) {
        this.schoolRepository.save(school);
    }

    public void updateSchool(School school) {
        this.schoolRepository.update(school);
    }
    public void deleteSchool(School school) {
        this.schoolRepository.remove(school);
    }
}
