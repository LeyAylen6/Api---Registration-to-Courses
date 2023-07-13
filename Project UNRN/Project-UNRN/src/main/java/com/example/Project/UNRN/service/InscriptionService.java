package com.example.Project.UNRN.service;

import com.example.Project.UNRN.domain.Course;
import com.example.Project.UNRN.domain.Inscription;
import com.example.Project.UNRN.domain.Status;
import com.example.Project.UNRN.domain.Student;
import com.example.Project.UNRN.dto.InscriptionData;
import com.example.Project.UNRN.repository.CourseRepository;
import com.example.Project.UNRN.repository.InscriptionRepository;
import com.example.Project.UNRN.repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDate;

@Service
@Validated // Se agrega para agregar validaciones como Not null
public class InscriptionService {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private InscriptionRepository inscriptionRepository;

    // ➔ Creación de una inscripción - El estudiante debe ser mayor de edad
    @Transactional
    public String newInscription(InscriptionData inscriptionData) {

        Course courseFound = courseRepository
                .findById(inscriptionData.getCourseId())
                .orElseThrow( () -> new RuntimeException("The course id does not exist"));

        Student studentFound = studentRepository
                .findById(inscriptionData.getStudentId())
                .orElseThrow( () -> new RuntimeException("The student id does not exist"));

//      Optional<Course> courseFound = courseRepository.findById(courseId);
//      Optional<Student> studentFound = studentRepository.findById(studentId);
//      if(courseFound.isEmpty() || studentFound.isEmpty()) throw new RuntimeException("The id does not exist");

        if(!studentFound.isAdult()) throw new RuntimeException("The student cannot be less than 18 years of age.");

        Inscription inscription1 = new Inscription(
                null,
                LocalDate.now(),
                Status.pending,
                courseFound,
                studentFound
        );

        inscriptionRepository.save(inscription1);

        return "Successful registration!";
    }

}
