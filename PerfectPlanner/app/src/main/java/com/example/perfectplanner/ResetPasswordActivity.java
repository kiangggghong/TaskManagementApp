package com.example.perfectplanner;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ResetPasswordActivity extends AppCompatActivity {

    // Initialise Firebase Assets
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;

    private Toolbar mToolbar;

    private Button mResetButton;

    private TextInputLayout mEmailInputLayout;

    private TextInputEditText mEmailInput;

    private ProgressDialog mResetProgressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);
        setupToolbar();
        initialiseUI();
        initialiseFirebase();
    }

    @Override
    protected void onResume() {
        super.onResume();

        mAuthStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();

                if (user != null) {
                    // Switch screen to MainFriendActivity if a valid authenticated session is available
                    //Intent intent = new Intent(SignUpActivity.this, MainFriendActivity.class);
                    //intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    //startActivity(intent);
                    //finish();
                }
            }
        };

        mAuth.addAuthStateListener(mAuthStateListener);
    }

    @Override
    protected void onPause() {
        super.onPause();

        // Stop listening to auth state after activity pauses
        if (mAuthStateListener != null) {
            mAuth.removeAuthStateListener(mAuthStateListener);
        }
    }

    @Override
    protected void onStop() {
        super.onStop();

        // Stop listening to auth state after activity stops
        if (mAuthStateListener != null) {
            mAuth.removeAuthStateListener(mAuthStateListener);
        }
    }

    private void initialiseFirebase() {
        mAuth = FirebaseAuth.getInstance();
    }

    private void initialiseUI() {
        mEmailInputLayout = (TextInputLayout) findViewById(R.id.reset_email_layout);
        mEmailInput = (TextInputEditText) findViewById(R.id.reset_email);

        mResetButton = (Button) findViewById(R.id.reset_button);

        mResetProgressDialog = new ProgressDialog(this);
        mResetProgressDialog.setMessage(getString(R.string.progress_dialog_reset));
        mResetProgressDialog.setCancelable(false);
    }


    private void setupToolbar() {
        mToolbar = (Toolbar) findViewById(R.id.reset_toolbar);

        setSupportActionBar(mToolbar);
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        //mToolbar.setTitle("Forgot Password");
    }

    public void onResetPressed(View view) {
        mResetProgressDialog.show();
        mResetProgressDialog.setCancelable(false);
        resetPasswordWithEmail();
    }

    private void resetPasswordWithEmail() {
        String email = mEmailInput.getText().toString();

        mAuth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {
                    //RESET SUCCESS
                    mResetProgressDialog.hide();
                    Intent intent = new Intent(ResetPasswordActivity.this, SignInActivity.class);
                    //intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                } else {
                    //RESET FAILED
                    mResetProgressDialog.hide();
                    Toast.makeText(ResetPasswordActivity.this, "Reset Failed. Please try again later...", Toast.LENGTH_LONG).show();
                }

            }
        });
    }
}
