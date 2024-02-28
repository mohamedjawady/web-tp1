package com.isi.webtp1.service;

import com.isi.webtp1.dto.UserDto;
import com.isi.webtp1.entity.Product;
import com.isi.webtp1.entity.User;
import com.isi.webtp1.repository.ProductRepository;
import com.isi.webtp1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements UserServiceIF {

    @Autowired
    private UserRepository repository;

    @Autowired
    private ProductRepository p_repository;

    // create operations

    /**
     * Saves a new user.
     * @param user The user to be saved.
     * @return The saved user.
     */
    @Override
    public User saveUser(User user) {
        return repository.save(user);
    }

    /**
     * Saves a list of users.
     * @param users The list of users to be saved.
     * @return The saved users.
     */
    @Override
    public List<User> saveUsers(List<User> users) {
        return repository.saveAll(users);
    }

    // read operations

    /**
     * Retrieves all users.
     * @return The list of all users.
     */
    @Override
    public List<User> getUsers() {
        return repository.findAll();
    }

    /**
     * Retrieves all users without their passwords.
     * @return The list of all users without passwords.
     */
    public List<UserDto> findAllUsersWithoutPasswords() {
        return repository.findAllUsersWithoutPasswords();
    }

    /**
     * Retrieves a user by their ID.
     * @param id The ID of the user to retrieve.
     * @return The user with the specified ID, or null if not found.
     */
    @Override
    public User getUserById(int id) {
        return repository.findById(id).orElse(null);
    }

    // update operations

    /**
     * Updates an existing user.
     * @param user The updated user data.
     * @return The updated user.
     */
    @Override
    public User updateUser(User user) {
        User u = repository.findById(user.getId()).orElse(null);
        u.setProducts(user.getProducts());
        u.setBio(user.getBio());
        u.setProfileImage(user.getProfileImage());
        u.setUsername(user.getUsername());
        u.setPassword(user.getPassword());
        u.setFirstName(user.getFirstName());
        u.setLastName(user.getLastName());
        return repository.save(u);
    }

    // delete operations

    /**
     * Deletes a user by their ID.
     * @param id The ID of the user to delete.
     * @return The deleted user, or null if not found.
     */
    @Override
    public User deleteUser(int id) {
        User u = repository.findById(id).orElse(null);

        // cascading deletion
        for (Product p : u.getProducts()) {
            p_repository.deleteById(p.getId());
        }

        repository.deleteById(id);
        return u;
    }

    /**
     * Adds products to a user.
     * @param userId The ID of the user to add products to.
     * @param products The list of products to add.
     * @return The list of added products.
     */
    @Override
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
        return new ArrayList<>();
    }
}
