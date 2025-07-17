package vn.edu.eiu.cse456.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "major_id", nullable = false)
    private Major major;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "school_id", nullable = false)
    private School school;

    @Column(name = "enrollment_year", nullable = false)
    private int enrollmentYear;
}
