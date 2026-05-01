package com.test.repo;


public class UserRepository {

    public String runQuery(String query) {
         //❌ Direct dynamic query
        return "executed: " + query;

    }

    public String findById(String id) {
        return "user-" + id;
    }

    public void save(String user) {
        // dummy
    }
}