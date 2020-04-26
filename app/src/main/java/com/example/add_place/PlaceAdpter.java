package com.example.add_place;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.w3c.dom.Text;

import java.util.List;

public class PlaceAdpter extends ArrayAdapter<Boarding> {

    private Context context;
    private int resource;
    List<Boarding> boardingList;

    PlaceAdpter(Context context, int resource, List<Boarding> boardingList){
        super(context,resource,boardingList);
        this.context = context;
        this.resource = resource;
        this.boardingList = boardingList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View row = inflater.inflate(resource,parent,false);

        TextView name = row.findViewById(R.id.name);
        TextView contact = row.findViewById(R.id.contact);
        TextView address = row.findViewById(R.id.address);
        TextView des = row.findViewById(R.id.description);
        ImageView image = row.findViewById(R.id.finish);

        Boarding boarding = boardingList.get(position);
        name.setText(boarding.getName());
        contact.setText(boarding.getContact());
        address.setText(boarding.getAddress());
        des.setText(boarding.getDescription());
        image.setVisibility(row.INVISIBLE);

        if(boarding.getFinished()>0){
           image.setVisibility(row.VISIBLE);
        }
        return row;
    }
}
