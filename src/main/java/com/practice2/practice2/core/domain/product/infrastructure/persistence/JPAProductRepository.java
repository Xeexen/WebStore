package com.practice2.practice2.core.domain.product.infrastructure.persistence;

import com.practice2.practice2.core.domain.product.domain.Product;
import com.practice2.practice2.core.domain.product.domain.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JPAProductRepository implements ProductRepository {

    private final JPAImplProductRepository implRepository;

    public JPAProductRepository(JPAImplProductRepository implRepository) {
        this.implRepository = implRepository;
    }

    @Override
    public List<Product> index() {
        return this.implRepository.findAll();
    }

    @Override
    public void create(Product product) {
        this.implRepository.save(product);
    }

    @Override
    public void update(Product product) {
        this.implRepository.save(product);
    }

    @Override
    public void delete(String Id) {
        this.implRepository.deleteById(Id);
    }

    @Override
    public Optional<Product> findById(String id) {
        return this.implRepository.findById(id);
    }

    @Override
    public List<Product> updateAllStock(List<Product> products) {
        for (Product product : products) {
            if (product.getUnitsInStock() < 500) {
                product.setUnitsInStock(product.getUnitsInStock() + 1000);
                this.update(product);
            }
        }
        return this.index();
    }

    @Override
    public List<Product> findByCategory(String category) {
        this.implRepository.findProductByCategory(category);
        return List.of();
    }

    @Override
    public List<Product> getProductsByFilter(String category, String manufacturer) {
        return this.implRepository.findByCategoryAndAndManufacturer(category, manufacturer);
    }

}
