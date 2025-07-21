package vn.edu.eiu.cse456.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tbl_School")

public class School {
    @Id
    @Column(name = "school_id", columnDefinition = "CHAR(3)")
    private String schoolId;

    @Column(name = "school_name", columnDefinition = "VARCHAR(100)", nullable = false)
    private String schoolName;

    @Column(name = "location", columnDefinition = "VARCHAR(100)", nullable = true)
    private String location;

    @OneToMany(mappedBy = "school", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Major> majors = new ArrayList<>();

    @OneToMany(mappedBy = "school", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Student> students = new ArrayList<>();

    public void addMajor(Major major) {
        this.majors.add(major);
        major.setSchool(this);
    }

    public void removeMajor(Major major) {
        this.majors.remove(major);
        major.setSchool(null);
    }

    public void addStudent(Student student) {
        this.students.add(student);
        student.setSchool(this);
    }

    @Override
    public String toString() {
        return "School{" +
                "schoolId='" + schoolId + '\'' +
                ", schoolName='" + schoolName + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
