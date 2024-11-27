package com.practice2.practice2.core.domain.product.infrastructure.persistence;

import com.practice2.practice2.core.domain.product.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface JPAImplProductRepository extends JpaRepository<Product, String> {

}
