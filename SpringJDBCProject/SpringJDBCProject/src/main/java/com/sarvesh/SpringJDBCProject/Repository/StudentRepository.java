package com.sarvesh.SpringJDBCProject.Repository;

import com.sarvesh.SpringJDBCProject.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepository {

    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    //To save the data we need a JDBC template
    public void save(Student student) {

        String sql = "insert into student (rollNo, name, marks) values (?,?,?)";

        //This rollNo, name, and marks sequence matters.
        //This .update returns number of rows affected.
        //0 rows means data is not added and more than 1 means data is added.
        int rows = jdbcTemplate.update(sql, student.getRollNo(), student.getName(), student.getMarks());

        System.out.println(rows + " affected");

        System.out.println("Student data added...");
    }

    public List<Student> findAll() {
        String sql = "select * from student";

        //To fire a select query in JDBC we use executeQuery
        //Here we have to query method to fire a select query.
        //It takes two parameters, first one is query itself and second one is RowMapper.
        //RowMapper helps to fetch the data from ResultSet.

        RowMapper<Student> mapper = new RowMapper<Student>() {
            @Override
            //mapRow will give us the one row at a time from the table in a database.
            //Basically is fetches the data from ResultSet
            public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
                Student student = new Student();

                //here we created the student object, and we set the data in student object by fetching it from ResultSet.
                student.setRollNo(rs.getInt("rollNo"));
                student.setName(rs.getString("name"));
                student.setMarks(rs.getInt("marks"));
                return student;
            }
        };

        return jdbcTemplate.query(sql, mapper);
    }
}
