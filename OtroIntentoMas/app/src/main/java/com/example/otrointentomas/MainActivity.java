package com.example.otrointentomas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText name;
    private EditText password;
    private Button login;
    private TextView text;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = (EditText) findViewById(R.id.NombreLogin);
        password = (EditText) findViewById(R.id.PasswordLogin);
        login = (Button) findViewById(R.id.Btn_Login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(name.getText().toString(), password.getText().toString());
            }
        });
    }

    private void validate (String username, String password){
        if((username.equals("Admin")) && (password.equals("1234"))){
            Intent intento = new Intent(MainActivity.this, SecondActivity.class);
            startActivity(intento);
        }
    }
}
