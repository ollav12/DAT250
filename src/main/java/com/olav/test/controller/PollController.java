package com.olav.test.controller;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import com.olav.test.model.Poll;
import com.olav.test.manager.PollManager;

import java.util.HashMap;

@RestController
@RequestMapping("/polls")
@CrossOrigin(origins = "http://localhost:5173")
public class PollController {

    private final PollManager manager;
    private int id = 0;

    @Autowired
    public PollController(PollManager manager) {
        this.manager = manager;
    }

    /**
     * Retrieves all polls from the PolApp
     *
     * @return A ResponseEntity containing a HashMap of polls (if anay) with an HTTP
     *         status code of 200 (OK)
     */
    @GetMapping
    public ResponseEntity<HashMap<Integer, Poll>> getPolls() {
        HashMap<Integer, Poll> polls = manager.getPolls();
        return new ResponseEntity<>(polls, HttpStatusCode.valueOf(200));

    }

    /**
     * Creates a new poll given a poll arguments in a http query
     *
     * @param poll
     * @return A new Poll with a HTTP status code of 201 (Succsessfully created a
     *         new resource)
     */
    @PostMapping
    public ResponseEntity<Poll> createNewPoll(@RequestBody Poll poll) {

        HashMap<Integer, Poll> polls = manager.getPolls();

        if (poll != null) {
            polls.put(id, poll);
            id++;
            return new ResponseEntity<>(poll, HttpStatusCode.valueOf(201));
        }
        return new ResponseEntity<>(HttpStatusCode.valueOf(400));

    }

    /**
     * Updating an exisiting poll given an id
     *
     * @param poll
     * @param id
     * @return
     */
    @PutMapping("/{id}")
    public ResponseEntity<HashMap<Integer, Poll>> updatePoll(@RequestBody Poll poll, @PathVariable int id) {

        HashMap<Integer, Poll> polls = manager.getPolls();

        if (poll != null && polls.containsKey(id)) {
            polls.put(id, poll);
            return new ResponseEntity<>(polls, HttpStatusCode.valueOf(200));
        }
        return new ResponseEntity<>(HttpStatusCode.valueOf(400));

    }

    /**
     * Deletes all polls
     *
     * @return An empty HashMap for polls and a HTTP status code of 204 (No Content)
     */
    @DeleteMapping
    public ResponseEntity<HashMap<Integer, Poll>> deleteAllPolls() {
        HashMap<Integer, Poll> polls = manager.getPolls();
        polls.clear();
        id = 0;
        return new ResponseEntity<>(polls, HttpStatusCode.valueOf(204));
    }

    /**
     * Delete poll given id
     *
     * @param id
     * @return A HTTP status code of 204 (No Content)
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<HashMap<Integer, Poll>> deletePoll(@PathVariable int id) {
        if (id < 0 || id > this.id) {
            return new ResponseEntity<>(HttpStatusCode.valueOf(400));
        }
        HashMap<Integer, Poll> polls = manager.getPolls();
        polls.remove(id);
        return new ResponseEntity<>(HttpStatusCode.valueOf(204));
    }

}
