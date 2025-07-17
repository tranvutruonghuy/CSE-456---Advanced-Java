package vn.edu.eiu.cse456;

import vn.edu.eiu.cse456.entity.School;
import vn.edu.eiu.cse456.repository.Implementation.SchoolRepository;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        School school = new School();
        school.setSchoolId("123");
        school.setSchoolName("School 1");

        SchoolRepository  schoolRepository = new SchoolRepository();
        schoolRepository.save(school);

    }
}