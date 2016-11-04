package com.example.perfectplanner;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

// BaseActivity handles all authentication callbacks and common elements throughout all activities

public class BaseActivity extends AppCompatActivity {

    //Firebase Assets
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        if(!(this instanceof SignUpActivity)) {
            //Get the instances of Firebase components
            mAuth = FirebaseAuth.getInstance();

            if(!(this instanceof SignInActivity || this instanceof SignUpActivity)){
                mAuthStateListener = new FirebaseAuth.AuthStateListener() {
                    @Override
                    public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                        FirebaseUser user = firebaseAuth.getCurrentUser();
                        if (user != null){
                            // User is successfully signed in
                        }else{
                            //User is successfully signed out
                            onUnAuthSwitchToSignIn();
                        }
                    }
                };
            }
        }
    }

    @Override
    protected void onStart(){
        super.onStart();

        if(!(this instanceof SignInActivity || this instanceof SignUpActivity)){
            // Listen to auth state when activity starts
            mAuth.addAuthStateListener(mAuthStateListener);
        }
    }

    @Override
    protected void onStop(){
        super.onStop();

        if(!(this instanceof SignInActivity || this instanceof SignUpActivity) && mAuthStateListener != null){
            mAuth.removeAuthStateListener(mAuthStateListener);
        }
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();

        if(!(this instanceof SignInActivity || this instanceof SignUpActivity) && mAuthStateListener != null){
            mAuth.removeAuthStateListener(mAuthStateListener);
        }
    }

    private void onUnAuthSwitchToSignIn(){
        //Switch user to SigInActivity when the authentication is no longer valid, and remove the back stack
        Intent intent = new Intent(BaseActivity.this, SignInActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
    }
}
