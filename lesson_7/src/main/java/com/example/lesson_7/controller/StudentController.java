package com.example.lesson_7.controller;

import com.example.lesson_7.entity.Student;
import com.example.lesson_7.exception.StudentNotFoundException;
import com.example.lesson_7.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/")
    public String listAll(Model model) {
        List<Student> students = studentService.listAll();
        model.addAttribute("students", students);
        return "students";
    }

    @GetMapping("/add")
    public String add(Model model) {
        Student student = new Student();
        model.addAttribute("student", student);
        model.addAttribute("pageTitle", "Add New Student");
        return "student_form";
    }

    @PostMapping("/save")
    public String saveProduct(Student student) {
        studentService.save(student);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable(name = "id") Integer id) {
        try {
            studentService.delete(id);
        } catch (StudentNotFoundException e) {
            e.printStackTrace();
        }

        return "redirect:/";
    }
}

