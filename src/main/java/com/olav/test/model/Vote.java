package com.olav.test.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.Instant;

public class Vote {

    private VoteOption option;
    private Instant publishedAt;

    @JsonCreator
    public Vote(@JsonProperty("option") VoteOption option) {
        this.option = option;
        this.publishedAt = Instant.now();
    }

    public VoteOption getOption() {
        return this.option;
    }

    public Instant getPublishedAt() {
        return publishedAt;
    }

    public void setOption(VoteOption option) {
        this.option = option;
    }

    public void setPublishedAt(Instant publishedAt) {
        this.publishedAt = publishedAt;
    }

}