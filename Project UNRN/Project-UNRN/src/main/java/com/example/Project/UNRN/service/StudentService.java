package com.example.Project.UNRN.service;

import com.example.Project.UNRN.domain.Student;
import com.example.Project.UNRN.dto.StudentDTO;
import com.example.Project.UNRN.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    // ➔ Creación de estudiante
    public StudentDTO saveStudent(StudentDTO studentDTO) {
        Student student = new Student(
                null,
                studentDTO.getName(),
                studentDTO.getLastName(),
                studentDTO.getEmail(),
                studentDTO.getDni(),
                studentDTO.getBirthday(),
                studentDTO.getAge()
        );

        studentRepository.save(student);

        return studentDTO;
    }

    // ➔ Consulta todos los estudiantes
    public List<StudentDTO> findAll() {
        return studentRepository.findAll()
                .stream().map(student -> new StudentDTO (
                        student.getName(),
                        student.getLastName(),
                        student.getEmail(),
                        student.getDni(),
                        student.getBirthday(),
                        student.getAge())

                ).collect(Collectors.toList());
    }

    // ➔ Consulta de un estudiante en particular por id
    public StudentDTO findById(Long id) {
        Student student = studentRepository
                .findById(id)
                .orElseThrow( () -> new RuntimeException("The student id does not exist"));

        return new StudentDTO(
                student.getName(),
                student.getLastName(),
                student.getEmail(),
                student.getDni(),
                student.getBirthday(),
                student.getAge()
        );
    }

    // ➔ Actualización de un estudiante
    public StudentDTO updateStudent(Long id, StudentDTO studentDTO) {

        Student student = studentRepository
                .findById(id)
                .orElseThrow( () -> new RuntimeException("The student id does not exist"));

        if (!studentDTO.getName().isEmpty()) student.setName(studentDTO.getName());
        if (!studentDTO.getLastName().isEmpty()) student.setLastName(studentDTO.getLastName());
        if (!studentDTO.getEmail().isEmpty()) student.setEmail(studentDTO.getEmail());
        if (studentDTO.getDni() != 0) student.setDni(studentDTO.getDni());
        if (studentDTO.getBirthday().isAfter(LocalDate.of(1900,1,1))) student.setBirthday(studentDTO.getBirthday());
        if (studentDTO.getAge() != 0) student.setAge(studentDTO.getAge());

        return studentDTO;
    }

    // ➔ Eliminación de un estudiante
    public StudentDTO deleteStudent(Long id) {

        StudentDTO studentDTO = findById(id);

        studentRepository.deleteById(id);

        return studentDTO;
    }
}
