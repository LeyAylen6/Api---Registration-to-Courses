package com.example.Project.UNRN.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@Table(name = "Student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "dni")
    private Long dni;

    @Column(name = "birthday")
    private LocalDate birthday;

    @Transient
    private Integer age;

//    public Integer Age() {
//        return LocalDate.now().getYear() - this.birthday.getYear();
//    }

    public Boolean isAdult() {
        return age >= 18;
    }
}
