package com.example.pathaotechnicaltest.request;

import com.sun.media.sound.InvalidDataException;

public class CreateUserRequest  extends BaseRequestModel{
    private String firstName;
    private String lastName;
    private String password;

    public CreateUserRequest() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public void validate() throws InvalidDataException {
        if(firstName == null || lastName== null || password== null){
            throw new InvalidDataException();
        }
    }
}
