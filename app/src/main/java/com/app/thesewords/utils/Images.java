package com.app.thesewords.utils;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.app.thesewords.Card;
import com.app.thesewords.R;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class Images extends Activity implements Serializable {

    private ArrayList<Card> lstCard;
    private DataBaseHelper dataBaseHelper;
    private RecyclerViewAdapter myAdapter;
    private RecyclerView recyclerView;
    private TextView emptyView;
    private Button addImageButton;
    private Button changeGrid;
    private List<Integer> listOfGridOptions;
    private int currentGridState = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // setContentView(R.layout.images_activity);

        // addImageButton = findViewById(R.id.add_image);
        // changeGrid     = findViewById(R.id.change_grid);
        // emptyView = findViewById(R.id.empty_view);
        // dataBaseHelper = new DataBaseHelper(this);
        // recyclerView = findViewById(R.id.recyclerview_id);
        // lstCard = new ArrayList<Card>();
        // lstCard = dataBaseHelper.getBooks();

        if(savedInstanceState != null){
            currentGridState = savedInstanceState.getInt("GRID_COUNTER",0);
        }


        if (lstCard.isEmpty()) {
            recyclerView.setVisibility(View.GONE);
            emptyView.setVisibility(View.VISIBLE);
            addImageButton.setVisibility(View.VISIBLE);
            goToActivity(addImageButton);
            if (getIntent().getExtras() != null) {
                Intent i = getIntent();
                Card dene = (Card) i.getSerializableExtra("SAMPLE_OBJECT");
                lstCard.add(dene);
                recyclerView.setVisibility(View.VISIBLE);
                emptyView.setVisibility(View.GONE);
                addImageButton.setVisibility(View.VISIBLE);
                goToActivity(addImageButton);
                lstCard = dataBaseHelper.getBooks();
                myAdapter = new RecyclerViewAdapter(this, lstCard);
                recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
                recyclerView.setAdapter(myAdapter);
            }
        } else {
            recyclerView.setVisibility(View.VISIBLE);
            emptyView.setVisibility(View.GONE);
            addImageButton.setVisibility(View.VISIBLE);
            goToActivity(addImageButton);
            lstCard = dataBaseHelper.getBooks();
            myAdapter = new RecyclerViewAdapter(this, lstCard);
            recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
            recyclerView.setAdapter(myAdapter);
        }

        changeGrid.setOnClickListener(v -> {
            recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(),
                    currentGridState));
            recyclerView.setAdapter(myAdapter);
            currentGridState = currentGridState + 1;
            if (currentGridState > 3) {currentGridState = 1;}
        });
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
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("GRID_COUNTER",currentGridState);

    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle outState) {
        super.onRestoreInstanceState(outState);
        currentGridState = outState.getInt("GRID_COUNTER",0);

    }

    @Override
    protected void onResume() {
        super.onResume();

        if (getIntent().getExtras() != null) {
            Intent i = getIntent();
            Card dene = (Card) i.getSerializableExtra("SAMPLE_OBJECT");
            lstCard.add(dene);
            myAdapter.notifyItemChanged(0);
            dataBaseHelper.saveBooks(lstCard);
        } else {
            if (lstCard.isEmpty()) {
                recyclerView.setVisibility(View.GONE);
                emptyView.setVisibility(View.VISIBLE);
                addImageButton.setVisibility(View.VISIBLE);
                goToActivity(addImageButton);
                if (getIntent().getExtras() != null) {
                    Intent i = getIntent();
                    Card dene = (Card) i.getSerializableExtra("SAMPLE_OBJECT");
                    lstCard.add(dene);
                    recyclerView.setVisibility(View.VISIBLE);
                    emptyView.setVisibility(View.GONE);
                    addImageButton.setVisibility(View.VISIBLE);
                    goToActivity(addImageButton);
                    lstCard = dataBaseHelper.getBooks();
                    myAdapter = new RecyclerViewAdapter(this, lstCard);
                    recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
                    recyclerView.setAdapter(myAdapter);
                }
            } else {
                recyclerView.setVisibility(View.VISIBLE);
                emptyView.setVisibility(View.GONE);
                addImageButton.setVisibility(View.VISIBLE);
                goToActivity(addImageButton);
                lstCard = dataBaseHelper.getBooks();
                myAdapter = new RecyclerViewAdapter(this, lstCard);
                recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
                recyclerView.setAdapter(myAdapter);
            }
        }
    }

    private void goToActivity(View v) {
        v.setOnClickListener(view -> switchActivities(AddImages.class));
    }

    private void switchActivities(Class c) {
        Intent switchActivityIntent = new Intent(this, c);
        startActivityForResult(switchActivityIntent, 0);
    }
}



