package com.javatechie.redis.controller;

import com.javatechie.redis.model.Student;
import com.javatechie.redis.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentService studentService;
    private static final String HASH_KEY = "Student";

    @GetMapping("/{id}")
    @Cacheable(value = HASH_KEY, key = "#id")
    public Student findStudentById(@PathVariable("id") long id) {
        return studentService.findById(id);
    }

    @PostMapping
    @CachePut(value = HASH_KEY, key = "#student.id")
    public Student createStudent(@RequestBody Student student) {
        return studentService.createStudent(student);
    }

    @GetMapping
    public List<Student> fetchAllStudentData() {
        return studentService.fetchAllStudentData();
    }

    @DeleteMapping("{id}")
    @CacheEvict(value = HASH_KEY, key = "#id")
    public void deleteStudentById(@PathVariable("id") long id) {
        studentService.deleteStudent(id);
    }

}
