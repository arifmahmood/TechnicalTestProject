package com.example.pathaotechnicaltest.service;


import com.example.pathaotechnicaltest.model.TagData;
import com.example.pathaotechnicaltest.model.UserData;
import com.example.pathaotechnicaltest.model.UserTagTime;
import com.example.pathaotechnicaltest.request.TagMappingRequest;
import com.google.api.core.ApiFuture;
import com.google.cloud.Timestamp;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ExecutionException;

@Service
public class DbServiceFirebaseImpl implements DbService {
    @Override
    public String saveNewUser(UserData userData) throws ExecutionException, InterruptedException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<DocumentReference> collectionsApiFuture = dbFirestore.collection("USERS").add(userData);
        return collectionsApiFuture.get().getId();
    }

    @Override
    public UserData getUserById(String id) throws ExecutionException, InterruptedException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        DocumentReference documentReference = dbFirestore.collection("USERS").document(id);
        ApiFuture<DocumentSnapshot> future = documentReference.get();
        DocumentSnapshot document = future.get();
        UserData userData = null;
        if(document.exists()) {
            userData = document.toObject(UserData.class);
        }
        return userData;
    }

    @Override
    public void mapTagWithUser(TagMappingRequest tagMappingRequest, String id) throws ExecutionException, InterruptedException {

        Firestore dbFirestore = FirestoreClient.getFirestore();
        DocumentReference userReference = dbFirestore.collection("USERS").document(id);


        for (String tag : tagMappingRequest.getTags()) {

            DocumentReference tagReference =dbFirestore.collection("TAGS").document(tag);
            ApiFuture<DocumentSnapshot> future = tagReference.get();
            DocumentSnapshot documentSnapshot = future.get();
            TagData tagData;
            if(documentSnapshot.exists()){
                tagData = documentSnapshot.toObject(TagData.class);
                tagData.getUserTagTimes().put(id, new UserTagTime(userReference,
                        Timestamp.ofTimeMicroseconds((System.currentTimeMillis()+tagMappingRequest.getExpiry())*1000)));

            } else{

                tagData = new TagData();
                tagData.getUserTagTimes().put(id, new UserTagTime(userReference,
                        Timestamp.ofTimeMicroseconds((System.currentTimeMillis()+tagMappingRequest.getExpiry())*1000)));

            }


            ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection("TAGS").document(tag).set(tagData);
        }



        return;
    }

    @Override
    public HashMap<String, TagData> getUsersOfTag(ArrayList<String> tags) throws ExecutionException, InterruptedException {
        Firestore dbFirestore = FirestoreClient.getFirestore();

        HashMap<String, TagData> tagDataHashMap = new HashMap<>();
        for (String tag :
                tags) {
            DocumentReference documentReference = dbFirestore.collection("TAGS").document(tag);
            ApiFuture<DocumentSnapshot> future = documentReference.get();
            DocumentSnapshot document = future.get();
            TagData tagData = null;
            if(document.exists()) {
                tagData = document.toObject(TagData.class);
                tagDataHashMap.put(tag, tagData);
            }
        }
        return tagDataHashMap;

    }
}
