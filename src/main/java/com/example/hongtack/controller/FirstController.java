package com.example.hongtack.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FirstController {
    @GetMapping("/hi")
    public String niceToMeetYou(Model model){
        model.addAttribute("username","홍");
        return "greetings";
    }

    @GetMapping("/bye")
    public String seeYouNext(Model model){
        model.addAttribute("username","밍돌");
        return "goodbye";
    }
}
