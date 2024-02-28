package com.isi.webtp1.service;

import com.isi.webtp1.dto.UserDto;
import com.isi.webtp1.entity.Product;
import com.isi.webtp1.entity.User;

import java.util.List;

public interface UserServiceIF {
    // create operations

    /**
     * Saves a new user.
     * @param user The user to be saved.
     * @return The saved user.
     */
    User saveUser(User user);

    /**
     * Saves a list of users.
     * @param users The list of users to be saved.
     * @return The saved users.
     */
    List<User> saveUsers(List<User> users);

    // read operations

    /**
     * Retrieves all users.
     * @return The list of all users.
     */
    List<User> getUsers();

    /**
     * Retrieves all users without their passwords.
     * @return The list of all users without passwords.
     */
    List<UserDto> findAllUsersWithoutPasswords();

    /**
     * Retrieves a user by their ID.
     * @param id The ID of the user to retrieve.
     * @return The user with the specified ID, or null if not found.
     */
    User getUserById(int id);

    // update operations

    /**
     * Updates an existing user.
     * @param user The updated user data.
     * @return The updated user.
     */
    User updateUser(User user);

    // delete operations

    /**
     * Deletes a user by their ID.
     * @param id The ID of the user to delete.
     * @return The deleted user, or null if not found.
     */
    User deleteUser(int id);

    /**
     * Adds products to a user.
     * @param userId The ID of the user to add products to.
     * @param products The list of products to add.
     * @return The list of added products.
     */
    List<Product> addProductsToUser(int userId, List<Product> products);
}