package com.example.demo.student;

import org.springframework.stereotype.Controller;

@Controller
public class PageController {
    public String home() {
        return "home";
    }
}
