package com.stackroute.springJdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component
public class StudentDao
{
    // Declaration
    private JdbcTemplate jdbcTemplate;
    private DataSource dataSource;

    /*public void createTable()
    {
        String query="create table student(id int,name varchar(20),gender varchar(20),marks int)";
        jdbcTemplate.update(query);
    }
    */
    //int count=0;
    public void insertData()
    {
        String query="insert into student values(1,'priyanka','Female',50)";
        jdbcTemplate.execute(query);
        String query1="insert into student values(3,'swetha','Female',90)";
        jdbcTemplate.execute(query1);
        //return count++;
    }

    // Implementing rowmapper
    List<Student> getAllStudents() {
        // List<Student> result=new List<Student>();

        String query = "select * from student";
        return jdbcTemplate.query(query, new RowMapper<Student>() {
            @Override
            public Student mapRow(ResultSet resultSet, int i) throws SQLException {
                Student student = new Student();
                student.setId(resultSet.getInt(1));
                student.setName(resultSet.getString(2));
                student.setGender(resultSet.getString(3));
                student.setMarks(resultSet.getInt(4));
                return student;
            }
        });
    }

    public void updateDetails()
    {
        String query="update student set name='kokila' where id=1";
        jdbcTemplate.execute(query);
    }

    public void deleteDetails()
    {
        String query="delete from student where id=3";
        jdbcTemplate.update(query);
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public DataSource getDataSource() {
        return dataSource;
    }
    @Autowired
    public void setDataSource(DataSource dataSource) {

        jdbcTemplate=new JdbcTemplate(dataSource);
    }
}
