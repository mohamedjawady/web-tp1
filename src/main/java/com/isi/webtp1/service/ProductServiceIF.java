package com.isi.webtp1.service;

import com.isi.webtp1.entity.Product;

import java.util.List;

public interface ProductServiceIF {
    // create operations
    Product saveProduct(Product product);

    List<Product> saveProducts(List<Product> product);

    // read operations
    List<Product> getProducts();

    Product getProductById(int id);

    // update operations
    Product updateProduct(Product product);

    // delete operations
    Product deleteProduct(int id);
}
