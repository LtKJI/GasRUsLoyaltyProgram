package com.ics499.loyalty.repositories;

import org.springframework.data.repository.CrudRepository;
import com.ics499.loyalty.model.Product;

public interface ProductRepo extends CrudRepository<Product, Long>{

}
