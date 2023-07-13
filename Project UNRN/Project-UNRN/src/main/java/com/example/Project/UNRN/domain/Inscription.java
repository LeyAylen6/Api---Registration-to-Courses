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
@Table(name = "inscription")
public class Inscription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "inscriptionDate") // Aca agregar : nullable = false, length = 150, scale = 2
    private LocalDate inscriptionDate;

    @Enumerated(value = EnumType.STRING)
    private Status status;

    // Muchas inscripciones para un único curso
    @ManyToOne(fetch = FetchType.EAGER)  // Hace un includes siempre si pongo EAGER. LAZY Solo lo trae si lo pido. Por default es EAGER
    @JoinColumn(name= "course_id")
    private Course course;

    // Muchas estudiantes para una inscripción
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name= "student_id")
    private Student student;
}
