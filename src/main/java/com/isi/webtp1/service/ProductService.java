package com.isi.webtp1.service;

import com.isi.webtp1.entity.Product;
import com.isi.webtp1.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;

    // create operations
    public Product saveProduct(Product product) {
        return repository.save(product);
    }

    public List<Product> saveProducts(List<Product> product) {
        return repository.saveAll(product);
    }

    // read operations
    public List<Product> getProducts() {
        return repository.findAll();
    }

    public Product getProductById(int id) {
        return repository.findById(id).orElse(null);
    }

//    public Product getProductByName(String name) {
//        return repository.findByName(name);
//    }

    // update operations
    public Product updateProduct(Product product){
        Product e = repository.findById(product.getId()).orElse(null);
        e.setName(product.getName());
        e.setPrice(product.getPrice());
        e.setQuantity(product.getQuantity());
        return repository.save(e);
    }

    // delete operations
    public Product deleteProduct(int id){
        Product e = repository.findById(id).orElse(null);
        repository.deleteById(id);
        return e;
    }
}
