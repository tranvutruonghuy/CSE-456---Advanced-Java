package com.example.FinalMockTest.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="tbl_User")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(columnDefinition = "VARCHAR(50)", nullable = false, unique = true)
    @NotNull(message = "Username must not be null")
    private String username;

    @Column(columnDefinition = "VARCHAR(255)", nullable = false)
    @NotNull(message = "Password must not be null")
    private String password;

    @NotNull(message = "Role must not be null")
    private int role;



    public User(String username, String password, int role){
        this.username = username;
        this.password = password;
        this.role = role;
    }
}
