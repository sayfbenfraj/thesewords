package com.app.thesewords.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.app.thesewords.Card;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class DataBaseHelper {
    private SharedPreferences bookDatabase;
    private SharedPreferences phraseDatabase;
    private Gson gson;

    public DataBaseHelper(Context context){
        bookDatabase   = context.getSharedPreferences("bookDatabase", Context.MODE_PRIVATE);
        phraseDatabase = context.getSharedPreferences("phrasesDatabase", Context.MODE_PRIVATE);
        gson = new Gson();
    }

    public void savePhrases(ArrayList phrases){
        SharedPreferences.Editor editor = phraseDatabase.edit();
        editor.putString("Phrases", gson.toJson(phrases));
        editor.apply();
    }

    public ArrayList getPhrases(){
        String phrasesString = phraseDatabase.getString("Phrases", null);
        Type phraseListType = new TypeToken<ArrayList>(){}.getType();
        ArrayList phrases  = gson.fromJson(phrasesString, phraseListType);
        if (phrases!= null) return  phrases;
        else return new ArrayList<>();
    }

    public void saveBooks(ArrayList<Card> cards){
        SharedPreferences.Editor editor = bookDatabase.edit();
        editor.putString("Books", gson.toJson(cards));
        editor.apply();
    }

    public ArrayList<Card> getBooks(){
        String booksString = bookDatabase.getString("Books", null);
        Type bookListType = new TypeToken<ArrayList<Card>>(){}.getType();

        ArrayList<Card> cards = gson.fromJson(booksString, bookListType);
        if (cards != null) return cards;
        else return new ArrayList<Card>();
    }
}
