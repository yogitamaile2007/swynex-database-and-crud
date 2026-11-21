package com.swynex.crud.repository;

import com.swynex.crud.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Spring Data JPA writes the SQL for us.
 * We get save(), findAll(), findById(), delete() for free.
 */
public interface StudentRepository extends JpaRepository<Student, Long> {

    boolean existsByEmail(String email);

    boolean existsByEmailAndIdNot(String email, Long id);
}
