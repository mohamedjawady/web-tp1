package com.isi.webtp1.service;

import com.isi.webtp1.entity.Product;
import com.isi.webtp1.entity.User;

import java.util.List;

public interface UserServiceIF {
    // create operations
    User saveUser(User user);

    List<User> saveUsers(List<User> users);

    // read operations
    List<User> getUsers();

    User getUserById(int id);

    // update operations
    User updateUser(User user);

    // delete operations
    User deleteUser(int id);

    List<Product> addProductsToUser(int userId, List<Product> products);
}
