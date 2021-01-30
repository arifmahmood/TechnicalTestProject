package com.example.pathaotechnicaltest.service;


import com.example.pathaotechnicaltest.model.TagData;
import com.example.pathaotechnicaltest.model.UserData;
import com.example.pathaotechnicaltest.model.UserTagTime;
import com.example.pathaotechnicaltest.request.TagMappingRequest;
import com.example.pathaotechnicaltest.response.BaseResponse;
import com.example.pathaotechnicaltest.response.TagOfUserResponse;
import com.example.pathaotechnicaltest.response.UserTag;
import com.google.cloud.Timestamp;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.ExecutionException;

@Service
public class TagServiceImpl implements TagService{
    private DbService dbService;

    public TagServiceImpl(DbService dbService) {
        this.dbService = dbService;
    }

    @Override
    public BaseResponse mapTagWithUser(TagMappingRequest tagMappingRequest, String id) throws ExecutionException, InterruptedException {


        dbService.mapTagWithUser(tagMappingRequest, id);
        return new BaseResponse();
    }

    @Override
    public BaseResponse getUsersOfTag(ArrayList<String> tags) throws ExecutionException, InterruptedException {
        TagOfUserResponse tagOfUserResponse = new TagOfUserResponse();
        HashMap<String, UserTag> stringUserTagHashMap = new HashMap<>();

        HashMap<String , TagData> tagDataHashMap = dbService.getUsersOfTag(tags);

        for (String tag :
                tagDataHashMap.keySet()) {
            TagData tagData = tagDataHashMap.get(tag);
            for (String userId :
                    tagData.getUserTagTimes().keySet()) {
                if(stringUserTagHashMap.containsKey(userId)){
                    UserTag userTag = stringUserTagHashMap.get(userId);
                    userTag.getTags().add(tag);
                } else {
                    UserTagTime userTagTime = tagData.getUserTagTimes().get(userId);
                    UserData userData = userTagTime.getUser().get().get().toObject(UserData.class);
                    UserTag userTag = new UserTag(userData, userId);
                    userTag.getTags().add(tag);
                    stringUserTagHashMap.put(userId, userTag);
                }
            }

        }

        for (UserTag userTag:stringUserTagHashMap.values()
             ) {

            tagOfUserResponse.getUsers().add(userTag);
        }
        return tagOfUserResponse;
    }
}
