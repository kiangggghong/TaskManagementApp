package com.example.perfectplanner;

import android.app.Application;
import android.content.Context;

import com.google.firebase.database.FirebaseDatabase;

public class PerfectPlanner extends Application {

    @Override
    public void onCreate(){
        super.onCreate();

        // Enable disk persistence for Firebase
        FirebaseDatabase.getInstance().setPersistenceEnabled(true);
    }

}
