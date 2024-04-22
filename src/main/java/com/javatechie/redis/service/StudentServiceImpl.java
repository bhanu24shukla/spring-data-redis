package com.javatechie.redis.service;

import com.javatechie.redis.dao.StudentRepository;
import com.javatechie.redis.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student findById(long id) {
        return studentRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Student data doesn't exist with the provided id!!"));
    }

    @Override
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public void deleteStudent(long id) {
        Student studentDetails = studentRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Student data doesn't exist with the provided id!!"));
        studentRepository.delete(studentDetails);
    }

    @Override
    public List<Student> fetchAllStudentData() {
        return studentRepository.findAll();
    }

}
