package vn.edu.eiu.cse456.infra;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

/*
* Lớp này dùng để thực hiện các tác vụ sauL
* 1. Khởi tạo kết nối Db bằng cách độc thông tin tron persistence-unit
* => load nhiều thông tin cấu hình, xóa cấu trúc bảng, tạo lại cấu trúc bảng,... => siêu nặng.
* => Chỉ nên load một lần duy nhất lúc chạm đến lần đầu tiên => dùng kỹ thuật Singleton để làm.
*
* 2. Tạo ra đối tượng quản lý việc tương tác với db (EntityManager)
*/
public class JpaUtil {
    //1.
    private static final EntityManagerFactory emf;

    //Đoạn code static không tên, sẽ được gọi ngay khi lớp JpaUtil được chạm đến
    static {
        try {
            emf = Persistence.createEntityManagerFactory("pu1-student_3layer");
        } catch (Exception e) {
            System.out.println("Can not create entity pu1-student_3layer");
            throw new RuntimeException(e);
        }
    }

    /*
    * Để đoạn code static{} trên chạy được thì cần phải vô hiện hóa tất cả constructor
    * Mặc định trong khai báo constructor thì class sẽ kế thừa constructor rỗng của class object
    * Vì vậy cần dùng:
    */
    private JpaUtil() {} //Vô hiệu hóa constructor kế thừa từ obj

    //2. Tạo ra EntityManager quản lý việc tương tác với DB
    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
}
