package com.demo.api.FirebaseDatabase.service;

import java.io.FileInputStream;
import java.util.concurrent.ExecutionException;

import javax.annotation.PostConstruct;

import com.demo.api.FirebaseDatabase.entity.User;
import com.google.api.core.ApiFuture;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;

import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

@Service
public class FirebaseDatabaseService {

    public static final String COL_NAME="users";

    public String createUser(User user) throws InterruptedException, ExecutionException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        dbFirestore.collection(COL_NAME)
                .document(user.getId()).set(user);
        return "Create User Success";
    }

    public User getUserData(String id) throws InterruptedException, ExecutionException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        DocumentReference documentReference = dbFirestore.collection(COL_NAME).document(id);
        ApiFuture<DocumentSnapshot> future = documentReference.get();

        DocumentSnapshot document = future.get();

        User user = null;

        if(document.exists()) {
            user = document.toObject(User.class);
            return user;
        }else {
            return null;
        }
    }

    public String updateUser(User user) throws InterruptedException, ExecutionException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        dbFirestore.collection(COL_NAME).document(user.getId()).set(user);
        return "Update User Success";
    }

    public String deleteUser(String id) {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        dbFirestore.collection(COL_NAME).document(id).delete();
        return "Document with User ID "+id+" has been deleted";
    }

    @PostConstruct
    public void initialize() {
        try {
            FileInputStream serviceAccount =
                    new FileInputStream(ResourceUtils.getFile("classpath:training--api-firebase-adminsdk-g2hek-fa282b732b.json"));

            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .setDatabaseUrl("https://training--api.firebaseio.com/")
                    .build();

            FirebaseApp.initializeApp(options);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
