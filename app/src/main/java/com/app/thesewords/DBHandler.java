package com.app.thesewords;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

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

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        // Method to check if the database exists already
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(sqLiteDatabase);
    }
}
