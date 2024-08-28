package com.example.demo.ui;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GuestBookController {

    @GetMapping("/read/guestBook")
    public String guestBookHome(){
        return "/guestBook/guestBook-home";
    }

    @GetMapping("/create/guestBook")
    public String createQuestBook() {
        return "/guestBook/guestBook-save";
    }
}
