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

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;

public class SignUpActivity extends BaseActivity {

    // Initialise Firebase Assets
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;

    private Toolbar mToolbar;

    private Button mCreateButton;

    private TextInputLayout mEmailInputLayout;
    private TextInputLayout mPasswordInputLayout;

    private TextInputEditText mEmailInput;
    private TextInputEditText mPasswordInput;

    private ProgressDialog mAccountCreationProgressDialog;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
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
                    // Switch screen to RoamsActivity if a valid authenticated session is available
                    Intent intent = new Intent(SignUpActivity.this, MainFriendActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                    finish();
                }
            }
        };

        //mAuth.addAuthStateListener(mAuthStateListener);
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
        mEmailInputLayout = (TextInputLayout) findViewById(R.id.sign_up_email_layout);
        mEmailInput = (TextInputEditText) findViewById(R.id.sign_up_email);

        mPasswordInputLayout = (TextInputLayout) findViewById(R.id.sign_up_password_layout);
        mPasswordInput = (TextInputEditText) findViewById(R.id.sign_up_password);

        mCreateButton = (Button) findViewById(R.id.sign_up_button);

        mAccountCreationProgressDialog = new ProgressDialog(this);
        mAccountCreationProgressDialog.setMessage(getString(R.string.progress_dialog_creating_account));
        mAccountCreationProgressDialog.setCancelable(false);
    }


    private void setupToolbar() {
        mToolbar = (Toolbar) findViewById(R.id.sign_up_toolbar);

        setSupportActionBar(mToolbar);
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        mToolbar.setTitle("Sign Up");
    }

    public void onSignUpWithEmailPressed(View view) {
        signUpWithEmail();
    }

    private void signUpWithEmail() {
        String email = mEmailInput.getText().toString();
        String password = mPasswordInput.getText().toString();

        // Check for empty edit text fields before authentication
        if (email.equals("")) {
            mEmailInputLayout.setError(getString(R.string.error_empty_email));
            return;
        }

        if (password.equals("")) {
            mPasswordInputLayout.setError(getString(R.string.error_empty_password));
            return;
        }

        mAccountCreationProgressDialog.show();

        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (!task.isSuccessful()) {
                    // Sign Up FAILED
                    mAccountCreationProgressDialog.dismiss();
                } else {
                    // Sign Up SUCCESS
                    mAccountCreationProgressDialog.dismiss();
                    Intent intent = new Intent(SignUpActivity.this, SignInActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }
}
