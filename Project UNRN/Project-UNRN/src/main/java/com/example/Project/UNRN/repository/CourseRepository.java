package com.example.Project.UNRN.repository;

import com.example.Project.UNRN.domain.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;

@Repository
public interface CourseRepository extends JpaRepository<Course,Long> {

//    @Query("SELECT * FROM Course c WHERE c.startDate > LocalDate.of(2020, 02, 01)")
    ArrayList<Course> findBystartDateIsGreaterThan(LocalDate localDate);
}
