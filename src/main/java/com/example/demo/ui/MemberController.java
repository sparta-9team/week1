package com.example.demo.ui;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MemberController {

    @GetMapping("/secondMember")
    public String secondMember() {
        return "/member/member2-introduce";
    }

    @GetMapping("/thirdMember")
    public String thirdMember() {
        return "/member/member3-introduce";
    }
}
