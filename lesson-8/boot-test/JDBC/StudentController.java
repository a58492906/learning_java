package com.example.boot.JDBC;

import com.example.boot.configuration.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;

/**
 * @author xjm
 * @version 1.0
 * @date 2021-06-06 22:29
 */
@RestController
@RequestMapping("/api/student")
public class StudentController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/insert")
    public int add(Student student) {
        String sql = "insert into test (name,) values(?)";
        int result = jdbcTemplate.update(sql, student.getName());
        return result;
    }
    /**
     * 查询方法
     * @return 返回 json 数据
     * */
    @GetMapping("/query" )
    public Object   getUsers(){
        List<Map<String,Object>> list=jdbcTemplate.queryForList("select * from test ");
        return  list;
    }
    /**
     *update方法
     * @return 返回 json 数据
     * */
    @GetMapping("/student")
    public int update(Student student) {
        String sql = "update test set name =? where id = ?";
        int result = jdbcTemplate.update(sql, student.getName(),student.getId());
        return result;
    }

    @GetMapping("delete")
    public int deleteById(String id) {
        String sql = "delete from test where id = ?";
        int result = jdbcTemplate.update(sql, id);
        return result;
    }

    /**
     * 事物
     * @param student
     */
    @Transactional
    public void insertUser(Student student) {
        String sql = "insert into test(id, name) values(?,?)";
        jdbcTemplate.update(sql, student.getId(), student.getName());
		int num = 1/0;
		//放开测试事务。预期结果为添加失败，库中无数据。测试结果与预期一致
    }
    /**
     * PreparedStatementSetter
     * @param student
     */
    @Transactional
    public void updateUser(Student student) {
        String sql = "update test set name = ? where id = ?";

        PreparedStatementSetter pss = new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement arg0) throws SQLException {
                arg0.setString(1, student.getName());
                arg0.setLong(2, student.getId());
            }
        };

        jdbcTemplate.update(sql, pss);
    }

}
