package com.jpa.springboot.learnjpaandhibernate.course.jdbc;

import com.jpa.springboot.learnjpaandhibernate.course.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CourseJdbcRespository {
    @Autowired
   private JdbcTemplate springJdbcTemplate;
    private static String INSERT_QUERY =
            """
               insert into course (id,name,author)
               values(?,?,?);
                 
            """;
    private static String DELETE_QUERY =
            """
               delete from course
               where id=?
                 
            """;
    private static String SELECT_QUERY =
            """
               select * from course
               where id=?
                 
            """;

    public void insert(Course course){
        springJdbcTemplate.update(INSERT_QUERY,
                course.getId(),course.getName(),course.getAuthor());
    }
    public void deleteById(long id){
        springJdbcTemplate.update(DELETE_QUERY,id);
    }

    //Resultset->Bean==>RowMapper
    public Course findbyId(long id){
        return springJdbcTemplate.queryForObject(SELECT_QUERY,new BeanPropertyRowMapper<>(Course.class),id);
    }
}
