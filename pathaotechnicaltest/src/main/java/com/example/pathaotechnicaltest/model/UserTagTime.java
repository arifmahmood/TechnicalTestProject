package com.example.pathaotechnicaltest.model;

import com.google.cloud.Timestamp;
import com.google.cloud.firestore.DocumentReference;

public class UserTagTime {
    private DocumentReference user;
    private Timestamp expiryTime;

    public UserTagTime() {
    }

    public UserTagTime(Timestamp expiryTime) {
        this.expiryTime = expiryTime;
    }

    public UserTagTime(DocumentReference user, Timestamp expiryTime) {
        this.user = user;
        this.expiryTime = expiryTime;
    }

    public DocumentReference getUser() {
        return user;
    }

    public void setUser(DocumentReference user) {
        this.user = user;
    }

    public Timestamp getExpiryTime() {
        return expiryTime;
    }

    public void setExpiryTime(Timestamp expiryTime) {
        this.expiryTime = expiryTime;
    }
}
