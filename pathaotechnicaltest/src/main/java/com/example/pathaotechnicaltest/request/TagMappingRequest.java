package com.example.pathaotechnicaltest.request;

import com.sun.media.sound.InvalidDataException;

import java.util.ArrayList;

public class TagMappingRequest extends BaseRequestModel{
    private ArrayList<String> tags;
    private long expiry;


    public TagMappingRequest() {
    }

    public ArrayList<String> getTags() {
        return tags;
    }

    public void setTags(ArrayList<String> tags) {
        this.tags = tags;
    }

    public long getExpiry() {
        return expiry;
    }

    public void setExpiry(long expiry) {
        this.expiry = expiry;
    }

    @Override
    public void validate() throws InvalidDataException {

    }
}
