package com.second4.mychat;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;

public class Launch extends AppCompatActivity {
    Button bt;
    EditText et, pwd;
    FirebaseAuth mAuth;
    FirebaseAuth.AuthStateListener mAuthlistener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);
        bt = (Button) findViewById(R.id.bt);
        et = (EditText) findViewById(R.id.et);
        pwd = (EditText) findViewById(R.id.pwd);
        mAuth = FirebaseAuth.getInstance();
        mAuthlistener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {

                if (firebaseAuth.getCurrentUser() == null) {
                    Intent loginIntent = new Intent(Launch.this, Main22Activity.class);
                    loginIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(loginIntent);

                }

            }
        };
    }


    public void logIn(View v) {

    }

    public void signIn(View v) {
        String email = et.getText().toString();
        String password = pwd.getText().toString();

    }

    @Override
    protected void onStart() {
        super.onStart();
    }
}
