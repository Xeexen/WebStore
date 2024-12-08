package com.practice2.practice2.core.domain.category.application;

import com.practice2.practice2.core.domain.category.domain.CategoryRepository;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    private CategoryRepository repository;

    public CategoryService(CategoryRepository repository) {
        this.repository = repository;
    }
}
