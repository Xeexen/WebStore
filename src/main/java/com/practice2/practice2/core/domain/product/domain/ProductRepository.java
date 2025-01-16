package com.practice2.practice2.core.domain.product.domain;

import java.awt.*;
import java.io.File;
import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    List<Product> index();

    void create(Product product);

    void update(Product product);

    void delete(String Id);

    Optional<Product> findById(String id);

    List<Product> findByCategory(String category);

    List<Product> updateAllStock(List<Product> products);

    List<Product> getProductsByFilter(String category, String manufacturer);

    void addImage(File file);
}
