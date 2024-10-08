package com.olav.test.controller;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import com.olav.test.model.User;
import com.olav.test.manager.PollManager;

import java.util.HashMap;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "http://localhost:5173")
public class UserController {

    private final PollManager pollManager;

    @Autowired
    public UserController(PollManager pollManager) {
        this.pollManager = pollManager;
    }

    /**
     * Retrieves all users from the PollApp
     *
     * @return A ResponseEntity containing a HashMap of users (if anay) with an HTTP
     *         status code of 200 (OK)
     */
    @GetMapping
    public ResponseEntity<HashMap<String, User>> getUsers() {
        HashMap<String, User> users = pollManager.getUsers();
        return new ResponseEntity<>(users, HttpStatusCode.valueOf(200));
    }

    /**
     * Creates a new user given a user arguments in a http query
     *
     * @param user
     * @return A new User with a HTTP status code of 201 (Succsessfully created a
     *         new resource)
     */
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        HashMap<String, User> users = pollManager.getUsers();
        String username = user.getUsername();
        if (users.containsKey(username)) {
            return new ResponseEntity<>(HttpStatusCode.valueOf(409));
        }
        users.put(username, user);
        return new ResponseEntity<>(user, HttpStatusCode.valueOf(201));
    }

    /**
     * Updates a user given the username
     *
     * @param user
     * @param username
     * @return An updated user and a HTTP status code of value 200 (OK)
     */
    @PutMapping("/{username}")
    public ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable String username) {

        HashMap<String, User> users = pollManager.getUsers();
        if (user != null && users.containsKey(username)) {
            users.put(username, user);
            return new ResponseEntity<>(HttpStatusCode.valueOf(200));
        }
        return new ResponseEntity<>(user, HttpStatusCode.valueOf(400));

    }

    /**
     * Deletes user with given username
     *
     * @param username
     * @return Http status code of value 204 (No content)
     */
    @DeleteMapping("/{username}")
    public ResponseEntity deleteUser(@PathVariable String username) {
        HashMap<String, User> users = pollManager.getUsers();
        if (users.containsKey(username)) {
            users.remove(username);
            return new ResponseEntity<>(HttpStatusCode.valueOf(204));
        }
        return new ResponseEntity<>(HttpStatusCode.valueOf(400));
    }

    /**
     * Delete all users
     *
     * @return A Http status code of value 204 (No Content)
     */
    @DeleteMapping
    public ResponseEntity<String> deleteAllUsers() {
        HashMap<String, User> users = pollManager.getUsers();
        if (!users.isEmpty()) {
            users.clear();
        }
        return new ResponseEntity<>(HttpStatusCode.valueOf(204));
    }

}