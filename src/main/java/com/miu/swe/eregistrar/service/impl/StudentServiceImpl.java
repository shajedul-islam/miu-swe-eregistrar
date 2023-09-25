package com.miu.swe.eregistrar.service.impl;

import com.miu.swe.eregistrar.model.Student;
import com.miu.swe.eregistrar.repository.StudentRepository;
import com.miu.swe.eregistrar.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    @Override
    public void saveStudent(Student student) {
        studentRepository.save(student);
    }

    @Override
    public void updateStudent(Student student) {
        studentRepository.save(student);
    }

    @Override
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public List<Student> searchStudentsByCriteria(String firstName, String lastName) {
        // You can build your search criteria dynamically here.
        // For example, you can use the "Containing" keyword to perform a partial match.

        if (firstName != null && lastName != null) {
            // Search by both first name and last name
            return studentRepository.findByFirstNameContainingAndLastNameContaining(firstName, lastName);
        } else if (firstName != null) {
            // Search by first name only
            return studentRepository.findByFirstNameContaining(firstName);
        } else if (lastName != null) {
            // Search by last name only
            return studentRepository.findByLastNameContaining(lastName);
        } else {
            // If neither first name nor last name is provided, return all students
            return studentRepository.findAll();
        }
    }
}