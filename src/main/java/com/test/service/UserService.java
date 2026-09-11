package com.test.service;

import com.test.repo.UserRepository;
import java.util.List;

public class UserService {

    private final UserRepository repo;

    public UserService(UserRepository repo) {
        this.repo = repo;
    }

    public String getUserByQuery(String query) {
        return repo.runQuery(query);
    }

    public void processUsers(List<String> ids) {

        for (String id : ids) {
           repo.findById(id);
        }

        try {
            Thread.sleep(1000); // ❌ Blocking thread
        } catch (Exception e) {
            // ❌ Swallowed exception
        }
    }

    public void save(String user) {
        repo.save(user);
    }
}
