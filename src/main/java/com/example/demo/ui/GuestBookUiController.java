package com.example.demo.ui;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GuestBookUiController {

    @GetMapping("/create/guestBook")
    public String guestBookPage() {
        return "guestBook-save";
    }
}
