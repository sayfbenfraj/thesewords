package com.app.thesewords;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
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
    ArrayList<String> sourceRed;
    ArrayList<String> sourceBlue;
    ArrayList<String> sourceYellow;
    ArrayList<String> sourceGreen;
    ArrayList<String> sourcePurple = new ArrayList<>();

    // Array list with cards drawables for recycler view
    ArrayList<Drawable> source;
    ArrayList<Drawable> sourceDrawablePurple = new ArrayList<>();

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
    private static final int REQUEST_ID_MULTIPLE_PERMISSIONS = 101;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
        setContentView(R.layout.main_activity);
        checkAndRequestPermissions(MainActivity.this);

        // Attach recycler views to layout by id
        recyclerViewRed    =  findViewById(R.id.recyclerview_red);
        recyclerViewBlue   =  findViewById(R.id.recyclerview_blue);
        recyclerViewYellow =  findViewById(R.id.recyclerview_yellow);
        recyclerViewGreen  =  findViewById(R.id.recyclerview_green);
        recyclerViewPurple   =  findViewById(R.id.recyclerview_play);

        // Create new Recycler view managers
        RecyclerViewLayoutManagerRed       = new LinearLayoutManager(getApplicationContext());
        RecyclerViewLayoutManagerBlue      = new LinearLayoutManager(getApplicationContext());
        RecyclerViewLayoutManagerYellow    = new LinearLayoutManager(getApplicationContext());
        RecyclerViewLayoutManagerGreen     = new LinearLayoutManager(getApplicationContext());
        RecyclerViewLayoutManagerPurple    = new LinearLayoutManager(getApplicationContext());

        // Set LayoutManager on Recycler View
        recyclerViewRed.setLayoutManager(RecyclerViewLayoutManagerRed);
        recyclerViewBlue.setLayoutManager(RecyclerViewLayoutManagerBlue);
        recyclerViewYellow.setLayoutManager(RecyclerViewLayoutManagerYellow);
        recyclerViewGreen.setLayoutManager(RecyclerViewLayoutManagerGreen);
        recyclerViewPurple.setLayoutManager(RecyclerViewLayoutManagerPurple);

        // Adding items to RecyclerView.
        sourceRed    = AddCardTextToRecyclerViewAdapter();
        sourceBlue   = AddCardTextToRecyclerViewAdapter();
        sourceYellow = AddCardTextToRecyclerViewAdapter();
        sourceGreen  = AddCardTextToRecyclerViewAdapter();

        // Adding drawable to RecyclerView
        source = AddCardDrawableToRecyclerViewAdapter();
        // add a new add drawables to play card recyclerview and hid the view u

        // calling constructor of adapter
        // with source list as a parameter
        adapterRed    = new AdapterRed(sourceRed,    source, this);
        adapterBlue   = new AdapterBlue(sourceBlue,   source, this);
        adapterYellow = new AdapterYellow(sourceYellow, source, this);
        adapterGreen  = new AdapterGreen(sourceGreen,  source, this);
        adapterPurple = new AdapterPurple(sourcePurple,sourceDrawablePurple);

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

    public ArrayList<String> AddCardTextToRecyclerViewAdapter()
    {
        // Adding items to ArrayList
        ArrayList<String> source = new ArrayList<>();
        source.add("gfg");
        source.add("is");
        source.add("best");
        source.add("site");
        source.add("for");
        source.add("interview");
        source.add("preparation");

        return source;
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    public ArrayList<Drawable> AddCardDrawableToRecyclerViewAdapter ()
    {
        // Adding items to ArrayList
        ArrayList<Drawable> source = new ArrayList<>();
        source.add(getDrawable(R.drawable.blue_rectangle_black_border));
        source.add(getDrawable(R.drawable.blue_rectangle_black_border));
        source.add(getDrawable(R.drawable.blue_rectangle_black_border));
        source.add(getDrawable(R.drawable.blue_rectangle_black_border));
        source.add(getDrawable(R.drawable.blue_rectangle_black_border));
        source.add(getDrawable(R.drawable.blue_rectangle_black_border));
        source.add(getDrawable(R.drawable.blue_rectangle_black_border));

        return source;
    }

    @Override
    public void onItemClickRed(View view, int position) {
        String text = sourceRed.get(position);
        setTextToSpeech(text);
        sourcePurple.add(text);
        sourceDrawablePurple.add(source.get(position));
        adapterPurple.notifyItemInserted(sourceDrawablePurple.size());
    }

    @Override
    public void onItemClickBlue(View view, int position) {
        String text = sourceBlue.get(position);
        setTextToSpeech(text);
        sourcePurple.add(text);
        sourceDrawablePurple.add(source.get(position));
        adapterPurple.notifyItemInserted(sourceDrawablePurple.size());
    }

    @Override
    public void onItemClickYellow(View view, int position) {
        String text = sourceYellow.get(position);
        setTextToSpeech(text);
        sourcePurple.add(text);
        sourceDrawablePurple.add(source.get(position));
        adapterPurple.notifyItemInserted(sourceDrawablePurple.size());
    }

    @Override
    public void onItemClickGreen(View view, int position) {
        String text = sourceGreen.get(position);
        setTextToSpeech(text);
        sourcePurple.add(text);
        sourceDrawablePurple.add(source.get(position));
        adapterPurple.notifyItemInserted(sourceDrawablePurple.size());
    }

    public void setTextToSpeech(String text){
        textToSpeech.speak(text, TextToSpeech.QUEUE_FLUSH, null, null);
    }

}

