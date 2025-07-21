package vn.edu.eiu.cse456.service;

import vn.edu.eiu.cse456.entity.Major;
import vn.edu.eiu.cse456.repository.Implementation.MajorRepository;

public class MajorService {
    private MajorRepository majorRepository;
    public MajorService(MajorRepository majorRepository) {
        this.majorRepository = majorRepository;
    }

    public void createMajor(Major major) {
        this.majorRepository.save(major);
    }

    public void updateMajor(Major major) {
        this.majorRepository.update(major);
    }
    public void deleteMajor(Major major) {
        this.majorRepository.remove(major);
    }
}
