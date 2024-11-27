package com.practice2.practice2.core.domain.product.infrastructure.persistence;

import com.practice2.practice2.core.domain.product.domain.Product;
import com.practice2.practice2.core.domain.product.domain.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public void findById(String id) {
        this.implRepository.findById(id);
    }
}
