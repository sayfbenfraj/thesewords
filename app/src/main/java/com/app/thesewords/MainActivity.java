package com.app.thesewords;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.app.thesewords.recyclerViewAdapters.AdapterBlue;
import com.app.thesewords.recyclerViewAdapters.AdapterGreen;
import com.app.thesewords.recyclerViewAdapters.AdapterPurple;
import com.app.thesewords.recyclerViewAdapters.AdapterRed;
import com.app.thesewords.recyclerViewAdapters.AdapterYellow;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MainActivity extends Activity implements RecyclerViewInterface {

    // Cards Categories recycler view
    RecyclerView recyclerViewRed;
    RecyclerView recyclerViewBlue;
    RecyclerView recyclerViewYellow;
    RecyclerView recyclerViewGreen;
    RecyclerView recyclerViewPurple;

    // Array list for recycler view cards title data source
   ArrayList<CardModel> sourceRed    = new ArrayList<>();
   ArrayList<CardModel> sourceBlue   = new ArrayList<>();
   ArrayList<CardModel> sourceYellow = new ArrayList<>();
   ArrayList<CardModel> sourceGreen  = new ArrayList<>();
   ArrayList<CardModel> sourcePurple = new ArrayList<>();

    // Layout Manager
    RecyclerView.LayoutManager RecyclerViewLayoutManagerRed;
    RecyclerView.LayoutManager RecyclerViewLayoutManagerBlue;
    RecyclerView.LayoutManager RecyclerViewLayoutManagerYellow;
    RecyclerView.LayoutManager RecyclerViewLayoutManagerGreen;
    RecyclerView.LayoutManager RecyclerViewLayoutManagerPurple;

    // Adapter class object
    AdapterRed adapterRed;
    AdapterBlue adapterBlue;
    AdapterYellow adapterYellow;
    AdapterGreen adapterGreen;
    AdapterPurple adapterPurple;

    // Linear Layout Manager
    LinearLayoutManager HorizontalLayoutRed;
    LinearLayoutManager HorizontalLayoutBlue;
    LinearLayoutManager HorizontalLayoutYellow;
    LinearLayoutManager HorizontalLayoutGreen;
    LinearLayoutManager HorizontalLayoutPurple;

    TextToSpeech textToSpeech;
    Button yesButton;
    Button noButton;
    ImageView playButton;
    ImageView deleteButton;
    private DBHandler dbHandler;
    private static final int REQUEST_ID_MULTIPLE_PERMISSIONS = 101;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.main_activity);
        checkAndRequestPermissions(MainActivity.this);
        dbHandler = new DBHandler(MainActivity.this);

        // Attach recycler views to layout by id
        recyclerViewRed    =  findViewById(R.id.recyclerview_red);
        recyclerViewBlue   =  findViewById(R.id.recyclerview_blue);
        recyclerViewYellow =  findViewById(R.id.recyclerview_yellow);
        recyclerViewGreen  =  findViewById(R.id.recyclerview_green);
        recyclerViewPurple =  findViewById(R.id.recyclerview_play);

        // Create new Recycler view managers
        RecyclerViewLayoutManagerRed    = new LinearLayoutManager(getApplicationContext());
        RecyclerViewLayoutManagerBlue   = new LinearLayoutManager(getApplicationContext());
        RecyclerViewLayoutManagerYellow = new LinearLayoutManager(getApplicationContext());
        RecyclerViewLayoutManagerGreen  = new LinearLayoutManager(getApplicationContext());
        RecyclerViewLayoutManagerPurple = new LinearLayoutManager(getApplicationContext());

        // Set LayoutManager on Recycler View
        recyclerViewRed.setLayoutManager(RecyclerViewLayoutManagerRed);
        recyclerViewBlue.setLayoutManager(RecyclerViewLayoutManagerBlue);
        recyclerViewYellow.setLayoutManager(RecyclerViewLayoutManagerYellow);
        recyclerViewGreen.setLayoutManager(RecyclerViewLayoutManagerGreen);
        recyclerViewPurple.setLayoutManager(RecyclerViewLayoutManagerPurple);

        // Adding items to RecyclerView.
        sourceRed    = getCardsByCategoryFromDataBase("household");
        sourceBlue   = getCardsByCategoryFromDataBase("classroom");
        sourceYellow = getCardsByCategoryFromDataBase("clothes");
        sourceGreen  = getCardsByCategoryFromDataBase("other");
        // add a new add drawables to play card recyclerview and hid the view u

        // calling constructor of adapter
        // with source list as a parameter
        adapterRed    = new AdapterRed(sourceRed, this);
        adapterBlue   = new AdapterBlue(sourceBlue, this);
        adapterYellow = new AdapterYellow(sourceYellow, this);
        adapterGreen  = new AdapterGreen(sourceGreen, this);
        adapterPurple = new AdapterPurple(sourcePurple);

        // Set Horizontal Layout Manager
        // for Recycler view
        HorizontalLayoutRed    = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL, false);
        HorizontalLayoutBlue   = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL, false);
        HorizontalLayoutYellow = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL, false);
        HorizontalLayoutGreen  = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL, false);
        HorizontalLayoutPurple = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL, false);

        recyclerViewRed.setLayoutManager(HorizontalLayoutRed);
        recyclerViewBlue.setLayoutManager(HorizontalLayoutBlue);
        recyclerViewYellow.setLayoutManager(HorizontalLayoutYellow);
        recyclerViewGreen.setLayoutManager(HorizontalLayoutGreen);
        recyclerViewPurple.setLayoutManager(HorizontalLayoutPurple);

        // Set adapter on recycler view
        recyclerViewRed.setAdapter(adapterRed);
        recyclerViewBlue.setAdapter(adapterBlue);
        recyclerViewYellow.setAdapter(adapterYellow);
        recyclerViewGreen.setAdapter(adapterGreen);
        recyclerViewPurple.setAdapter(adapterPurple);

        textToSpeech = new TextToSpeech(getApplicationContext(), status -> {
            if (status != TextToSpeech.ERROR){
                textToSpeech.setLanguage(Locale.US);
            }
        });

        yesButton = findViewById(R.id.yesbutton);
        noButton = findViewById(R.id.nobutton);
        playButton = findViewById(R.id.playButton);
        deleteButton = findViewById(R.id.deleteButton);

        yesButton.setOnClickListener(v -> {
            String text = (String) yesButton.getText();
            onClickButton(text);
        });

        noButton.setOnClickListener(v -> {
            String text = (String) noButton.getText();
            onClickButton(text);
        });

        playButton.setOnClickListener(v -> {
            ArrayList currentList = adapterPurple.getCardTextListList();
            String result = String.join(", ", currentList);
            textToSpeech.speak(result, TextToSpeech.QUEUE_FLUSH, null, null);

        });

        deleteButton.setOnClickListener(v -> {
            adapterPurple.clear();
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        if(textToSpeech !=null){
            textToSpeech.stop();
            textToSpeech.shutdown();
        }
        Toast.makeText(getApplicationContext(), "onPause", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(getApplicationContext(), "onStop", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(getApplicationContext(), "onDestroy", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        textToSpeech = new TextToSpeech(getApplicationContext(), status -> {
            if (status != TextToSpeech.ERROR){
                textToSpeech.setLanguage(Locale.US);
            }
        });
        Toast.makeText(getApplicationContext(), "onRestart", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStart() {
        super.onStart();

        Toast.makeText(getApplicationContext(), "onStart", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(getApplicationContext(), "onResume", Toast.LENGTH_SHORT).show();
    }

    public static void checkAndRequestPermissions(final Activity context) {
        int WEExtortPermission = ContextCompat.checkSelfPermission(context,
                Manifest.permission.WRITE_EXTERNAL_STORAGE);
        int cameraPermission = ContextCompat.checkSelfPermission(context,
                Manifest.permission.CAMERA);
        List<String> listPermissionsNeeded = new ArrayList<>();
        if (cameraPermission != PackageManager.PERMISSION_GRANTED) {
            listPermissionsNeeded.add(Manifest.permission.CAMERA);
        }
        if (WEExtortPermission != PackageManager.PERMISSION_GRANTED) {
            listPermissionsNeeded
                    .add(Manifest.permission.WRITE_EXTERNAL_STORAGE);
        }
        if (!listPermissionsNeeded.isEmpty()) {
            ActivityCompat.requestPermissions(context, listPermissionsNeeded
                            .toArray(new String[0]),
                    REQUEST_ID_MULTIPLE_PERMISSIONS);
        }
    }

    public  ArrayList<CardModel> getCardsByCategoryFromDataBase(String category)
    {
        return dbHandler.getCardByCategory(category);
    }

    @Override
    public void onItemClickRed(View view, int position) {
        CardModel card = sourceRed.get(position);
        textToSpeech.speak(card.getTitle(), TextToSpeech.QUEUE_FLUSH, null, null);
        adapterPurple.addItem(card);
    }

    @Override
    public void onItemClickBlue(View view, int position) {
        CardModel card = sourceBlue.get(position);
        textToSpeech.speak(card.getTitle(), TextToSpeech.QUEUE_FLUSH, null, null);
        adapterPurple.addItem(card);
    }

    @Override
    public void onItemClickYellow(View view, int position) {
        CardModel card = sourceYellow.get(position);
        textToSpeech.speak(card.getTitle(), TextToSpeech.QUEUE_FLUSH, null, null);
        adapterPurple.addItem(card);
    }

    @Override
    public void onItemClickGreen(View view, int position) {
        CardModel card = sourceGreen.get(position);
        textToSpeech.speak(card.getTitle(), TextToSpeech.QUEUE_FLUSH, null, null);
        adapterPurple.addItem(card);
    }

    public void onClickButton(String text){
        textToSpeech.speak(text, TextToSpeech.QUEUE_FLUSH, null, null);
    }

}

