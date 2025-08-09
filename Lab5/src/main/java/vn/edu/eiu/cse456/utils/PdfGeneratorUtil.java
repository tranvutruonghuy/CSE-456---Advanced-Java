package vn.edu.eiu.cse456.utils;

import org.springframework.stereotype.Component;

@Component
public class PdfGeneratorUtil {
    //Khai báo các thuộc tính cần thiết

    //Hàm xử lý tạo file
    public void generatePdfFile(String fileName, String content){
        //Xử lý tạo file

        //Xuất thông báo
        System.out.println("The file " + fileName + " is generated successfully.");
        System.out.println("The content of the file is:\n" + content);
    }
}
