package com.jpa.springboot.learnjpaandhibernate.course;

import com.jpa.springboot.learnjpaandhibernate.course.Course;
import com.jpa.springboot.learnjpaandhibernate.course.jpa.CourseJpaRepository;
import com.jpa.springboot.learnjpaandhibernate.course.springdatajpa.CourseSpringDataJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseCommandLineRunner implements CommandLineRunner {
   // @Autowired
   // private CourseJdbcJpaRepository repository;
    //@Autowired
    //private CourseJpaRepository repository;

    @Autowired
    private CourseSpringDataJpaRepository repository;
    @Override
    public void run(String... args) throws Exception {
        repository.save(new Course(1,"SpringBoot jpa","telusko"));
        repository.save(new Course(2,"SpringFramework","in28minutes"));
        repository.save(new Course(3,"Java and sql","kunal"));
        repository.save(new Course(4,"sql","kl"));

        repository.deleteById(1l);
        System.out.println(repository.findById(2l));
        System.out.println(repository.findById(3l));

        System.out.println(repository.findAll());
        System.out.println(repository.count());


        System.out.println(repository.findByAuthor("kunal"));
        System.out.println(repository.findByAuthor(""));

        System.out.println(repository.findByName("SpringFramework"));
    }
}
