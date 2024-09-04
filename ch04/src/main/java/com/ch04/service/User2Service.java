package com.ch04.service;

import com.ch04.dao.User2Dao;
import com.ch04.dto.User2Dto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class User2Service {

    private User2Dao dao;
    public User2Service(User2Dao dao){
        this.dao = dao;
    }

    public void insertUser2(User2Dto dto){
       dao.insertUser2(dto);
    }
    public User2Dto selectUser2(String uid){

        return dao.selectUser2(uid);
    }
    public List<User2Dto> selectUser2s(){

        return dao.selectUser2s();
    }
    public void updateUser2(User2Dto dto){
        dao.updateUser2(dto);
    }

    public void deleteUser2(String uid){
        dao.deleteUser2(uid);
    }
}
