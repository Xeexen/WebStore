package com.practice2.practice2.core.domain.product.application;

import com.practice2.practice2.core.domain.product.domain.Product;
import com.practice2.practice2.core.domain.product.domain.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository repository;
    private final Logger logger = LoggerFactory.getLogger(ProductService.class);


    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public void createProduct(Product product) {
        try {
            repository.create(product);
            logger.info("Product created: {}", product);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw e;
        }

    }

    public void updateProduct(Product product) {
        try {
            repository.update(product);
            logger.info("Product updated: {}", product);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw e;
        }
    }

    public void deleteProduct(String id) {
        try {
            repository.delete(id);
            logger.info("Product deleted with id: {}", id);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw e;
        }
    }

    public void showProduct(String id) {
        try {
            repository.findById(id);
            logger.info("Product found with id: {}", id);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw e;
        }
    }

    public List<Product> indexProducts() {
        try {
            List<Product> products = repository.index();
            logger.info("Products indexed");
            return products;

        } catch (Exception e) {
            logger.error(e.getMessage());
            throw e;
        }
    }
}
