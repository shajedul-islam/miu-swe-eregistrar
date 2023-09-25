package com.miu.swe.eregistrar.service;

import com.miu.swe.eregistrar.model.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudents();
    Student getStudentById(Long id);
    void saveStudent(Student student);
    void updateStudent(Student student);
    void deleteStudent(Long id);
    List<Student> searchStudentsByCriteria(String firstName, String lastName);
}
