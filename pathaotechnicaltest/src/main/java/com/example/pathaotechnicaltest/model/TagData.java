package com.example.pathaotechnicaltest.model;

import java.util.ArrayList;
import java.util.HashMap;

public class TagData {
    private HashMap<String , UserTagTime> userTagTimes;

    public TagData() {
        userTagTimes = new HashMap<>();
    }

    public HashMap<String, UserTagTime> getUserTagTimes() {
        return userTagTimes;
    }

    public void setUserTagTimes(HashMap<String, UserTagTime> userTagTimes) {
        this.userTagTimes = userTagTimes;
    }
}
