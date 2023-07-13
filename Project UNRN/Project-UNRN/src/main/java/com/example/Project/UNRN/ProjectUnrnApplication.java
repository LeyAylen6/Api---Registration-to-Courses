package com.example.Project.UNRN;

import com.example.Project.UNRN.domain.Course;
import com.example.Project.UNRN.domain.Status;
import com.example.Project.UNRN.domain.Student;
import com.example.Project.UNRN.repository.CourseRepository;
import com.example.Project.UNRN.repository.InscriptionRepository;
import com.example.Project.UNRN.repository.StudentRepository;
import com.example.Project.UNRN.service.InscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.time.LocalDate;
import java.util.Arrays;

@SpringBootApplication
public class ProjectUnrnApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProjectUnrnApplication.class, args);
    }

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    InscriptionRepository inscriptionRepository;

    @Autowired
    InscriptionService inscriptionService;

    private void addCourses() {
        courseRepository.saveAll(Arrays.asList(
                new Course(null, "Course 1", "Description1", LocalDate.of(2022, 1, 25), LocalDate.of(2022, 5, 25)),
                new Course(null, "Course 2", "Description2", LocalDate.of(2023, 6, 10), LocalDate.of(2023, 9, 10)),
                new Course(null, "Course 3", "Description3", LocalDate.of(2021, 2, 5), LocalDate.of(2021, 8, 5)),
                new Course(null, "Course 4", "Description4", LocalDate.of(2022, 4, 28), LocalDate.of(2022, 6, 25))
        ));
    }

    private void addStudents() {
        studentRepository.saveAll(Arrays.asList(
                new Student(null, "Leila", "Salguero", "leiisalguero@gmail.com", 12345678L, LocalDate.of(2000, 4, 25), 23),
                new Student(null, "Ignacio", "Gimenez", "email@gmail.com", 12345679L, LocalDate.of(2000, 1, 7), 23),
                new Student(null, "Ignacio2", "Gimenez2", "email2@gmail.com", 12345675L, LocalDate.of(2000, 1, 7), 23),
                new Student(null, "Leila2", "Salguero2", "leiisalguero2@gmail.com", 12345672L, LocalDate.of(2000, 4, 25), 23)
        ));
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {
            System.out.println("Hello World!");

            addCourses();
            addStudents();

            //	● Listar todos los cursos
            courseRepository.findAll();

            //	● Listar todos los cursos que hayan empezado después de “01/02/2020”
//            courseRepository.findBystartDateIsGreaterThan(LocalDate.of(2020, 2, 1));

            // ● Listar todas las inscripciones rechazadas o pendiente
//            inscriptionRepository.findByStatusRejectedOrPending(); // QUERY
            inscriptionRepository.findByStatusIsRejectedOrPending(); // DERIVADA

            // ● Listar todas las inscripciones según un parámetro de estado
//            inscriptionRepository.findInscriptionByCourseId(1);

            //	● Listar todas las inscripciones en base a un parámetro de estado utilizando consulta nativa
            inscriptionRepository.findByInscriptionStatus(Status.pending); // QUERY
            inscriptionRepository.findByStatus(Status.pending);     // DERIVADA

            // ------------------------------------------------------------------------------------------------ //

            // ● Listar todos los estudiantes
//            studentRepository.findAllStudents();  // QUERY
            studentRepository.findAll(); // DERIVADA

            //	● Listar todos los estudiantes que tengan un dni mayor a 20M y que su apellido sea “Romero”
//            studentRepository.getStudentByDniAndLastname(); // QUERY
            studentRepository.findByDniAndLastname(20000001L, "Romero"); // DERIVADA

            //	● Listar todos los estudiantes de forma paginada y ordenada ascendente por DNI
            //  ○ página 1, tamaño 5
            studentRepository.findAll(PageRequest.of(1, 5, Sort.by(Sort.Direction.ASC, "dni")));

            //  ○ pagina 0, tamaño 2
            studentRepository.findAll(PageRequest.of(0, 2, Sort.by(Sort.Direction.ASC, "dni")));

//            inscriptionService.createInscription(1L, 1L);
//

            //	En base a las operaciones definidas en el módulo 3 implementar los siguientes endpoints:


            // ➔ Creación de un curso
            // ➔ Creación de una inscripción
            // Nota: para realizar las pruebas sobre los endpoints creados usar Swagger
        };
    }
}
