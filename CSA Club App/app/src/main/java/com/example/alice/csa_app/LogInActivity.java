package com.example.alice.csa_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LogInActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        final EditText usernameView = findViewById(R.id.Username);
        final EditText passwordView = findViewById(R.id.Password);
        final TextView incorrectText = findViewById(R.id.IncorrectText);
        incorrectText.setVisibility(View.INVISIBLE);

        Button loginB = findViewById(R.id.LoginButton);

        loginB.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                String correctUsername = "admin";
                String correctPW = "hi";

                String username = usernameView.getText().toString();
                String password = passwordView.getText().toString();

                if ((username.equals(correctUsername)) && (password.equals(correctPW))) {
                    Intent i = new Intent(LogInActivity.this, MainAdmin.class);
                    i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    i.putExtra("admin", true);
                    startActivity(i);
                }
                else {
                    incorrectText.setVisibility(View.VISIBLE);
                }
            }
        });
    }
}
