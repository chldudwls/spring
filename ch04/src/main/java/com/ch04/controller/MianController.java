package controller;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class MianController {

    @RequestMapping(value =  "/hello", method = RequestMethod.GET)
    publec void hello(){
        System.out.println("hello...");
    }

    @GetMapping("/welcome")
    public void welcome(){

    }

    public void greeting(){

    }
}
