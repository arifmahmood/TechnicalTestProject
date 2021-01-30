package com.example.pathaotechnicaltest.service;

import com.example.pathaotechnicaltest.model.UserData;
import com.example.pathaotechnicaltest.request.CreateUserRequest;
import com.example.pathaotechnicaltest.response.BaseResponse;
import com.example.pathaotechnicaltest.response.CreateUserResponse;
import com.example.pathaotechnicaltest.response.GetUserResponse;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Service
public class UserServiceImpl implements UserService {
    private final DbService dbService;

    public UserServiceImpl(DbService dbService) {
        this.dbService = dbService;
    }

    @Override
    public BaseResponse createUser(CreateUserRequest createUserRequest) throws ExecutionException, InterruptedException {
        UserData userData = new UserData(createUserRequest.getFirstName(), createUserRequest.getLastName(), createUserRequest.getPassword());

        String id = dbService.saveNewUser(userData);

        return new CreateUserResponse(id);
    }

    @Override
    public BaseResponse getUserById(String id) throws Exception {
        UserData userData = dbService.getUserById(id);
        if(userData == null){
            throw new Exception("Data not found");
        }
        GetUserResponse getUserResponse = new GetUserResponse(userData, id);
        return getUserResponse;
    }
}
