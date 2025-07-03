package vn.edu.eiu.lab1;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import vn.edu.eiu.lab1.entity.Course;
import vn.edu.eiu.lab1.entity.Student;

public class Main {
    public static void main(String[] args) {
        //Generate some students
        Student student1 = new Student("123456789", "John", "Doe", 1999, 3.8);
        Student student2 = new Student("123456798", "Peter", "Parker", 2000, 2.8);

        //Generate some courses
        Course course1 = new Course("123456789", "Java Programming", 3, 3.5);
        Course course2 = new Course();
        course2.setIdCourse("123456789");
        course2.setName("C Programming");
        course2.setCredits(2);
        course2.setHour(60);

        System.out.println("---List of students---");
        System.out.println("Student 1: " + student1.toString());
        System.out.println("Student 2: " + student2.toString());

        System.out.println();

        System.out.println("---List of courses---");
        System.out.println("Course 1: " + course1.toString());
        System.out.println("Course 2: " + course2.toString());

        System.out.println();

        ObjectMapper mapper = new ObjectMapper();
        String stu1JsonString = null;
        String stu2JsonString = null;
        try {
            stu1JsonString = mapper.writeValueAsString(student1);
            stu2JsonString = mapper.writeValueAsString(student2);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        System.out.println("---List of students as JSON---");
        System.out.println("Student 1 as JSON: " + stu1JsonString);
        System.out.println("Student 2 as JSON: " + stu2JsonString);

        System.out.println();

        String course1JsonString = null;
        String course2JsonString = null;
        try {
            course1JsonString = mapper.writeValueAsString(course1);
            course2JsonString = mapper.writeValueAsString(course2);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        System.out.println("---List of courses as JSON---");
        System.out.println("Course 1 as JSON: " + course1JsonString);
        System.out.println("Course 2 as JSON: " + course2JsonString);

    }
}