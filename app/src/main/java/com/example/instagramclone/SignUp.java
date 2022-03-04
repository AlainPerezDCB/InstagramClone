package com.example.instagramclone;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class SignUp extends AppCompatActivity {

    private static final String TAG = "SignUp";
    private Button btnSignUpFinal;
    private EditText username;
    private EditText pasw;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_activity);

        btnSignUpFinal = findViewById(R.id.btnSignUpFinal);
        username = findViewById(R.id.tfUsername);
        pasw = findViewById(R.id.tfPassword);

        btnSignUpFinal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ParseUser user = new ParseUser();

                user.setUsername(username.getText().toString());
                user.setPassword(pasw.getText().toString());
                user.signUpInBackground(new SignUpCallback() {
                    public void done(ParseException e) {
                        if (e == null) {
                            goMainActivity();
                        } else {
//                            Toast.makeText(SignUp.this, "Error Signing up", Toast.LENGTH_SHORT).show();
                            Log.e(TAG, "Something went wrong when signing up", e);
                        }
                    }
             });

         }
    });
    }

    private void goMainActivity(){
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
        finish();
    }
}

