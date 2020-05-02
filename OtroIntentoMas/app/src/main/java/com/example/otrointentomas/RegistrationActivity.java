package com.example.otrointentomas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.androidnetworking.AndroidNetworking;

public class RegistrationActivity extends AppCompatActivity {

    private EditText name, email, phone, password;
    private Button registrate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        AndroidNetworking.initialize(getApplicationContext());
        name = (EditText) findViewById(R.id.nombreRegistration);
        email = (EditText) findViewById(R.id.emailRegistration);
        phone = (EditText) findViewById(R.id.phoneRegistration);
        password = (EditText) findViewById(R.id.passwordRegistration);

        registrate = (Button) findViewById(R.id.buttonRegistration);

        registrate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(name.getText().toString(), email.getText().toString(), phone.getText().toString(), password.getText().toString());
            }
        });
    }

    private void validate(String username, String email, String phoneNumber, String password) {
        if (true) {
            AndroidNetworking.post("http://localhost:8080/registerUser")
                    .addBodyParameter("username", username)
                    .addBodyParameter("email", email)
                    .addBodyParameter("phonenumber", phoneNumber)
                    .addBodyParameter("password", password)
                    .build();

            Intent intent = new Intent(RegistrationActivity.this, FourthActivity.class);
            startActivity(intent);
        }
    }
}
r