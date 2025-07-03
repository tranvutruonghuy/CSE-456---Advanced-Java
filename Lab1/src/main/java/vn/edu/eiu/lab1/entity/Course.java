package vn.edu.eiu.lab1.entity;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

public class Course {
    private String idCourse;
    private String name;
    private int credits;
    private double hour;


}
