package com.example.pathaotechnicaltest.response;

public class CreateUserResponse extends BaseResponse{
    private String id;

    public CreateUserResponse() {
    }

    public CreateUserResponse(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
