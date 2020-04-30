package com.example.add_place;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class BookedList extends AppCompatActivity {

    TextView tv,tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booked_list);

        tv = findViewById(R.id.txtn);
        tv1 = findViewById(R.id.txtroom);

        tv.setText(getIntent().getStringExtra("Name"));
        tv1.setText(getIntent().getStringExtra("Room"));


    }
}
