package com.app.thesewords;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DBHandler extends SQLiteOpenHelper {
    // Creating constant variables for application database
    private static final String DB_NAME = "cardsDB";
    private static final int DB_VERSION = 1;
    private static final String TABLE_NAME = "CardsTable";
    private static final String ID_COL  = "ID";
    private static final String TITLE = "Title";
    private static final String CATEGORY = "Category";
    private static final String THUMBNAIL = "Thumbnail";


    // Creating a constructor for the database handler
    public DBHandler(Context context){
        super(context, DB_NAME, null, DB_VERSION);
    }

    // Method for creating the database by running sqlite query
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String query = "CREATE TABLE " + TABLE_NAME + " ("
                + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + TITLE + " TEXT, "
                + CATEGORY + " TEXT, "
                + THUMBNAIL + " BLOB)";

        sqLiteDatabase.execSQL(query);
    }

    // Method to add a new card to the database
    public void addNewCard(String tile, String category, byte[] thumbnail){

        // Calling writable method writing data in our database
        SQLiteDatabase db = this.getWritableDatabase();

        // Creating a variable for content values.
        ContentValues values = new ContentValues();

        // Passing all the values with their key and value pair
        values.put(TITLE, tile);
        values.put(CATEGORY, category);
        values.put(THUMBNAIL, thumbnail);

        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public ArrayList<CardModel> getCardByCategory(String cat) {
        // Creating a database for reading our database.
        SQLiteDatabase db = this.getReadableDatabase();

        // Creating a cursor with query to read data from database.
        Cursor cursorCourses = db.rawQuery("SELECT * FROM " + TABLE_NAME +
                         " WHERE " + CATEGORY + " = '" + cat + "'", null);

        // Creating a new array list.
        ArrayList<CardModel> cardModalArrayList = new ArrayList<>();

        // moving our cursor to first position.
        if (cursorCourses.moveToFirst()) {
            do {
                // on below line we are adding the data from cursor to our array list.
                cardModalArrayList.add(new CardModel(cursorCourses.getString(1),
                        cursorCourses.getString(2),
                        cursorCourses.getBlob(3)));
            } while (cursorCourses.moveToNext());
            // moving our cursor to next.
        }
        // at last closing our cursor
        // and returning our array list.
        cursorCourses.close();
        db.close();
        return cardModalArrayList;
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        // Method to check if the database exists already
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

}
