package com.ch04.dao;


import com.ch04.dto.User1Dto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;

@Repository
public class User1Dao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public User1Dao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public void insertUser1(User1Dto dto){

        String sql = "insert into `user1` values(?,?,?,?,?)";
        Object[] params = {
                dto.getUid(),
                dto.getName(),
                dto.getBirth(),
                dto.getHp(),
                dto.getAge()
        };

        jdbcTemplate.update(sql, params);



    }
    public User1Dto selectUser1(String uid){

        String sql = "select * from user1 where uid=?";
        Object dto = (User1Dto) jdbcTemplate.queryForObject(sql, new User1RowMapper(), uid);



        return (User1Dto) dto;
    }
    public List<User1Dto> selectUser1s(){

        String sql = "select * from user1";
        return jdbcTemplate.query(sql, new User1RowMapper());

    }
    public void updeteUser1(User1Dto dto){

        String sql = "UPDATE user1 SET name=?, birth=?, hp=?, age=? WHERE uid=?";
        Object[] params = {
                dto.getName(),
                dto.getBirth(),
                dto.getHp(),
                dto.getAge(),
                dto.getUid()
        };
        jdbcTemplate.update(sql, params);
    }
    public void deleteUser1(String uid){
        String sql = "delete from user1 where uid=?";
        jdbcTemplate.update(sql, uid);
    }


}
