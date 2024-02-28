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
    @Override
    public Product saveProduct(Product product) {
        return repository.save(product);
    }

    @Override
    public List<Product> saveProducts(List<Product> product) {
        return repository.saveAll(product);
    }

    // read operations
    @Override
    public List<Product> getProducts() {
        return repository.findAll();
    }

    @Override
    public Product getProductById(int id) {
        return repository.findById(id).orElse(null);
    }

//    public Product getProductByName(String name) {
//        return repository.findByName(name);
//    }

    // update operations
    @Override
    public Product updateProduct(Product product){
        Product e = repository.findById(product.getId()).orElse(null);
        e.setName(product.getName());
        e.setListedStatus(product.getListedStatus());
        e.setSoldStatus(product.getSoldStatus());
        e.setDescription(product.getDescription());
        e.setPrice(product.getPrice());
        e.setQuantity(product.getQuantity());
        e.setThumbnailImage(product.getThumbnailImage());
        e.setImageURLs(product.getImageURLs());
        return repository.save(e);
    }

    // delete operations
    @Override
    public Product deleteProduct(int id){
        Product e = repository.findById(id).orElse(null);
        repository.deleteById(id);
        return e;
    }
}
