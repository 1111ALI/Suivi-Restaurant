package com.almo.restaurant.controllers.frontEnd;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
//@RequestMapping("/auth")
public class AuthController {

    @GetMapping("/login")
    public String login() {

        return "login";
    }


    @PostMapping("/login")
    public String connected() {
        return "redirect:/home";
    }



    @GetMapping("/home")
    public String home() {

        return "home";
    }

}
