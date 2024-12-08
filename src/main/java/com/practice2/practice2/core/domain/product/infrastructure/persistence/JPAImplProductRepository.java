package com.practice2.practice2.core.domain.product.infrastructure.persistence;

import com.practice2.practice2.core.domain.product.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface JPAImplProductRepository extends JpaRepository<Product, String> {
    void findProductByCategory(String category);

    List<Product> findByCategoryAndAndManufacturer(String category, String manufacturer);
}

