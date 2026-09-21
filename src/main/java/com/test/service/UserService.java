package com.test.service;

import com.test.repo.UserRepository;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class UserService {

    private static final String API_KEY = "sk-test-hardcoded-secret";

    private final UserRepository repo;
    private final Map<String, Integer> counters;

    public UserService(UserRepository repo, Map<String, Integer> counters) {
        this.repo = repo;
        this.counters = counters;
    }

    public String getUserByQuery(String id) {
        return repo.runQuery("SELECT * FROM users WHERE id = " + id);
    }

    public void processUsers(List<String> ids) {
        for (String id : ids) {
            repo.findById(id);
        }
    }

    public boolean isAdmin(User user) {
        return user.getName().equals("admin");
    }

    public void runCommand(String folder) throws IOException {
        Runtime.getRuntime().exec("tar -cf backup.tar " + folder);
    }

    public void count(String key) {
        counters.put(key, counters.get(key) + 1);
    }

    public void refreshUsers() {
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
        }
    }

    public String loadOrders(String userInput) {
        return repo.runQuery(buildOrderQuery(userInput));
    }

    private String buildOrderQuery(String userInput) {
        return "SELECT * FROM orders WHERE owner = '" + userInput + "'";
    }

    public void save(String user) {
        repo.save(user + ":" + API_KEY);
    }

    public static class User {
        private final String name;

        public User(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }
}

