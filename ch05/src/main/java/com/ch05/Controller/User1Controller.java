package com.ch05.Controller;

import com.ch05.dto.User1Dto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.ch05.service.User1Service;

import java.util.List;

@Controller
public class User1Controller {

    private final User1Service user1Service;

    @Autowired
    public User1Controller(User1Service user1Service) {
        this.user1Service = user1Service;
    }

    @GetMapping("/user1/list")
    public String list(Model model) {

        System.out.println("list!!!");

        List<User1Dto> users = user1Service.selectUser1s();

        model.addAttribute("users", users);

        return "/user1/list";
    }

    @GetMapping("/user1/register")
    public String register(){
        return "/user1/register";
    }
    @PostMapping("/user1/register")
    public String regiser(User1Dto user1Dto) {

        user1Service.insertUser1(user1Dto);
        return "redirect:/user1/list";

    }

    @GetMapping("/user1/modify")
    public String modify(@RequestParam("uid") String uid, Model model){

        User1Dto user1Dto = user1Service.selectUser1(uid);
        model.addAttribute(user1Dto);

        return "/user1/modify";
    }
    @PostMapping("/user1/modify") // URL을 클라이언트 요청과 일치시킴
    public String modify(User1Dto user1Dto) {
        user1Service.updateUser1(user1Dto);
        return "redirect:/user1/list";
    }


    @GetMapping("/user1/delete")
    public String delete(@RequestParam("uid") String uid) {

        user1Service.deleteUser1(uid);
        return "redirect:/user1/list";
    }
}
