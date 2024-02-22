package com.isi.webtp1.repository;

import com.isi.webtp1.entity.Product;
import com.isi.webtp1.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    // User findByUsername(String name);
}
