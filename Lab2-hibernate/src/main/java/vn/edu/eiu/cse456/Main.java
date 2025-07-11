package vn.edu.eiu.cse456;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import vn.edu.eiu.cse456.entity.Student;

import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

public class Main {
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu1-mysql-masterapp");
    public static void main(String[] args) {
        //gọi hàm thêm sinh viên
//        insertStudent();
//        getStudentById();
//        getAllStudents();
//        updateGpaById();
//        getStudentsByGpa();
//        getStudentByConditions("le", 9.1);
        removeStudentById("CSE2025002");
    }

    // Định nghĩa các hàm CRUD
    // Xóa 1 sinh viên (DML)
    public static void removeStudentById(String id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Student std = em.find(Student.class, id);
        em.remove(std);
        em.getTransaction().commit();
        System.out.println("Student " + id + " has been removed");
        em.close();
    }

    // Cập nhật điểm dựa trên Id (DML: phải có transaction)
    public static void updateGpaById() {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        // Tìm sinh viên có Id muốn cập nhật
        Student std = em.find(Student.class, "CSE2025001");
        std.setGpa(9.5); // Cập nhật cho bạn
        em.getTransaction().commit();
        System.out.println("Student " + std.getId() + "'s GPA has been updated");
        em.close();
    }

    // Cập nhật năm sinh dựa trên Id (DML: phải có transaction)

    //Tìm kiếm sinh viên theo nhiều điều kiện được truyền vào (sinh viên có tên là pName, có điểm tb là pGpa)
    public static void getStudentByConditions(String Name, double Gpa) {
        EntityManager em = emf.createEntityManager();

        //tham số trong cu truy vấn có tên theo cú pháp :ten-tham-so
        List<Student> stdList = em.createQuery("SELECT s FROM Student s where s.name like :pName and s.gpa > : pGpa")
                .setParameter("pName", "%" + Name + "%").setParameter("pGpa", Gpa).getResultList();
        stdList.forEach( student -> System.out.println(student));
    }

    //Hàm tìm sinh viên dựa trên điều kiện Gpa > x
    public static void getStudentsByGpa(){
        EntityManager em = emf.createEntityManager();
        List<Student> stdList = em.createQuery("SELECT s FROM Student s where s.gpa > 8").getResultList();
        System.out.println(stdList.size() + " students found");
        stdList.forEach(System.out::println);
        em.close();
    }

    //Hàm thực thi câu lệnh tìm một sinh viên thông qua mã sinh viên
    public static void getStudentById(){
        EntityManager em = emf.createEntityManager();
        Student std = em.find(Student.class, "CSE2025001");
        System.out.println("Student found: " + std.toString());
        em.close();
    }

    public static void getAllStudents(){
        EntityManager em = emf.createEntityManager();

        /*
        * Khi viết truy vấn select thì có thể dùng các loại cú pháp sql sau:
        * SSl thuần
        * HQL: được chỉnh sửa bởi hibernate
        * JPQL: được chỉnh sửa bởi JPA lệnh truy vấn theo kiểu OOP
        */
        List<Student> stdList = em.createQuery("SELECT s FROM Student s", Student.class).getResultList();

        System.out.println("The list of all students: ");
        for(Student std : stdList){
            System.out.println(std.toString());
        }
        em.close();
    }

    //Định nghĩa các hàm CRUD
    public static void insertStudent(){
        //1. Tạo người quản lý việc tương tác db
        EntityManager em = emf.createEntityManager();

        //2. Chuẩn bị data để insert
        Student std1 = new Student("CSE2025001", "Lan Le", 2000, 0.5);
        Student std2 = new Student("CSE2025002", "Ly Le", 2001, 0.6);
        Student std3 = new Student("CSE2025003", "Loi Le", 2002, 0.7);

        //3. Người quản lí thực hiện việc insert
        /*
        *Khi thực thi các câu lệnh sql dạng DML (Data Manipulation Language: có làm thay đổi dữ liệu
        * thì bắt buộc phải đặt trong 1 transaction để ảm bảo tính ACID: Atomy Consistency Isolation Durability:
        * Một là thực thi câu lệnh từ đầu đến cuối,
        * còn ngược lại thì không làm gì cả, rollback
        */
        em.getTransaction().begin();
        em.persist(std1); // Ghi xuống db nhưng chưa thực hiện ghi
        em.persist(std2);
        em.persist(std3);
        em.getTransaction().commit(); // Đã ghi xuống db nếu không thành công thì hủy (rollback)
        em.close(); //Cho anh quản lý nghỉ việc
    }
}