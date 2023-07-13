package com.example.Project.UNRN.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class StudentDTO {

    private String name;
    private String lastName;
    private String email;
    private Long dni;
    private LocalDate birthday;
    private Integer age;

}
