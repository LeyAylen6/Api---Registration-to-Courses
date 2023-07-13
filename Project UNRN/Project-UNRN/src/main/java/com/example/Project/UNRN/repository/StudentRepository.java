package com.example.Project.UNRN.repository;

import com.example.Project.UNRN.domain.Student;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;
import java.util.List;

public interface StudentRepository extends JpaRepository<Student,Long> {

    //	● Listar todos los estudiantes
//    @Query("SELECT * FROM Student")
//    List<Student> findAllStudents(); // QUERY

    List<Student> findAll(); // DERIVADA

    //	● Listar todos los estudiantes que tengan un dni mayor a 20M y que su apellido sea “Romero”
//    @Query("SELECT * FROM Student s WHERE s.dni > 20000000 AND s.lastName = Romero") // QUERY
//    List<Student> getStudentByDniAndLastname();

    List<Student> findByDniAndLastname(Long dni, String lastname); // DERIVADA
}
