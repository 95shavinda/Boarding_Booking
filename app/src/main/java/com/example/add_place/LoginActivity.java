package com.example.add_place;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    EditText userEmail,userPass;
    Button btnLogin;
    TextView frgt,reg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        userEmail = findViewById(R.id.Emailedit);
        userPass = findViewById(R.id.Passworedit);
        btnLogin = findViewById(R.id.btnLogin);
        frgt = findViewById(R.id.txtfrgt);
        reg = findViewById(R.id.txtreg);

        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),Register.class));
            }
        });
    }
}
