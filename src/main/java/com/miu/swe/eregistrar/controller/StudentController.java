package com.miu.swe.eregistrar.controller;

import com.miu.swe.eregistrar.model.Student;
import com.miu.swe.eregistrar.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/eregistrar")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @GetMapping("/students")
    public String listStudents(Model model) {
        List<Student> students = studentService.getAllStudents();
        model.addAttribute("students", students);
        return "student/list";
    }

    @GetMapping("/students/register")
    public String showStudentForm(Model model) {
        model.addAttribute("student", new Student());
        return "student/register";
    }

    @PostMapping("/students/register")
    public String registerStudent(@ModelAttribute Student student) {
        System.out.println("Received Student: " + student); // Debugging line
        studentService.saveStudent(student);
        return "redirect:/eregistrar/students";
    }

    @GetMapping("/students/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Student student = studentService.getStudentById(id);
        model.addAttribute("student", student);
        model.addAttribute("id", id);
        return "student/edit";
    }

    @PostMapping("/students/edit/{id}")
    public String updateStudent(@PathVariable Long id, @ModelAttribute Student student) {
        System.out.println("Received Student: " + student); // Debugging line
        studentService.updateStudent(student);
        return "redirect:/eregistrar/students";
    }

    @GetMapping("/students/delete/{id}")
    public String showDeleteConfirmation(@PathVariable Long id, Model model) {
        Student student = studentService.getStudentById(id);
        model.addAttribute("student", student);
        return "student/delete";
    }

    @DeleteMapping("/students/delete/{id}")
    public String deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return "redirect:/eregistrar/students";
    }

    @GetMapping("/students/search")
    public String showSearchForm(Model model) {
        return "student/search";
    }

    @PostMapping("/students/search")
    public String searchStudents(@RequestParam(value = "firstName", required = false) String firstName,
                                 @RequestParam(value = "lastName", required = false) String lastName,
                                 Model model) {
        // Call the service method to search for students by firstName and lastName
        List<Student> searchResults = studentService.searchStudentsByCriteria(firstName, lastName);

        // Pass the search results to the view.
        model.addAttribute("searchResults", searchResults);

        return "student/search-results";
    }
}