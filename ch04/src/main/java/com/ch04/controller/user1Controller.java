package com.ch04.controller;

import com.ch04.dto.User1Dto;
import com.ch04.service.User1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class user1Controller {

    private User1Service service;

    @Autowired
    public user1Controller(User1Service service) {
        this.service = service;
    }

    @GetMapping("/user1/register")
    public String register(){
        return "/user1/register";
    }

    @PostMapping("/user1/register")
    public String register(User1Dto dto){
        System.out.println(dto);

        // 등록
        service.insertUser1(dto);

        // 리다이렉트
        return "redirect:/user1/list";
    }

    @GetMapping("/user1/list")
    public String list(Model model){

        //조회
        List<User1Dto> users = service.selectUser1s();
        System.out.println(users);

        //모델참조(Controller 데이터를 View에서 참조)
        model.addAttribute("users", users);

        return "/user1/list";
    }
    @GetMapping("/user1/modify")
    public String modify(@RequestParam ("uid") String uid, Model model){ //RequestParam("uid") 생략가능
        System.out.println("uid : " + uid);

        // 수정 회원 조회
        User1Dto user = service.selectUser1(uid);


        //모델 참조
        model.addAttribute(user); // 타입명으로 저장(소분자 시작 user1Dto) (키,벨류)


        return "/user1/modify";
    }

    @PostMapping("/user1/modify")
    public String modify(User1Dto dto){
        System.out.println(dto);

        // 수정
        service.updeteUser1(dto);


        // 디라이렉트
        return "redirect:/user1/list";
    }


    @GetMapping("/user1/delete")
    public String delete(@RequestParam("uid") String uid) {
        System.out.println(uid); // uid 값을 출력합니다.

        // Service에 UID를 전달하여 사용자 삭제
        service.deleteUser1(uid);

        return "redirect:/user1/list"; // 삭제 후 리스트 페이지로 리디렉션
    }

}
