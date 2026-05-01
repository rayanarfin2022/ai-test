package com.test.repo;


public class UserRepository {

    public String runQuery(String query) {
        // ❌ Direct dynamic query
        return "executed: " + query;
       // return  null;
    }

    public String findById(String id) {
        return null;
                //"user-" + id;
    }

    public void save(String user) {
        // dummy
    }
}