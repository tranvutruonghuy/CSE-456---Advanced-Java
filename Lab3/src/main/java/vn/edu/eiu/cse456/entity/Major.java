package vn.edu.eiu.cse456.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tbl_Major")
public class Major {
    @Id
    @Column(name = "major_id", columnDefinition = "CHAR(4)")
    private String majorId;

    @Column(name = "major_name", columnDefinition = "VARCHAR(100)", nullable = false)
    private String majorName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "school_id", nullable = false)
    private School school;

    @OneToMany(mappedBy = "major", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private java.util.List<Student> students = new java.util.ArrayList<>();
}
