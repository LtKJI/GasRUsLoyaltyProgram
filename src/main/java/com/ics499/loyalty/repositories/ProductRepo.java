package com.ics499.loyalty.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import com.ics499.loyalty.model.*;

public interface ProductRepo extends JpaRepository<Product, Long>{

}
