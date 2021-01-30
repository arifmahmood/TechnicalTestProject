package com.example.pathaotechnicaltest.response;

import java.util.ArrayList;

public class TagOfUserResponse extends BaseResponse {
    private ArrayList<UserTag> users;

    public TagOfUserResponse() {
        users = new ArrayList<>();
    }

    public ArrayList<UserTag> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<UserTag> users) {
        this.users = users;
    }
}
