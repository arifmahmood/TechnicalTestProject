package com.example.pathaotechnicaltest.service;


import com.example.pathaotechnicaltest.model.TagData;
import com.example.pathaotechnicaltest.model.UserData;
import com.example.pathaotechnicaltest.request.TagMappingRequest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ExecutionException;

public interface DbService {
    String saveNewUser(UserData userData) throws ExecutionException, InterruptedException;

    UserData getUserById(String id) throws ExecutionException, InterruptedException;

    void mapTagWithUser(TagMappingRequest tagMappingRequest, String id) throws ExecutionException, InterruptedException;

    HashMap<String, TagData> getUsersOfTag(ArrayList<String> tags) throws ExecutionException, InterruptedException;
}
