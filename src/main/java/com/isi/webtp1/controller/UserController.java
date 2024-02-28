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

    @PostMapping // Create a new user
    public User createUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @GetMapping // Get all users
    public List<User> getAllUsers() {
        return userService.getUsers();
    }

    @GetMapping("public") // Get all users
    public List<UserDto> getPublicUserInfo() {
        return userService.findAllUsersWithoutPasswords();
    }


    @GetMapping("/{id}") // Get user by ID
    public User getUserById(@PathVariable int id) {
        return userService.getUserById(id);
    }

//    @GetMapping("/username/{name}") // Get user by username
//    public User getUserByName(@PathVariable String name) {
//        return userService.getUserByName(name);
//    }

    @PutMapping("/{id}") // Update user
    public User updateUser(@PathVariable int id, @RequestBody User user) {
        user.setId(id); // Ensure the ID in the path matches the ID in the body
        return userService.updateUser(user);
    }

    @DeleteMapping("/{id}") // Delete user by ID
    public User deleteUser(@PathVariable int id) {
        
        return userService.deleteUser(id);
    }

    @PostMapping("/{userId}/products") // Add products to a user
    public List<Product> addProductsToUser(@PathVariable int userId, @RequestBody List<Product> products) {
        return userService.addProductsToUser(userId, products);
    }
}
