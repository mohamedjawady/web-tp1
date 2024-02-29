package com.isi.webtp1.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "USER")
public class User {
    @Id
    @GeneratedValue
    private int id;
    private String username;
    private String password;
    private String bio;
    private String profileImage;
    private String firstName;
    private String lastName;

    // primary contacts are of index 0
    @ElementCollection
    private List<String> emails;
    @ElementCollection
    private List<String> phoneNumbers;
//    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
@OneToMany(mappedBy = "user")
@JsonManagedReference
    private List<Product> products = new ArrayList<>();

}
