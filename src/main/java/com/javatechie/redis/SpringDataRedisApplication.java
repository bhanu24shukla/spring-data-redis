package com.javatechie.redis;

import com.javatechie.redis.dao.StudentRepository;
import com.javatechie.redis.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SpringDataRedisApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SpringDataRedisApplication.class, args);
    }

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public void run(String... args) throws Exception {
        Student studentOne = Student.builder()
                .id(1)
                .firstName("Dilip")
                .lastName("Virk")
                .build();
        studentRepository.save(studentOne);

        Student studentTwo = Student.builder()
                .id(2)
                .firstName("Rajesh")
                .lastName("Kumar")
                .build();
        studentRepository.save(studentTwo);
    }
}
