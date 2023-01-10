package com.jpa.springboot.learnjpaandhibernate.course.jdbc;

import com.jpa.springboot.learnjpaandhibernate.course.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseJdbcCommandLineRunner implements CommandLineRunner {
    @Autowired
    private CourseJdbcRespository respository;
    @Override
    public void run(String... args) throws Exception {
        respository.insert(new Course(1,"SpringBoot","telusko"));
        respository.insert(new Course(2,"Spring","in28minutes"));
        respository.insert(new Course(3,"Java","kunal"));
        respository.deleteById(1);
    }
}
