package com.isi.webtp1.controller;

import com.isi.webtp1.entity.Product;
import com.isi.webtp1.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products") // Base mapping for all product-related endpoints
public class ProductController {

    @Autowired
    private ProductService service;

    @PostMapping // POST method to create a new product
    public Product addProduct(@RequestBody Product product) {
        return service.saveProduct(product);
    }

    @GetMapping // GET method to retrieve all products
    public List<Product> findAllProducts() {
        return service.getProducts();
    }

    @GetMapping("/{id}") // GET method to retrieve a specific product by ID
    public Product findProductById(@PathVariable int id) {
        return service.getProductById(id);
    }

    @PutMapping("/{id}") // PUT method to update a specific product by ID
    public Product updateProduct(@PathVariable int id, @RequestBody Product product) {
        product.setId(id); // Ensure the ID in the path matches the ID in the body
        return service.updateProduct(product);
    }

    @DeleteMapping("/{id}") // DELETE method to delete a specific product by ID
    public Product deleteProduct(@PathVariable int id) {
        return service.deleteProduct(id);
    }
}
