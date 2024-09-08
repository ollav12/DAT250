package com.olav.test.controller;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import com.olav.test.repository.PollManager;
import com.olav.test.model.User;
import com.olav.test.model.Vote;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/users")
public class VoteController {

    private final PollManager pollManager;

    @Autowired
    public VoteController(PollManager pollManager) {
        this.pollManager = pollManager;
    }

    /**
     * Retrive all votes for given username
     *
     * @param username
     * @return List of votes and a Http status code of value 200 (OK)
     */
    @GetMapping("/{username}/votes")
    public ResponseEntity<List<Vote>> getUserVotes(@PathVariable String username) {
        HashMap<String, User> users = pollManager.getUsers();
        if (users.containsKey(username)) {
            User user = users.get(username);
            List<Vote> votes = user.getVotes();
            return new ResponseEntity<>(votes, HttpStatusCode.valueOf(200));
        }
        return new ResponseEntity<>(HttpStatusCode.valueOf(400));

    }

    /**
     * Create a new vote given username and vote parameters in query
     *
     * @param username
     * @param vote
     * @return A new vote and a Http status code of value 201 (Succsessfully created a new resource)
     */
    @PostMapping("/{username}/votes")
    public ResponseEntity<Vote> createUserVote(@PathVariable String username, @RequestBody Vote vote) {
        HashMap<String, User> users = pollManager.getUsers();
        if (users.containsKey(username)) {
            User user = users.get(username);
            List<Vote> votes = user.getVotes();
            votes.add(vote);
            return new ResponseEntity<>(vote, HttpStatusCode.valueOf(201));
        }
        return new ResponseEntity<>(HttpStatusCode.valueOf(400));
    }

    /**
     *
     *
     * @param username
     * @param vote
     * @param id
     * @return
     */
    @PutMapping("/{username}/votes/{id}")
    public ResponseEntity<Vote> updateUserVote(@PathVariable String username, @RequestBody Vote vote, @PathVariable int id) {
        HashMap<String, User> users = pollManager.getUsers();
        if (users.containsKey(username)) {
            User user = users.get(username);
            List<Vote> votes = user.getVotes();
            votes.set(id, vote);
            return new ResponseEntity<>(vote, HttpStatusCode.valueOf(200));
        }
        return new ResponseEntity<>(HttpStatusCode.valueOf(400));
    }

    /**
     * Delete all votes for a given username
     *
     * @param username
     * @return A Http status code of value 204 (No Content)
     */
    @DeleteMapping("{username}/votes")
    public ResponseEntity deleteUserVotes(@PathVariable String username) {
        HashMap<String, User> users = pollManager.getUsers();
        if (users.containsKey(username)) {
            User user = users.get(username);
            List<Vote> votes = user.getVotes();
            if(!votes.isEmpty()) {
                votes.clear();
            }
            return new ResponseEntity(HttpStatusCode.valueOf(204));
        }
        return new ResponseEntity(HttpStatusCode.valueOf(400));
    }

    /**
     * Delete all votes
     *
     * @return A Http status code of value 204 (No Content)
     */
    @DeleteMapping("/votes")
    public ResponseEntity deleteAllVotes() {
        HashMap<String, User> users = pollManager.getUsers();
        for (User user : users.values()) {
            List<Vote> votes = user.getVotes();
            if(!votes.isEmpty()) {
                votes.clear();
            }
        }
        return new ResponseEntity(HttpStatusCode.valueOf(204));
    }

}