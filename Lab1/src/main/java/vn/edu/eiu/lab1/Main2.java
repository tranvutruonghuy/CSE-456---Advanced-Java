package vn.edu.eiu.lab1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Main2 {
    public static void main(String[] args) {
        Connection conn = null;
        //Sử dụng các class cung cấp sẵn có trong thư viên JDBC (có trong JAVA SDK)
        //JDBC sẽ tự động kết nối với MySQL JDBC Server (MySQL connector/java)
        try {
            String url = "jdbc:mysql://localhost:3306/cse456_q3_2024";

            //Đối với Java mới thì Driver sẽ được tự động dò tìm trong URL mà ko cần lệnh này.
            //Class.forName("com.mysql.cj.jdbc.Driver");

            conn = DriverManager.getConnection(url, "root", "123456");
            System.out.println("Connected to database successfully");

            //Sau khi kết nối thành công thì tiếp tục thực hiện truy vấn bằng SQL
            //Tạo Class PreparedStatement để thực hiện câu truy vấn.
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM Students");

            ResultSet rs = pstmt.executeQuery(); //Tạo lệnh SQL và lưu danh sách vào rs (List)
            // Truy vấn sử dụng tham số truyền vào mệnh đề where


            // Insert dữ liệu vào bảng nên sử dụng tham số
            String stringSql = "INSERT INTO Students VALUES (?,?,?,?,?)";
            PreparedStatement pstmt1 = conn.prepareStatement(stringSql);
            pstmt1.setString(1, "123456789");
            pstmt1.setString(2, "David");
            pstmt1.setString(3, "Beckham");
            pstmt1.setInt(4, 1995);
            pstmt1.setDouble(5, 3.8);
            pstmt1.executeUpdate();


            // Cập nhật điểm cho David lên 4.0
            String updateSql = "UPDATE Students SET gpa = ? WHERE id = ?";
            PreparedStatement pstmt2 = conn.prepareStatement(updateSql);
            pstmt2.setDouble(1, 4.0);
            pstmt2.setString(2, "123456789");
            pstmt2.executeUpdate();

            //Delete student
            String deleteSql = "DELETE FROM Students WHERE id = ?";
            PreparedStatement pstmt3 = conn.prepareStatement(deleteSql);
            pstmt3.setString(1, "123456789");
            int rowsAffected = pstmt3.executeUpdate();
            System.out.println("Number of rows affected: " + rowsAffected);

//            while (rs.next()) {
//                System.out.print(rs.getString(1));
//                System.out.print(rs.getString(2));
//                System.out.print(rs.getString(3));
//                System.out.print(rs.getString(4));
//                System.out.println(rs.getString(5));
//            }
            System.out.println("List of students in database format: id | first_Name | last_Name | year_of_birth | gpa");
            while (rs.next()) {
                String id = rs.getString("id");
                String firstName = rs.getString("first_Name");
                String lastName = rs.getString("last_Name");
                int yearOfBirth = rs.getInt("year_of_birth");
                double gpa = rs.getInt("gpa");
                System.out.println(id + " | " + firstName + " | " + lastName + " | " + yearOfBirth + " | " + gpa);
//                System.out.printf("|%10s|%-40s|%2d|%4d|%4d|\n", id, firstName, lastName, yearOfBirth, gpa);

            }
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
