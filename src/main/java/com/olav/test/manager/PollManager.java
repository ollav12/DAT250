package com.olav.test.repository;

import org.springframework.stereotype.Component;

import com.olav.test.model.User;
import com.olav.test.model.Poll;

import java.util.HashMap;

@Component
public class PollManager {

    private HashMap<String, User> users;
    private HashMap<Integer, Poll> polls;

    public PollManager(HashMap<String, User> users, HashMap<Integer, Poll> polls) {
        this.users = users;
        this.polls = polls;
    }

    public HashMap<Integer, Poll> getPolls() {
        return polls;
    }

    public void setPolls(HashMap<Integer, Poll> polls) {
        this.polls = polls;
    }

    public HashMap<String, User> getUsers() {
        return users;
    }

    public void setUsers(HashMap<String, User> users) {
        this.users = users;
    }

}