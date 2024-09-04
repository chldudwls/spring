package com.ch04.service;

import com.ch04.dao.User1Dao;
import com.ch04.dto.User1Dto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class User1Service {



    private User1Dao dao;

    @Autowired
    public User1Service(User1Dao dao){
        this.dao = dao;

    }


    public void insertUser1(User1Dto dto){
        dao.insertUser1(dto);
    }
    public User1Dto selectUser1(String uid){
        return dao.selectUser1(uid);
    }
    public List<User1Dto> selectUser1s(){
        return dao.selectUser1s();
    }
    public void updeteUser1(User1Dto dto){
        dao.updeteUser1(dto);
    }
    public void deleteUser1(String uid){
        dao.deleteUser1(uid);
    }
}
