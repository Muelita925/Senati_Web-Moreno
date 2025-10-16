package com.senati.senati_web_moreno.controller;

import com.senati.senati_web_moreno.model.Response;
import com.senati.senati_web_moreno.model.User;
import com.senati.senati_web_moreno.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/api/users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("/api/user")
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @DeleteMapping("/api/user/{id}")
    public Response deleteUser(@PathVariable int id) {
        return userService.deleteUser(id);
    }
    /*public void deleteUser(@PathVariable("id") Integer id) {
        userService.deleteUser(id);*/


    @PutMapping("/api/user/{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") Integer id, @RequestBody User user) {
        return userService.updateUser(id, user);
    }
}
