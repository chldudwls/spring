package com.ch09.controller;

import com.ch09.dto.User1DTO;
import com.ch09.dto.User2DTO;
import com.ch09.entity.User1;
import com.ch09.entity.User2;
import com.ch09.service.User2Service;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// REST API용 컨트롤러 어노테이션
@Controller
@RequiredArgsConstructor
public class User2Controller {

    private final User2Service user2Service;

    // @RestControoler를 사용하면 @ResponseBody는 생략
    @ResponseBody
    @GetMapping("/user2/")
    public List<User2DTO> list(HttpServletResponse request) {
        List<User2DTO> users = user2Service.selectUser2s();
        return users;
    }
    @ResponseBody
    @GetMapping("/user2/{uid}")
    public User2DTO user(@PathVariable("uid") String uid){
        User2DTO user2 = user2Service.selectUser2(uid);
        return user2;
    }
    @ResponseBody
    @PostMapping("/user2/")
    public ResponseEntity register(@RequestBody User2DTO user2DTO){
        User2 savedUser2 = user2Service.insertUser2(user2DTO);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(savedUser2);
    }
    @ResponseBody
    @PutMapping("/user2/")
    public ResponseEntity modify(@RequestBody User2DTO user2DTO){
        User2 modifyUser2 = user2Service.updateUser2(user2DTO);

        return ResponseEntity
                .status(HttpStatus.ACCEPTED) // 202
                .body(modifyUser2);
    }

    @DeleteMapping("/user2/{uid}")
    public ResponseEntity delete(@PathVariable("uid") String uid) {

        try {
            user2Service.deleteUser2(uid);
            return ResponseEntity
                    .status(HttpStatus.OK) // 200
                    .body("success");
        }catch (Exception e){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND) // 404
                    .body(e.getMessage());
        }
    }
}
