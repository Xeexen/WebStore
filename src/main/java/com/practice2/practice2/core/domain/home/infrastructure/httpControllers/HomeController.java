package com.practice2.practice2.core.domain.home.infrastructure.httpControllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

//    @RequestMapping("/home") 
    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("title", "Welcome to Web Store!");
        model.addAttribute("message", "The one and only amazing web store");
        return "Home";
    }
}
