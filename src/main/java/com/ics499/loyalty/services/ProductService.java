package com.ics499.loyalty.services;

import com.ics499.loyalty.model.Product;
import com.ics499.loyalty.repositories.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepo productRepo;

    public List<Product> findAll() {
        var it = productRepo.findAll();

        var products = new ArrayList<Product>();
        it.forEach(e -> products.add(e));

        return products;
    }

    public Optional<Product> findById(Long id) {
        return productRepo.findById(id);
    }

    public void add(Product product) {
        productRepo.save(product);
    }

    public Long count() {
        return productRepo.count();
    }

    public void deleteById(Long productID) {
        productRepo.deleteById(productID);
    }
}
