package com.ics499.loyalty.repositories;
// import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;
import com.ics499.loyalty.model.Product;

@Repository
public interface ProductRepo extends CrudRepository<Product, Long>{

}
