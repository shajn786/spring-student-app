package com.example.studentappnew_backend.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {


    @GetMapping("/")
    public String HomePage()
    {
        return "welcome to my website";
    }


    @GetMapping("/home")
    public String Home()
    {
        return "welcome to my home";
    }



    @GetMapping("/contact")
    public  String Contactpage()
    {
        return "my contact page";
    }


    @GetMapping("/gallery")
    public String Gallery()
    {
        return "my gallery";
    }

}
