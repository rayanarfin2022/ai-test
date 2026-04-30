package com.test.model;

import jakarta.persistence.*;

@Entity
public class User {

    @Id
    private Long id;

    // ❌ No index / validation
    private String email;

    // ❌ No constraints
    private String password;
}