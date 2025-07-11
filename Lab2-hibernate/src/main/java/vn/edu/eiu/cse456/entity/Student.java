package vn.edu.eiu.cse456.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "Students") //Nếu muốn đặt tên bảng khác với tên class
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @Id // đánh dấu cột khóa chính
    @Column(name = "Id", columnDefinition = "CHAR(10)")
    private String id;

    @Column(name = "Name", columnDefinition = "NVARCHAR(50)", nullable = false)
    private String name;

    @Column(name = "Year of Birth", nullable = false)
    // Do trong db có int tương ứng nên khỏi cần columnDefi
    private int yob;

    @Column(name="Gpa")
    private double gpa;
}
