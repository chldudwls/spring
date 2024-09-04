package com.ch04.controller;

import com.ch04.dto.User2Dto;
import com.ch04.service.User2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class User2Contorller {

    private User2Service service;

    @Autowired
    public User2Contorller(User2Service service) {
        this.service = service;
    }

    @GetMapping("/user2/register")
    public String register(){
        return "/user2/register";
    }

    @PostMapping("/user2/register")
    public String register(User2Dto dto){
        System.out.println(dto);

        //등록
        service.insertUser2(dto);
        //리다이렉트
        return "redirect:/user2/list";
    }

    @GetMapping("/user2/list")
    public String list(Model model){

        List<User2Dto> users = service.selectUser2s();
        System.out.println(users);

        model.addAttribute("users", users);
        return "/user2/list";
    }

    @GetMapping("/user2/modify")
    public String modify(@RequestParam("uid") String uid, Model model){
        System.out.println("uid : " + uid);

        User2Dto user = service.selectUser2(uid);

        model.addAttribute(user);
        return "/user2/modify";
    }

    @PostMapping("/user2/modify")
    public String modify(User2Dto dto){
        System.out.println(dto);

        service.updateUser2(dto);

        return "redirect: /ch04/user2/list";
    }

    @GetMapping("/user2/delete")
    public String delete(@RequestParam("uid") String uid){
        System.out.println("uid : " + uid);

        service.deleteUser2(uid);

        return "redirect:/user2/delete";
    }

}
