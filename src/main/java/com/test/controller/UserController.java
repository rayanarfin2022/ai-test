package com.test.controller;

import com.test.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public String getUser(@PathVariable String id) {
        return service.getUserByQuery("SELECT * FROM users WHERE id=" + id);
    }

    @PostMapping
    public void createUser(@RequestBody String user) {

        // ❌ Logging sensitive data
        System.out.println("User data: " + user);

        service.save(user);
    }
}
