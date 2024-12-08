package com.practice2.practice2.core.domain.category.infrastructure.persistence;

import com.practice2.practice2.core.domain.category.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JPAImplCategoryRepository extends JpaRepository<Category, String> {
}
