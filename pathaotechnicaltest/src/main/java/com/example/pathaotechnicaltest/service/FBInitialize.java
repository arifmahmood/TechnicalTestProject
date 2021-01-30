package com.example.pathaotechnicaltest.service;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.FileInputStream;

@Service
public class FBInitialize {
    @PostConstruct
    public void initialize() {
        try {
            File file = ResourceUtils.getFile("classpath:pathaotechnicaltest-firebase-adminsdk-rijea-bd42125785.json");

            FileInputStream serviceAccount = new FileInputStream(file);
            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .setDatabaseUrl("https://chatapp-e6e15.firebaseio.com")
                    .build();
            FirebaseApp.initializeApp(options);
        } catch (Exception e) {
            e.printStackTrace();
        }}}