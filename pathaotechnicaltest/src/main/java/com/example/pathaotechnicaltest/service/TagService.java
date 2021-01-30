package com.example.pathaotechnicaltest.service;

import com.example.pathaotechnicaltest.request.TagMappingRequest;
import com.example.pathaotechnicaltest.response.BaseResponse;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public interface TagService {
    BaseResponse mapTagWithUser(TagMappingRequest tagMappingRequest, String id) throws ExecutionException, InterruptedException;

    BaseResponse getUsersOfTag(ArrayList<String> tags) throws ExecutionException, InterruptedException;
}
