package com.example.add_place;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class PlaceView extends AppCompatActivity {

    ListView list;
    Context context;
    TextView Countplace;
    DbHandler dbHandler;
    List<Boarding> board;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_view);
        context = this;

        dbHandler = new DbHandler(this);
        list = findViewById(R.id.listPlace);
        Countplace = findViewById(R.id.textCount);
        board = new ArrayList<>();

        board = dbHandler.getAllPlaces();

        PlaceAdpter adapter = new PlaceAdpter(context,R.layout.single_row,board);
        list.setAdapter(adapter);

        int countPlace= dbHandler.countPlace();
        Countplace.setText("You have "+countPlace+" available places");

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                final Boarding boarding = board.get(position);

                        Intent intent = new Intent(context,SinglePlaceView.class);
                        intent.putExtra("id",String.valueOf(boarding.getId()));
                        startActivity(intent);
//                    }
//                });
//                builder.show();
            }
        });
    }
}
