package com.isi.webtp1.controller;

import com.isi.webtp1.dto.UserDto;
import com.isi.webtp1.entity.Product;
import com.isi.webtp1.entity.User;
import com.isi.webtp1.service.UserServiceIF;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users") // Base mapping for all user-related endpoints
public class UserController {

    @Autowired
    private UserServiceIF userService;

    // POST method to create a new user
    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    // GET method to retrieve all users
    @GetMapping
    public List<User> getAllUsers() {
        return userService.getUsers();
    }

    // GET method to retrieve public user information without passwords
    @GetMapping("public")
    public List<UserDto> getPublicUserInfo() {
        return userService.findAllUsersWithoutPasswords();
    }

    // GET method to retrieve a specific user by ID
    @GetMapping("/{id}")
    public User getUserById(@PathVariable int id) {
        return userService.getUserById(id);
    }

    // PUT method to update a specific user by ID
    @PutMapping("/{id}")
    public User updateUser(@PathVariable int id, @RequestBody User user) {
        user.setId(id); // Ensure the ID in the path matches the ID in the body
        return userService.updateUser(user);
    }

    // DELETE method to delete a specific user by ID
    @DeleteMapping("/{id}")
    public User deleteUser(@PathVariable int id) {
        return userService.deleteUser(id);
    }

    // POST method to add products to a user
    @PostMapping("/{userId}/products")
    public List<Product> addProductsToUser(@PathVariable int userId, @RequestBody List<Product> products) {
        return userService.addProductsToUser(userId, products);
    }
}

