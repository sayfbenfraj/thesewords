package com.app.thesewords;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.List;

public class SplashScreenActivity extends Activity {

    ProgressBar splashProgress;
    int SPLASH_TIME = 3000; //This is 3 seconds
    private DBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        View decorView = getWindow().getDecorView();
        // Hide both the navigation bar and the status bar.
        // SYSTEM_UI_FLAG_FULLSCREEN is only available on Android 4.1 and higher, but as
        // a general rule, you should design your app to hide the status bar whenever you
        // hide the navigation bar.

        int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            decorView.setSystemUiVisibility(uiOptions);
        }

        // Creating a new DBHandler class and passing our context to it.
        dbHandler = new DBHandler(SplashScreenActivity.this);

        setContentView(R.layout.splash_screen_activity);

        // Read data from json file
        fillCardDataBase(dbHandler, getApplicationContext());
        //This is additional feature, used to run a progress bar
        splashProgress = findViewById(R.id.splashProgress);
        playProgress();

        //Code to start timer and take action after the timer ends
        new Handler(getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                //Do any action here. Now we are moving to next page
                Intent mySuperIntent = new Intent(SplashScreenActivity.this, MainActivity.class);
                startActivity(mySuperIntent);
                //This 'finish()' is for exiting the app when back button pressed from Home page which is ActivityHome
                finish();
            }
        }, SPLASH_TIME);
    }

    //Method to run progress bar for 5 seconds
    private void playProgress() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            ObjectAnimator.ofInt(splashProgress, "progress", 100)
                    .setDuration(SPLASH_TIME - 10)
                    .start();
        }
    }
    // Method to fill data base during the splash screen
    public void fillCardDataBase(DBHandler dbHandler, Context context){

        String path = "cards_metadata.json";
        byte[] thumbnailByteArray;

        String jsonFileString = Utils.getJsonFromAssets(getApplicationContext(), path);
        Log.i("data", jsonFileString);
        Gson gson = new Gson();
        Type listUserType = new TypeToken<List<Card>>() { }.getType();
        List<Card> cards = gson.fromJson(jsonFileString, listUserType);

        for (int i = 0; i < cards.size(); i++) {
            Card card = cards.get(i);
            String title     = card.getTitle();
            String category  = card.getCategory();
            String thumbnail = card.getThumbnail();

            try {
                thumbnailByteArray = getDrawable(context,thumbnail+".jpg");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            dbHandler.addNewCard(title,category,thumbnailByteArray);
        }



    }
    public static byte[] getDrawable(Context context, String fileName) throws IOException {
        AssetManager assetManager = context.getAssets();
        InputStream distro = assetManager.open(fileName);
        Bitmap bitmap = BitmapFactory.decodeStream(distro);
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
        byte[] byteMap = stream.toByteArray();
        distro.close();

        return byteMap;
    }

}
