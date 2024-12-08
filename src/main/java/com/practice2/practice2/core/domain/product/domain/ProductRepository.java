package com.practice2.practice2.core.domain.product.domain;

import java.util.List;

public interface ProductRepository {
    List<Product> index();

    void create(Product product);

    void update(Product product);

    void delete(String Id);

    void findById(String id);

    List<Product> findByCategory(String category);

    List<Product> updateAllStock(List<Product> products);

    List<Product> getProductsByFilter (String category, String manufacturer);
}
