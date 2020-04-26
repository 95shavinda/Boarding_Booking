package com.example.add_place;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EditPlace extends AppCompatActivity {

    EditText name,contact,address,description;
    Context context;
    Long updateData;
    DbHandler dbHandler;
    Button update;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_place);

        context = this;
        dbHandler = new DbHandler(context);
        name = findViewById(R.id.update_name);
        contact = findViewById(R.id.update_contact);
        address = findViewById(R.id.update_address);
        description = findViewById(R.id.update_description);
        update = findViewById(R.id.btn_update);

        final String id = getIntent().getStringExtra("id");

        Boarding boarding = dbHandler.getSinglePlace(Integer.parseInt(id));

        name.setText(boarding.getName());
        contact.setText(boarding.getContact());
        address.setText(boarding.getAddress());
        description.setText(boarding.getDescription());

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ownerName = name.getText().toString();
                String contactNumber = contact.getText().toString();
                String placeAddress = address.getText().toString();
                String des = description.getText().toString();
                updateData = System.currentTimeMillis();

                Boarding board = new Boarding(Integer.parseInt(id),ownerName,contactNumber,placeAddress,des,updateData,0);
                int state = dbHandler.updatePlace(board);
                System.out.println(state);
                Toast toast = Toast.makeText(context,"Update "+state+"row",Toast.LENGTH_LONG);
                toast.setMargin(50,50);
                toast.show();
                startActivity(new Intent(context,MainActivity.class));
            }
        });

    }
}
