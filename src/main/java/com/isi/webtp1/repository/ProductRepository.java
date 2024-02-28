package com.isi.webtp1.repository;

import com.isi.webtp1.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


// need to specify model name and type of primary key
public interface ProductRepository extends JpaRepository<Product, Integer> {

    List<Product> findByPriceBetween(double minPrice, double maxPrice);
}
