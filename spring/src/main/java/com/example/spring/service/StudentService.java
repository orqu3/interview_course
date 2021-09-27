package com.example.spring.service;

import com.example.spring.entity.Student;
import com.example.spring.exception.StudentNotFoundException;
import com.example.spring.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    public List<Student> listAll() {
        return studentRepository.findAll();
    }

    public void save(Student student) {
        studentRepository.save(student);
    }

    public Student get(Integer id) throws StudentNotFoundException {
        try {
            return studentRepository.findById(id).get();
        } catch (NoSuchElementException e) {
            throw new StudentNotFoundException("Could not find any student with id " + id);
        }
    }

    public void delete(Integer id) throws StudentNotFoundException {
        Long countById = studentRepository.countById(id);
        if (countById == null || countById == 0) {
            throw new StudentNotFoundException("Could not find any student with ID " + id);
        }
        studentRepository.deleteById(id);
    }
}
