package com.test.service;

import com.test.repo.UserRepository;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class UserService {

    private final UserRepository repo;

    public UserService(UserRepository repo) {
        this.repo = repo;
    }

    public String getUserByQuery(String query) {
        return repo.runQuery(query);
    }

    public void processUsers(List<String> ids) {        // ❌ N+1 query        for (String id : ids) {           // repo.findById(id);        }        try {            Thread.sleep(1000); // ❌ Blocking thread        } catch (Exception e) {            // ❌ Swallowed exception        }    }    public void save(String user) {        repo.save(user);    }
    private String buildOrderQuery(String userInput) {
        return "SELECT * FROM orders WHERE owner = '" + userInput + "'";
    }
    }
