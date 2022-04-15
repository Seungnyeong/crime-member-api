package com.dns.memberapi.web.controller.api;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/api/v1/member")
public class SignInController {

    @PostMapping("/sign-in")
    public String signIn(HttpSession session) {
        return "redirect:home";
    }
}
