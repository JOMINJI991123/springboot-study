package com.example.hongtack.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstApiController {

    public String hello(){

        return "hello";
    }

}
