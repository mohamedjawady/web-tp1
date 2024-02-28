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

    // POST method to create a new product
    @PostMapping
    public Product addProduct(@RequestBody Product product) {
        return service.saveProduct(product);
    }

    // GET method to retrieve all products
    @GetMapping
    public List<Product> findAllProducts() {
        return service.getProducts();
    }

    // GET method to retrieve all products within a price range
    @GetMapping("/search")
    public List<Product> findAllProductsByPrice(@RequestParam double min, @RequestParam double max) {
        return service.getProductsByPrice(min, max);
    }

    // GET method to retrieve a specific product by ID
    @GetMapping("/{id}")
    public Product findProductById(@PathVariable int id) {
        return service.getProductById(id);
    }

    // PUT method to update a specific product by ID
    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable int id, @RequestBody Product product) {
        product.setId(id); // Ensure the ID in the path matches the ID in the body
        return service.updateProduct(product);
    }

    // DELETE method to delete a specific product by ID
    @DeleteMapping("/{id}")
    public Product deleteProduct(@PathVariable int id) {
        return service.deleteProduct(id);
    }
}

