package com.swynex.crud.service;

import com.swynex.crud.exception.DuplicateEmailException;
import com.swynex.crud.exception.ResourceNotFoundException;
import com.swynex.crud.model.Student;
import com.swynex.crud.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Business logic lives here. The controller calls this class.
 */
@Service
public class StudentService {

    private final StudentRepository repository;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    // CREATE
    public Student create(Student student) {
        if (repository.existsByEmail(student.getEmail())) {
            throw new DuplicateEmailException("Email already exists: " + student.getEmail());
        }
        student.setId(null); // always a NEW row
        return repository.save(student);
    }

    // READ (all)
    public List<Student> getAll() {
        return repository.findAll();
    }

    // READ (one)
    public Student getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found with id: " + id));
    }

    // UPDATE
    public Student update(Long id, Student newData) {
        Student existing = getById(id);

        if (repository.existsByEmailAndIdNot(newData.getEmail(), id)) {
            throw new DuplicateEmailException("Email already exists: " + newData.getEmail());
        }

        existing.setName(newData.getName());
        existing.setEmail(newData.getEmail());
        existing.setCourse(newData.getCourse());
        existing.setAge(newData.getAge());
        return repository.save(existing);
    }

    // DELETE
    public void delete(Long id) {
        Student existing = getById(id);
        repository.delete(existing);
    }
}
