package com.ch05.dao;

import com.ch05.dto.User1Dto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

// mybatus scanning을 위해 @mapper 선언
@Mapper
public interface User1Mapper {

    public void insertUser1(User1Dto user1Dto);
    public List<User1Dto> selectUser1s();
    public User1Dto selectUser1(String uid);
    public void updateUser1(User1Dto user1Dto);
    public void deleteUser1(String uid);

}
