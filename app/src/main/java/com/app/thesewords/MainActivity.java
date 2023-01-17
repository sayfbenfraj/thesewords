package com.app.thesewords;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends Activity {

    RecyclerView recyclerViewRed;
    RecyclerView recyclerViewBlue;
    RecyclerView recyclerViewYellow;
    RecyclerView recyclerViewGreen;

    // Array list for recycler view data source
    ArrayList<String> sourceRed;
    ArrayList<String> sourceBlue;
    ArrayList<String> sourceYellow;
    ArrayList<String> sourceGreen;

    // Layout Manager
    RecyclerView.LayoutManager RecyclerViewLayoutManagerRed;
    RecyclerView.LayoutManager RecyclerViewLayoutManagerBlue;
    RecyclerView.LayoutManager RecyclerViewLayoutManagerYellow;
    RecyclerView.LayoutManager RecyclerViewLayoutManagerGreen;

    // adapter class object
    Adapter adapterRed;
    Adapter adapterBlue;
    Adapter adapterYellow;
    Adapter adapterGreen;

    // Linear Layout Manager
    LinearLayoutManager HorizontalLayoutRed;
    LinearLayoutManager HorizontalLayoutBlue;
    LinearLayoutManager HorizontalLayoutYellow;
    LinearLayoutManager HorizontalLayoutGreen;

    View ChildView;
    int RecyclerViewItemPosition;

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

        recyclerViewRed    =  findViewById(R.id.recyclerview_red);
        recyclerViewBlue   =  findViewById(R.id.recyclerview_blue);
        recyclerViewYellow =  findViewById(R.id.recyclerview_yellow);
        recyclerViewGreen  =  findViewById(R.id.recyclerview_green);

        RecyclerViewLayoutManagerRed    = new LinearLayoutManager(getApplicationContext());
        RecyclerViewLayoutManagerBlue   = new LinearLayoutManager(getApplicationContext());
        RecyclerViewLayoutManagerYellow = new LinearLayoutManager(getApplicationContext());
        RecyclerViewLayoutManagerGreen  =  new LinearLayoutManager(getApplicationContext());

        // Set LayoutManager on Recycler View
        recyclerViewRed.setLayoutManager(RecyclerViewLayoutManagerRed);
        recyclerViewBlue.setLayoutManager(RecyclerViewLayoutManagerBlue);
        recyclerViewYellow.setLayoutManager(RecyclerViewLayoutManagerYellow);
        recyclerViewGreen.setLayoutManager(RecyclerViewLayoutManagerGreen);

        // Adding items to RecyclerView.
        sourceRed    = AddItemsToRecyclerViewArrayList(sourceRed);
        sourceBlue   = AddItemsToRecyclerViewArrayList(sourceBlue);
        sourceYellow = AddItemsToRecyclerViewArrayList(sourceYellow);
        sourceGreen  = AddItemsToRecyclerViewArrayList(sourceGreen);

        // calling constructor of adapter
        // with source list as a parameter
        adapterRed    = new Adapter(sourceRed);
        adapterBlue   = new Adapter(sourceBlue);
        adapterYellow = new Adapter(sourceYellow);
        adapterGreen  = new Adapter(sourceGreen);

        // Set Horizontal Layout Manager
        // for Recycler view
        HorizontalLayoutRed    = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL, false);
        HorizontalLayoutBlue   = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL, false);
        HorizontalLayoutYellow = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL, false);
        HorizontalLayoutGreen  = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL, false);

        recyclerViewRed.setLayoutManager(HorizontalLayoutRed);
        recyclerViewBlue.setLayoutManager(HorizontalLayoutBlue);
        recyclerViewYellow.setLayoutManager(HorizontalLayoutYellow);
        recyclerViewGreen.setLayoutManager(HorizontalLayoutGreen);

        // Set adapter on recycler view
        recyclerViewRed.setAdapter(adapterRed);
        recyclerViewBlue.setAdapter(adapterBlue);
        recyclerViewYellow.setAdapter(adapterYellow);
        recyclerViewGreen.setAdapter(adapterGreen);

    }

    @Override
    protected void onPause() {
        super.onPause();
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

    private void goToActivity(View v, Class c){
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchActivities(c);
            }
        });
    }

    private void switchActivities(Class c) {
        Intent switchActivityIntent = new Intent(this, c);
        startActivity(switchActivityIntent);
    }

    public static boolean checkAndRequestPermissions(final Activity context) {
        int WExtstorePermission = ContextCompat.checkSelfPermission(context,
                Manifest.permission.WRITE_EXTERNAL_STORAGE);
        int cameraPermission = ContextCompat.checkSelfPermission(context,
                Manifest.permission.CAMERA);
        List<String> listPermissionsNeeded = new ArrayList<>();
        if (cameraPermission != PackageManager.PERMISSION_GRANTED) {
            listPermissionsNeeded.add(Manifest.permission.CAMERA);
        }
        if (WExtstorePermission != PackageManager.PERMISSION_GRANTED) {
            listPermissionsNeeded
                    .add(Manifest.permission.WRITE_EXTERNAL_STORAGE);
        }
        if (!listPermissionsNeeded.isEmpty()) {
            ActivityCompat.requestPermissions(context, listPermissionsNeeded
                            .toArray(new String[listPermissionsNeeded.size()]),
                    REQUEST_ID_MULTIPLE_PERMISSIONS);
            return false;
        }
        return true;
    }

    public ArrayList<String> AddItemsToRecyclerViewArrayList(ArrayList<String> source)
    {
        // Adding items to ArrayList
        source = new ArrayList<>();
        source.add("gfg");
        source.add("is");
        source.add("best");
        source.add("site");
        source.add("for");
        source.add("interview");
        source.add("preparation");

        return source;
    }
}

