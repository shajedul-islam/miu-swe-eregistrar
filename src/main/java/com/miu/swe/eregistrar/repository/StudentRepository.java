package com.miu.swe.eregistrar.repository;

import com.miu.swe.eregistrar.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findByFirstNameContainingAndLastNameContaining(String firstName, String lastName);

    List<Student> findByFirstNameContaining(String firstName);

    List<Student> findByLastNameContaining(String lastName);

    List<Student> findAll();
}