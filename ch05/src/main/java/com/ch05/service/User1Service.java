package com.ch05.service;

import com.ch05.dao.User1Mapper;
import com.ch05.dto.User1Dto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class User1Service {

    private final User1Mapper user1Mapper;

    @Autowired
    public User1Service(User1Mapper user1Mapper) {
        this.user1Mapper = user1Mapper;
    }
    public void insertUser1(User1Dto user1Dto){
        user1Mapper.insertUser1(user1Dto);
    }
    public List<User1Dto> selectUser1s(){
        return user1Mapper.selectUser1s();
    }
    public User1Dto selectUser1(String uid){
        return user1Mapper.selectUser1(uid);
    }
    public void updateUser1(User1Dto user1Dto){
        user1Mapper.updateUser1(user1Dto);
    }
    public void deleteUser1(String uid){
        user1Mapper.deleteUser1(uid);
    }
}
