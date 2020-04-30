package com.example.add_place;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity {
    DatabaseHelper db;
    EditText ed1,ed2,ed3;
    Button btnR;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        ed1 = (EditText) findViewById(R.id.editEmail);
        ed2 = (EditText) findViewById(R.id.editPassword);
        ed3 = (EditText) findViewById(R.id.editConfirmPass);
        btnR = (Button) findViewById(R.id.btnRegister);

        btnR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String st1 = ed1.getText().toString();
                String st2 = ed2.getText().toString();
                String st3 = ed3.getText().toString();
                if(st1.equals("")||st2.equals("")||st3.equals("")){
                    Toast.makeText(getApplicationContext(),"Fields are empty",Toast.LENGTH_SHORT).show();
                }
                else {
                    if(st2.equals(st3)){
                        Boolean checkMail = db.chkmail(st1);
                        if(checkMail == true){
                            Boolean insert = db.insert(st1,st2);
                            if(insert == true){
                                Toast.makeText(getApplicationContext(),"Registered Successfully",Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(getApplicationContext(),LoginActivity.class));
                            }
                        }
                        else{
                            Toast.makeText(getApplicationContext(),"Email Already exists",Toast.LENGTH_SHORT).show();
                        }
                    }
                    Toast.makeText(getApplicationContext(),"Password do not match",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
