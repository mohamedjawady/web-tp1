package com.isi.webtp1.service;

import com.isi.webtp1.entity.Product;

import java.util.List;

public interface ProductServiceIF {
    // create operations

    /**
     * Saves a new product.
     * @param product The product to be saved.
     * @return The saved product.
     */
    Product saveProduct(Product product);

    /**
     * Saves a list of products.
     * @param products The list of products to be saved.
     * @return The saved products.
     */
    List<Product> saveProducts(List<Product> products);

    /**
     * Retrieves products within a specific price range.
     * @param min The minimum price.
     * @param max The maximum price.
     * @return The list of products within the specified price range.
     */
    List<Product> getProductsByPrice(double min, double max);

    // read operations

    /**
     * Retrieves all products.
     * @return The list of all products.
     */
    List<Product> getProducts();

    /**
     * Retrieves a product by its ID.
     * @param id The ID of the product to retrieve.
     * @return The product with the specified ID, or null if not found.
     */
    Product getProductById(int id);

    // update operations

    /**
     * Updates an existing product.
     * @param product The updated product data.
     * @return The updated product.
     */
    Product updateProduct(Product product);

    // delete operations

    /**
     * Deletes a product by its ID.
     * @param id The ID of the product to delete.
     * @return The deleted product, or null if not found.
     */
    Product deleteProduct(int id);
}
