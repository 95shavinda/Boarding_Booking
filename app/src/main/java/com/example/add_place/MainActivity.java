package com.example.add_place;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button add;
    ListView listView;
    Context context;
    TextView count;
    DbHandler dbHandler;
    List<Boarding> boardingList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;

        dbHandler = new DbHandler(this);
        add = findViewById(R.id.add_place);
        listView = findViewById(R.id.addlist);
        count = findViewById(R.id.txtcount);
        boardingList = new ArrayList<>();

        boardingList = dbHandler.getAllPlaces();

        PlaceAdpter adapter = new PlaceAdpter(context,R.layout.single_row,boardingList);
        listView.setAdapter(adapter);

        int countPlace= dbHandler.countPlace();
        count.setText("You have "+countPlace+" available places");

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,AddPlace.class);
                startActivity(intent);
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                final Boarding boarding = boardingList.get(position);

                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle(boarding.getName());
                builder.setMessage(boarding.getDescription());

                builder.setPositiveButton("Finished", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(context,MainActivity.class);
                        boarding.setFinished(System.currentTimeMillis());
                        dbHandler.updatePlace(boarding);
                        startActivity(intent);
                    }
                });
                builder.setNegativeButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        dbHandler.deletePlace(boarding.getId());
                        Intent intent = new Intent(context,MainActivity.class);
                        startActivity(intent);

                    }
                });
                builder.setNeutralButton("Update", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(context,EditPlace.class);
                        intent.putExtra("id",String.valueOf(boarding.getId()));
                        startActivity(intent);
                    }
                });
                builder.show();
            }
        });
    }
}
