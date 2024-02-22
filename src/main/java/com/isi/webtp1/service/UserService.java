package com.isi.webtp1.service;

import com.isi.webtp1.entity.Product;
import com.isi.webtp1.entity.User;
import com.isi.webtp1.repository.ProductRepository;
import com.isi.webtp1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    @Autowired
    private ProductRepository p_repository;

    // create operations
    public User saveUser(User user) {
        return repository.save(user);
    }

    public List<User> saveUsers(List<User> users) {
        return repository.saveAll(users);
    }

    // read operations
    public List<User> getUsers() {
        return repository.findAll();
    }

    public User getUserById(int id) {
        return repository.findById(id).orElse(null);
    }

//    public User getUserByName(String name) {
//        return repository.findByUsername(name);
//    }

    // update operations
    public User updateUser(User user){
        User u = repository.findById(user.getId()).orElse(null);
        u.setProducts(user.getProducts());
        u.setUsername(user.getUsername());
        u.setPassword(user.getPassword());
        u.setFirstName(user.getFirstName());
        u.setLastName(user.getLastName());
        return repository.save(u);
    }

    // delete operations
    public User deleteUser(int id){
        User u = repository.findById(id).orElse(null);
        repository.deleteById(id);
        return u;
    }

    public List<Product> addProductsToUser(int userId, List<Product> products) {
        User user = repository.findById(userId).orElse(null);
        if (user != null) {
            for (Product product : products) {
                product.setUser(user); // Set the user for each product
                p_repository.save(product);
            }
            user.getProducts().addAll(products); // Add products to the user's list
            repository.save(user); // Save the user to update the association
            return products;
        }
        return new ArrayList<Product>();
    }
}
