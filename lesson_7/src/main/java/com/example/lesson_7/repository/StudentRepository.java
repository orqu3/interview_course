package com.example.lesson_7.repository;

import com.example.lesson_7.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {

    Long countById(Integer id);

}
