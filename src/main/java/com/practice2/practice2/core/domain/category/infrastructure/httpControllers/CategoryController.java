package com.practice2.practice2.core.domain.category.infrastructure.httpControllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CategoryController {
    @GetMapping("category/get")
    public String getCategoryPage() {
        return "category/get";
    }
}
