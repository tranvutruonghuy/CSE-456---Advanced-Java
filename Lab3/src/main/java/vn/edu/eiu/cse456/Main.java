package vn.edu.eiu.cse456;

import vn.edu.eiu.cse456.entity.Gender;
import vn.edu.eiu.cse456.entity.Major;
import vn.edu.eiu.cse456.entity.School;
import vn.edu.eiu.cse456.entity.Student;
import vn.edu.eiu.cse456.repository.Implementation.MajorRepository;
import vn.edu.eiu.cse456.repository.Implementation.SchoolRepository;
import vn.edu.eiu.cse456.repository.Implementation.StudentRepository;

import java.time.LocalDate;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //Tạo 2 trường
        School school = new School();
        school.setSchoolId("123");
        school.setSchoolName("School 1");
        school.setLocation("HCM");
        School school2 = new School();
        school2.setSchoolId("456");
        school2.setSchoolName("School 2");
        school2.setLocation("Hanoi");

        SchoolRepository  schoolRepository = new SchoolRepository(School.class);
        //Lưu trường học xuống db
        schoolRepository.save(school);
        schoolRepository.save(school2);

        //Sửa thông tin trường
        school.setSchoolName("School 3");
        schoolRepository.update(school);

        //Tìm tất cả trường
        schoolRepository.findAll().forEach(System.out::println);
//        //Xóa trường
//        schoolRepository.remove(school2);

        //Tìm trường theo id
        System.out.println(schoolRepository.findById("456"));

        //Tạo 2 major
        Major major = new Major();
        major.setMajorId("123");
        major.setMajorName("Major 1");
        school.addMajor(major);  // Add major vào school

        Major major2 = new Major();
        major2.setMajorId("456");
        major2.setMajorName("Major 2");
        school2.addMajor(major2);  // Add major vào school

        MajorRepository majorRepository = new MajorRepository(Major.class);
        //Lưu major xuống db
        majorRepository.save(major);
        majorRepository.save(major2);

        //Cập nhật major
        major.setMajorName("Major 3");
        majorRepository.update(major);

        //Tìm tất cả major
        majorRepository.findAll().forEach(System.out::println);

//        school2.removeMajor(major2);

        //Xóa major
//        majorRepository.remove(major2);

        //Tìm major theo id
        System.out.println(majorRepository.findById("456"));


        //Tạo 2 student
        Student std = new Student();
        std.setFullName("Peter");
        std.setGender(Gender.MALE);
        school.addStudent(std); //Add student vào school
        major.addStudent(std); //Add student vào major
        std.setGpa(3.5);
        std.setEnrollmentYear(2020);
        std.setDob(LocalDate.parse("2000-07-19"));

        Student std2 = new Student();
        std2.setFullName("Lona");
        std2.setGender(Gender.FEMALE);
        school2.addStudent(std2); //Add student vào school
        major2.addStudent(std2); //Add student vào major
        std2.setGpa(3.7);
        std2.setEnrollmentYear(2022);
        std2.setDob(LocalDate.parse("2002-07-29"));

        StudentRepository studentRepository = new StudentRepository(Student.class);
        //Lưu student
        studentRepository.save(std);
        studentRepository.save(std2);

        //Cập nhật student
        std.setFullName("David");
        studentRepository.update(std);

        //Tìm tất cả student
        studentRepository.findAll().forEach(System.out::println);

        //Xóa student
//        studentRepository.remove(std);

        //Tìm student by Id
        System.out.println(studentRepository.findById(2));

    }
}