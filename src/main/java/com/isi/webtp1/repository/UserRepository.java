package com.isi.webtp1.repository;

import com.isi.webtp1.dto.UserDto;
import com.isi.webtp1.entity.Product;
import com.isi.webtp1.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    @Query("SELECT new com.isi.webtp1.dto.UserDto(u.id, u.username, u.firstName, u.lastName) FROM User u")
    List<UserDto> findAllUsersWithoutPasswords();
}
