package vn.edu.eiu.cse456.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "Subjects") //Nếu muốn đặt tên bảng khác với tên class
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Subject {
    @Id
    @Column(name = "Code", columnDefinition = "CHAR(10)")
    private String code;

    @Column(name = "Name", columnDefinition = "NVARCHAR(50)", nullable = false)
    private String name;

    @Column(name = "Description", columnDefinition = "NVARCHAR(255)")
    private String description;

    @Column(name = "Credits", nullable = false)
    private int credits;

    @Column(name = "StudyHours", nullable = false)
    private int studyHours;
}
