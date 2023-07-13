package com.example.Project.UNRN.repository;

import com.example.Project.UNRN.domain.Inscription;
import com.example.Project.UNRN.domain.Status;
import jakarta.persistence.NamedNativeQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface InscriptionRepository extends JpaRepository<Inscription,Long> {

    // ● Listar todas las inscripciones rechazadas o pendiente

    // QUERY
//    @Query("SELECT * FROM Inscription i WHERE i.status = 'rejected' OR i.status = 'pending'")
//    ArrayList<Inscription> findByStatusRejectedOrPending();

    // DERIVADA
    ArrayList<Inscription> findByStatusIsRejectedOrPending();


    // ● Listar todas las inscripciones en base a un parámetro de estado
    // QUERY
//    @Query("SELECT * FROM Inscription i INNER JOIN Course c ON :i.course_id = c.id ")
//    ArrayList<Inscription> findInscriptionByCourseId(@Param("i.course_id") int courseId);

    //	● Listar todas las inscripciones en base a un parámetro de estado utilizando consulta nativa

    // QUERY NATIVA --> Si es nativa se usa el nombre de la tabla (name=inscription)
//    @Query(value = "SELECT * FROM inscription i WHERE i.status = :status", nativeQuery = true)
    ArrayList<Inscription> findByInscriptionStatus(@Param("status") Status status);

    // DERIVADA
    ArrayList<Inscription> findByStatus(@Param("status") Status status);

}
