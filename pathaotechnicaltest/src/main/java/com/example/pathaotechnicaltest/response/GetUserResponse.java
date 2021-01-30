package com.example.pathaotechnicaltest.response;

import com.example.pathaotechnicaltest.model.UserData;

public class GetUserResponse extends BaseResponse {
    private String id;
    private String name;

    public GetUserResponse(UserData userData, String id) {
        this.id = id;
        this.name = userData.getFirstName()+' '+userData.getLastName();
    }

    public GetUserResponse(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public GetUserResponse(UserData userData) {
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
