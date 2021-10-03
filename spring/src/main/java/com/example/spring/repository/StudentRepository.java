package com.example.spring.repository;

import com.example.spring.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {

    Long countById(Integer id);

}
