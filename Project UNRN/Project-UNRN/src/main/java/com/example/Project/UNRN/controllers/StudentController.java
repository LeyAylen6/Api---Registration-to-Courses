package com.example.Project.UNRN.controllers;

import com.example.Project.UNRN.dto.StudentDTO;
import com.example.Project.UNRN.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    // ➔ Creación de estudiante
    @PostMapping
    public StudentDTO saveStudent(@RequestBody StudentDTO studentDTO) {
        return studentService.saveStudent(studentDTO);
    }

    // ➔ Consulta todos los estudiantes
    @GetMapping
    public List<StudentDTO> findAll() {
        return studentService.findAll();
    }

    // ➔ Consulta de un estudiante en particular por id
    @GetMapping("/{id}")
    public StudentDTO findById(@PathVariable Long id) {
        return studentService.findById(id);
    }

    // ➔ Actualización de un estudiante
    @PutMapping("/{id}")
    public StudentDTO updateStudent(@PathVariable Long id, @RequestBody StudentDTO studentDTO) {
        return studentService.updateStudent(id, studentDTO);
    }

    // ➔ Eliminación de un estudiante
    @DeleteMapping("/{id}")
    public StudentDTO deleteStudent(@PathVariable Long id) {
        return studentService.deleteStudent(id);
    }
}
