package com.example.Project.UNRN.service;

import com.example.Project.UNRN.domain.Course;
import com.example.Project.UNRN.dto.CourseDTO;
import com.example.Project.UNRN.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class CourseService {

    @Autowired
    CourseRepository courseRepository;

    // ➔ Creación de un curso
    public CourseDTO saveCourse(CourseDTO courseDTO) {
        Course course = new Course(
                null,
                courseDTO.getName(),
                courseDTO.getDescription(),
                courseDTO.getStartDate(),
                courseDTO.getEndDate()
        );

        courseRepository.save(course);

        return courseDTO;
    }
}
