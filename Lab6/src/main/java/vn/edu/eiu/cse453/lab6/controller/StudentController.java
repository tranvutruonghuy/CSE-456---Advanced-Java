package vn.edu.eiu.cse453.lab6.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.edu.eiu.cse453.lab6.config.InitStudent;
import vn.edu.eiu.cse453.lab6.entity.Student;

import java.util.List;

@Controller
//xử lý và trả kt quả là 1 trang web html.
// Ứng với mỗi url sẽ có một hàm xử lý tương ứng
public class StudentController {
    //Khởi tạo danh sách sinh viên
    private final InitStudent initStudent;

    @Autowired
    public StudentController(InitStudent initStudent) {
        this.initStudent = initStudent;
    }

    //Hiển thị trang index
    @GetMapping("/")
    public String index() {
        return "index"; //index.html, không cần gõ html vì đã khai báo suffix
    }

    //Hiển thị danh sách sinh viên cho url localhost:8080/students
    @GetMapping("/students")
    public String showStudents(Model model) {
        //Hàm được gọi khi user gõ url localhost:8080/students
        //Sau khi xử lý sẽ trả về một trang html
        //Nếu kèm theo data thì bỏ trong obj Model (attributeName, attributeValue)
        //Thymeleaf sẽ lấy data này thông qua attributeName
        //AttributeValue có thể là bất kỳ obj gì
        List<Student> students = initStudent.getStudentList();
        model.addAttribute("students", students);
        return "student-list"; //Chính là file student-list.html
    }

    //Xử lý trang localhost:8080/student/edit/id
    @GetMapping("/students/edit/{id}")
    public String showEditForm(Model model, @PathVariable int id) {
        //Các công việc cần làm:
        //Gửi kèm thông tin của sinh viên cần sửa
        //Trả về trang html có form edit student

        for (Student foundStudent : initStudent.getStudentList()) {
            if (foundStudent.getId() == id) {
                //Gửi thông tin sinh viên cần sửa qua form
                model.addAttribute("foundStudent", foundStudent);
                break;
            }
        }
        return "student-edit-form";
    }


//    //Xử lý cho form edit sinh viên
//    //Phien ban 1: nhớ sửa đường dẫn action của form lại để sử dụng được phiên bản 1
//    //Khi xử lý form
//    //Sau khi xử lý và trả về trong html, nhưng url không thay đổi, vẫn là url của action form => nếu f5 thì sẽ gọi lại hàm xử lý này -> lỗi resumission forrm
//    //Trong trường hợp thêm mới data, với key tự tăng thì sẽ bị duplicate dữ liệu
//    @PostMapping("/students/edit/result")
//    public String saveStudent(@RequestParam int id, @RequestParam String name, @RequestParam int yob, @RequestParam double gpa, Model model){
//        //Lấy thông tin từ form
//        //Hiển thị thông tin đủ lên trang result.html
//        model.addAttribute("pmsg", "Student has been updated");
//        model.addAttribute("pid", id);
//        model.addAttribute("pname", name);
//        model.addAttribute("pyob", yob);
//        model.addAttribute("pgpa", gpa);
//        return "result"; //result.html
//    }


//    //Phiên bản 2 sử dụng redirect để tránh lỗi
//    //Xử lý cho form edit sinh viên
//    @PostMapping("/students/edit")
//    public String saveStudent(@RequestParam int id, @RequestParam String name, @RequestParam int yob, @RequestParam double gpa, RedirectAttributes redireactAtt){
//        //Lấy thông tin từ form
//        //Hiển thị thông tin đủ lên trang result.html
//        redireactAtt.addFlashAttribute("pmsg", "Student has been updated");
//        redireactAtt.addFlashAttribute("pid", id);
//        redireactAtt.addFlashAttribute("pname", name);
//        redireactAtt.addFlashAttribute("pyob", yob);
//        redireactAtt.addFlashAttribute("pgpa", gpa);
//        //Có flash để bảo mật thông tin (như kiểu gửi trong box)
//        return "redirect:/students/edit/result";
//        //chuyển hướng url thành localhost:8080/student/edit/result, không phải là trang result.html. Nên phải có hàm xử lý cho url này
//        //Tại sao chỗ này không cần Model? Model sẽ được gửi kèm theo trong html cho thmeleaf dùng để mix. Mà ở đây không hề gửi trang html nào hết
//    }
//
//    @GetMapping("/students/edit/result")
//    public String showResult(Model model) {
//        return "result"; //ở đây mới là trang result.html
//        //Sẽ bị lỗi null vì không nhận được data từ model của bên @PostMapping saveStudent
//        //Xử lý bằng cách khi redirect bên saveStudent, gửi kèm thêm gói hàng RedirectAttribute. Nghĩa là trong hàm này có 2 loại dữ liệu:
//        // 1. Model chính của nó
//        // 2. RedirectAttribute được gửi kèm theo từ bên saveStudent
//
//    }


//    //Phieen bản 3: lấy thông in đã sửa redirect sang trang Student-list
//    //Thực tế là: sau khi edit xong thì lưu db -> cp nhật lên students -> quay lại trang students
//    //Hiện tại chỉ làm: lấy thông tin cập nhật hiển thị lên trang students
//    @PostMapping("/students/edit")
//    public String saveStudent(@RequestParam("id") int id, @RequestParam("name") String name, @RequestParam("yob") int yob, @RequestParam("gpa") double gpa, RedirectAttributes redireactAtt){
//        //Lấy thông tin từ form
//        //Hiển thị thông tin đủ lên trang result.html
//        redireactAtt.addFlashAttribute("pmsg", "Student has been updated");
//        redireactAtt.addFlashAttribute("pid", id);
//        redireactAtt.addFlashAttribute("pname", name);
//        redireactAtt.addFlashAttribute("pyob", yob);
//        redireactAtt.addFlashAttribute("pgpa", gpa);
//        //Có flash để bảo mật thông tin (như kiểu gửi trong box)
//        return "redirect:/students";
//    }



    //Phiên bản 4: làm bình thường sau khi edit redirect về trang student list
    @PostMapping("/students/edit")
    public String saveStudent(@RequestParam("id") int id, @RequestParam("name") String name, @RequestParam("yob") int yob, @RequestParam("gpa") double gpa){
        //Lấy thông tin từ form, cập nhật cho student rồi redirect về students
        for(Student student : initStudent.getStudentList()){
            if(student.getId() == id){
                student.setId(id);
                student.setName(name);
                student.setYob(yob);
                student.setGpa(gpa);
                break;
            }
        }
        return "redirect:/students";
    }



    //Add student
    @GetMapping("/students/new")
    public String showAddForm() {
        return "student-add-form";
    }

    @PostMapping("/students/new")
    public String addStudent(@RequestParam int id ,@RequestParam String name, @RequestParam int yob, @RequestParam double gpa) {
        Student student = new Student(id, name, yob, gpa);
        initStudent.getStudentList().add(student);
        return "redirect:/students";
    }




    //Delete
    @GetMapping("/students/delete/{id}")
    public String deleteStudent(@PathVariable int id) {
        for(Student student : initStudent.getStudentList()){
            if(student.getId() == id){
                initStudent.getStudentList().remove(student);
                break;
            }
        }
        return "redirect:/students";
    }


}
