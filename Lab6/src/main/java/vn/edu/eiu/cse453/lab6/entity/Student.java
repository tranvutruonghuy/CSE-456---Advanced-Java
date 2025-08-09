package vn.edu.eiu.cse453.lab6.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//Chưa làm entity, table
@AllArgsConstructor
@NoArgsConstructor
@Data
//Nếu table có key tự tăng thì phải thêm 1 constructor ầy đủ tham số, nhưng bỏ tham số key đi
public class Student {
    //Nếu id là key tự thưng thì không có trong constructor full tham số và nên dùng kiểu wrapper class long
    private int id;
    private String name;
    private int yob;
    private double gpa;
}
