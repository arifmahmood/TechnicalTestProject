package com.example.pathaotechnicaltest.service;

import com.example.pathaotechnicaltest.request.CreateUserRequest;
import com.example.pathaotechnicaltest.response.BaseResponse;
import com.example.pathaotechnicaltest.response.CreateUserResponse;

import java.util.concurrent.ExecutionException;

public interface UserService {
    BaseResponse createUser(CreateUserRequest createUserRequest) throws ExecutionException, InterruptedException;

    BaseResponse getUserById(String id) throws Exception;
}
