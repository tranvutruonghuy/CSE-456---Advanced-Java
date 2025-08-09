package vn.edu.eiu.cse453.lab6.config;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import vn.edu.eiu.cse453.lab6.entity.Student;

import java.util.ArrayList;
import java.util.List;
@Component //Giao cho spring quản lý
public class InitStudent {
    private List<Student> studentList;

    //hàm khởi to danh saách :hard-code
    @PostConstruct //tự chạy hàm khi khởi tạo obj initStudent
    public void initStudent(){
        studentList = new ArrayList<>();

        studentList.add(new Student(1,"A",1999,3.8));
        studentList.add(new Student(2,"B",1998,3.7));
        studentList.add(new Student(3,"C",1997,3.6));
        studentList.add(new Student(4,"D",1996,3.5));
        studentList.add(new Student(5,"E",1995,3.4));
        System.out.println("Init student successfully");
    }

    public List<Student> getStudentList() {
        return studentList;
    }
}
