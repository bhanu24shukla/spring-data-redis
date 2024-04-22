package com.javatechie.redis.service;

import com.javatechie.redis.model.Student;

import java.util.List;

public interface StudentService {
    Student findById(long id);

    Student createStudent(Student student);

    void deleteStudent(long id);

    List<Student> fetchAllStudentData();
}
