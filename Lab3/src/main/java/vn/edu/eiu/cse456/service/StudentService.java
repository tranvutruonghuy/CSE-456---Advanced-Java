package vn.edu.eiu.cse456.service;

import vn.edu.eiu.cse456.entity.Student;
import vn.edu.eiu.cse456.repository.Implementation.StudentRepository;

public class StudentService {
    private StudentRepository studentRepository;
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    public void createStudent(Student std) {
        this.studentRepository.save(std);
    }
    public void updateStudent(Student std) {
        this.studentRepository.update(std);
    }
    public void deleteStudent(Student std) {
        this.studentRepository.remove(std);
    }

}
