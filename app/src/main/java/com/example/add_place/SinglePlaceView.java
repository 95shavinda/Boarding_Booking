package com.example.add_place;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class SinglePlaceView extends AppCompatActivity {

    TextView owner,con,addrs,des;
    EditText feed;
    Context context;
    Long updateData;
    DbHandler dbHandler;
    Button book;
    ImageView sendImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_place_view);

        context = this;
        dbHandler = new DbHandler(context);
        owner = findViewById(R.id.txtName);
        con = findViewById(R.id.txtcon);
        addrs = findViewById(R.id.txtadd);
        des = findViewById(R.id.txtdes);
        book = findViewById(R.id.btnBook);
        feed = findViewById(R.id.editFeedback);
        sendImg = findViewById(R.id.imgSend);

        final String id = getIntent().getStringExtra("id");

        Boarding boarding = dbHandler.getSinglePlace(Integer.parseInt(id));

        owner.setText(boarding.getName());
        con.setText(boarding.getContact());
        addrs.setText(boarding.getAddress());
        des.setText(boarding.getDescription());

        book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,BookingList.class);
                startActivity(intent);
            }
        });

    }
}
