package com.ch09.controller;

import com.ch09.dto.User1DTO;
import com.ch09.entity.User1;
import com.ch09.service.User1Service;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log4j2
@Controller
@RequiredArgsConstructor
public class User1Controller {

    private User1Service user1Service;

    @ResponseBody
    @GetMapping("/user1")
    public List<User1DTO> list(){
        List<User1DTO> users = user1Service.selectUser1s();
        return users;
    }

    @ResponseBody
    @GetMapping("/user1/{uid}")
    public User1DTO user(@PathVariable("uid") String uid){
        User1DTO user = user1Service.selectUser1(uid);
        return user;
    }

    @ResponseBody
    @PostMapping("/user1/{uid}")
    public ResponseEntity register(User1DTO user1DTO){
        log.info(user1DTO);
        User1 savedUser1 = user1Service.insertUser1(user1DTO);

           return ResponseEntity
                   .status(HttpStatus.CREATED) // 201
                   .body(savedUser1);

    }

    @ResponseBody
    @PutMapping("/user1/{uid}")
    public ResponseEntity modify(User1DTO user1DTO){
        log.info(user1DTO);
        User1 modifyUser1 = user1Service.updateUser1(user1DTO);

        return ResponseEntity
                .status(HttpStatus.ACCEPTED) // 202
                .body(modifyUser1);
    }

    @ResponseBody
    @DeleteMapping("/user1/{uid}")
    public ResponseEntity<String> delete(String uid) {
        try {

            user1Service.deleteUser1(uid);
            return ResponseEntity
                    .status(HttpStatus.OK) // 200
                    .body("success");

        }catch (Exception e){
            log.error(e);
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND) // 404
                    .body(e.getMessage());
        }
    }
}
