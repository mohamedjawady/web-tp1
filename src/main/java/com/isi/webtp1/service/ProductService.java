package com.isi.webtp1.service;

import com.isi.webtp1.entity.Product;
import com.isi.webtp1.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements ProductServiceIF {

    @Autowired
    private ProductRepository repository;

    // create operations

    /**
     * Saves a new product.
     * @param product The product to be saved.
     * @return The saved product.
     */
    @Override
    public Product saveProduct(Product product) {
        return repository.save(product);
    }

    /**
     * Saves a list of products.
     * @param products The list of products to be saved.
     * @return The saved products.
     */
    @Override
    public List<Product> saveProducts(List<Product> products) {
        return repository.saveAll(products);
    }

    // read operations

    /**
     * Retrieves all products.
     * @return The list of all products.
     */
    @Override
    public List<Product> getProducts() {
        return repository.findAll();
    }

    /**
     * Retrieves products within a specific price range.
     * @param min The minimum price.
     * @param max The maximum price.
     * @return The list of products within the specified price range.
     */
    public List<Product> getProductsByPrice(double min, double max) {
        return repository.findByPriceBetween(min, max);
    }

    /**
     * Retrieves a product by its ID.
     * @param id The ID of the product to retrieve.
     * @return The product with the specified ID, or null if not found.
     */
    @Override
    public Product getProductById(int id) {
        return repository.findById(id).orElse(null);
    }

    // update operations

    /**
     * Updates an existing product.
     * @param product The updated product data.
     * @return The updated product.
     */
    @Override
    public Product updateProduct(Product product) {
        Product existingProduct = repository.findById(product.getId()).orElse(null);
        if (existingProduct != null) {
            // Update the fields of the existing product
            existingProduct.setName(product.getName());
            existingProduct.setListedStatus(product.getListedStatus());
            existingProduct.setSoldStatus(product.getSoldStatus());
            existingProduct.setDescription(product.getDescription());
            existingProduct.setPrice(product.getPrice());
            existingProduct.setQuantity(product.getQuantity());
            existingProduct.setThumbnailImage(product.getThumbnailImage());
            existingProduct.setImageURLs(product.getImageURLs());
            // Save and return the updated product
            return repository.save(existingProduct);
        }
        return null; // Product not found
    }

    // delete operations

    /**
     * Deletes a product by its ID.
     * @param id The ID of the product to delete.
     * @return The deleted product, or null if not found.
     */
    @Override
    public Product deleteProduct(int id) {
        Product product = repository.findById(id).orElse(null);
        if (product != null) {
            repository.deleteById(id);
        }
        return product;
    }
}
