package com.example.pathaotechnicaltest.response;

import com.example.pathaotechnicaltest.model.UserData;

import java.util.ArrayList;

public class UserTag  {
    private String id;
    private String name;
    private ArrayList<String> tags;


    public ArrayList<String> getTags() {
        return tags;
    }

    public void setTags(ArrayList<String> tags) {
        this.tags = tags;
    }

    public UserTag(UserData userData, String id) {
        this.id = id;
        this.name = userData.getFirstName()+' '+userData.getLastName();
        tags = new ArrayList<>();
    }

    public UserTag(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public UserTag(UserData userData) {
//        id= userData.

    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
