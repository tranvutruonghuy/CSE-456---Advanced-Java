package vn.edu.eiu.cse456.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    @OneToMany(mappedBy = "school", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Major> majors = new ArrayList<>();

    @OneToMany(mappedBy = "school", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Student> students = new ArrayList<>();
}
