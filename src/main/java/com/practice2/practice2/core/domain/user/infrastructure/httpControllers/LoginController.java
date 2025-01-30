package com.practice2.practice2.core.domain.user.infrastructure.httpControllers;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
    @GetMapping("/login")
    public String login(@Param("keyword") String keyword, Model model) {
        model.addAttribute("title", "Login");
        return "Login";
    }
}
