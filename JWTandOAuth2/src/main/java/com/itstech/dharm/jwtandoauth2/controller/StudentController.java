package com.itstech.dharm.jwtandoauth2.controller;

import com.itstech.dharm.jwtandoauth2.model.Student;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class StudentController {

    List<Student> students = new ArrayList<>(Arrays.asList(
            new Student(101, "Dharmendra Kumar", "Java Spring Boot"),
            new Student(102, "Rahul Sharma", "Microservices"),
            new Student(103, "Priya Verma", "React JS"),
            new Student(104, "Aman Singh", "PostgreSQL"),
            new Student(105, "Sneha Gupta", "Spring Security")
    ));

    @GetMapping("csrf-token")
    public CsrfToken csrfToken(HttpServletRequest request) {
        return (CsrfToken) request.getAttribute("_csrf");
    }

    @GetMapping("students")
    public List<Student> getStudents() {
        return students;
    }

    @PostMapping("student")
    public Student addStudent(@RequestBody Student student) {
        students.add(student);
        return student;
    }

    @PutMapping("student")
    public Student updateStudent(@RequestBody Student student) {
        students.add(student);
        return student;
    }

    @DeleteMapping("student")
    public String deleteStudent(@RequestBody Student student) {
        students.remove(student);
        return student.toString();
    }
}
