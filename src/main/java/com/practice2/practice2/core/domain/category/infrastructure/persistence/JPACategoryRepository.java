package com.practice2.practice2.core.domain.category.infrastructure.persistence;

import com.practice2.practice2.core.domain.category.domain.Category;
import com.practice2.practice2.core.domain.category.domain.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JPACategoryRepository implements CategoryRepository {

    private JPAImplCategoryRepository jpaRepository;

    public JPACategoryRepository(JPAImplCategoryRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public List<Category> index() {
        return this.jpaRepository.findAll();
    }
}
