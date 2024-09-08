package com.olav.test.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class VoteOption {

    private String caption;
    private int presentationOrder = 0;

    @JsonCreator
    public VoteOption(@JsonProperty("caption") String caption) {
        this.caption = caption;
        this.presentationOrder++;
    }

    public VoteOption() {
    }

    public String getCaption() {
        return caption;
    }

    public int getPresentationOrder() {
        return presentationOrder;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public void setPresentationOrder(int presentationOrder) {
        this.presentationOrder = presentationOrder;
    }

}