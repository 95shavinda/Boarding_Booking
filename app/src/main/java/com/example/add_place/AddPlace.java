package com.example.add_place;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddPlace extends AppCompatActivity {

    EditText name,contact,address,des;

    Button addPlace;
    private DbHandler dbHandler;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_place);

        name = findViewById(R.id.edit_name);
        contact = findViewById(R.id.edit_contact);
        address = findViewById(R.id.edit_address);
        des = findViewById(R.id.edit_description);
        addPlace = findViewById(R.id.btn_add);
        context = this;

        dbHandler = new DbHandler(context);

        addPlace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ownerName = name.getText().toString();
                String ownerContact = contact.getText().toString();
                String placeAddress = address.getText().toString();
                String description = des.getText().toString();
                long started = System.currentTimeMillis();

                Boarding boarding = new Boarding(ownerName,ownerContact,placeAddress,description,started,0);
                dbHandler.addPlace(boarding);

                Intent intent = new Intent(context,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
