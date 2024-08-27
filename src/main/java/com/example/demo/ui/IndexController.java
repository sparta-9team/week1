package com.example.demo.ui;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class IndexController {

    @GetMapping("/")
    public String index(){
        return "indexWithDetails/home";
    }

    @GetMapping("/details/{userId}")
    public String details(@PathVariable String userId){
        return "indexWithDetails/details/" + userId;
    }

}
