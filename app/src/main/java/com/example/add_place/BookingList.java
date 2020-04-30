package com.example.add_place;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class BookingList extends AppCompatActivity {

    EditText bookName,noOfRooms;
    Button btnbookin;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_list);

        bookName = findViewById(R.id.ename);
        noOfRooms = findViewById(R.id.eroom);
        btnbookin = findViewById(R.id.btnconfirm);
        context = this;

        btnbookin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = bookName.getText().toString();
                String NoOfRoom = noOfRooms.getText().toString();
                long booked = System.currentTimeMillis();

                Intent intent = new Intent(context,BookedList.class);

                intent.putExtra("Name",userName);
                intent.putExtra("Room",NoOfRoom);
                startActivity(intent);
            }
        });

    }
}
