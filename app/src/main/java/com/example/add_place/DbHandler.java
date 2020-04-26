package com.example.add_place;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DbHandler extends SQLiteOpenHelper {

    private static final int VERSION = 1;
    private static final String DB_NAME = "Places";
    private static final String TABLE_NAME = "Places";

    private static final String ID = "id";
    private static final String NAME = "name";
    private static final String CONTACT = "contact";
    private static final String ADDRESS = "address";
    private static final String DESCRIPTION = "description";
    private static final String STARTED = "started";
    private static final String FINISHED = "finished";

    public DbHandler(@Nullable Context context) {
        super(context, DB_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE_QUERY = "CREATE TABLE " + TABLE_NAME + " " +
                "("
                +ID+ " INTEGER PRIMARY KEY AUTOINCREMENT,"
                +NAME+ " TEXT,"
                +CONTACT+" TEXT,"
                +ADDRESS+ " TEXT,"
                +DESCRIPTION+ " TEXT,"
                +STARTED+ " TEXT,"
                +FINISHED+ " TEXT"
                +");";

        db.execSQL(CREATE_TABLE_QUERY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        String DROP_TABLE_QUERY = "DROP TABLE IF EXISTS "+TABLE_NAME;
        db.execSQL(DROP_TABLE_QUERY);
        onCreate(db);

    }

    public void addPlace(Boarding boarding){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put(NAME,boarding.getName());
        contentValues.put(CONTACT,boarding.getContact());
        contentValues.put(ADDRESS,boarding.getAddress());
        contentValues.put(DESCRIPTION,boarding.getDescription());
        contentValues.put(STARTED,boarding.getStarted());
        contentValues.put(FINISHED,boarding.getFinished());

        sqLiteDatabase.insert(TABLE_NAME,null,contentValues);
        sqLiteDatabase.close();
    }

    public int countPlace(){
        SQLiteDatabase db = getReadableDatabase();
        String query = "SELECT * FROM "+ TABLE_NAME;
        Cursor cursor = db.rawQuery(query,null);
        return cursor.getCount();
    }

    public List<Boarding> getAllPlaces(){

        List<Boarding> boarding = new ArrayList();
        SQLiteDatabase db = getReadableDatabase();
        String query = "SELECT * FROM "+TABLE_NAME;

        Cursor cursor = db.rawQuery(query,null);

        if(cursor.moveToFirst()){
            do{
                Boarding place = new Boarding();

                place.setId(cursor.getInt(0));
                place.setName(cursor.getString(1));
                place.setContact(cursor.getString(2));
                place.setAddress(cursor.getString(3));
                place.setDescription(cursor.getString(4));
                place.setStarted(cursor.getLong(5));
                place.setFinished(cursor.getLong(6));

                boarding.add(place);
            }while(cursor.moveToNext());
        }
        return boarding;
    }

    public void deletePlace(int id){
        SQLiteDatabase db = getWritableDatabase();
        db.delete(TABLE_NAME,"id =?",new String[]{String.valueOf(id)});
        db.close();
    }

    public Boarding getSinglePlace(int id){
        SQLiteDatabase db = getWritableDatabase();
        Cursor cursor = db.query(TABLE_NAME,new String[]{ID,NAME,CONTACT,ADDRESS,DESCRIPTION,STARTED,FINISHED},
                ID + "= ?",new String[]{String.valueOf(id)},null,null,null,null);

        Boarding boarding;
        if(cursor != null){
            cursor.moveToFirst();

            boarding = new Boarding(
                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getString(4),
                    cursor.getLong(5),
                    cursor.getLong(6)
            );
            return boarding;
        }
        return null;
    }

    public int updatePlace(Boarding boarding){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(NAME,boarding.getName());
        contentValues.put(CONTACT,boarding.getContact());
        contentValues.put(ADDRESS,boarding.getAddress());
        contentValues.put(DESCRIPTION,boarding.getDescription());
        contentValues.put(STARTED,boarding.getStarted());
        contentValues.put(FINISHED,boarding.getFinished());

        int status = db.update(TABLE_NAME,contentValues,ID +"=?",new String[]{String.valueOf(boarding.getId())});
        db.close();

        return status;
    }
}
