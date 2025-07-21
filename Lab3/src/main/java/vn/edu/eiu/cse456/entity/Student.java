package vn.edu.eiu.cse456.entity;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tbl_Student")

public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int studentId;

    @Column(name = "full_name", columnDefinition = "VARCHAR(100)", nullable = false)
    private String fullName;

    @Column(name = "gender", nullable = false)
    private Gender gender;

    @Column(name = "dob", nullable = false)
    private LocalDate dob;

    @Column(name = "gpa")
    private double gpa;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "major_id", nullable = false)
    private Major major;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "school_id", nullable = false)
    private School school;

    @Column(name = "enrollment_year", nullable = false)
    private int enrollmentYear;

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", fullName='" + fullName + '\'' +
                ", gender=" + gender +
                ", dob=" + dob +
                ", gpa=" + gpa +
                ", major=" + major.getMajorName() +
                ", school=" + school.getSchoolName() +
                ", enrollmentYear=" + enrollmentYear +
                '}';
    }
}
