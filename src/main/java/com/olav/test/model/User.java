package com.olav.test.model;

import com.olav.test.model.Vote;

import java.util.List;
import java.util.ArrayList;

public class User {

    private String username;
    private String email;
    private List<Vote> votes;

    public User(String username, String email, List<Vote> votes) {
        this.username = username;
        this.email = email;
        this.votes = votes;
    }

    public User() {
        votes = new ArrayList<>();
    }

    public String getUsername() {
        return this.username;
    }

    public String getEmail() {
        return this.email;
    }

    public List<Vote> getVotes() {
        return this.votes;
    }

    public void setVotes(List<Vote> votes) {
        this.votes = votes;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}