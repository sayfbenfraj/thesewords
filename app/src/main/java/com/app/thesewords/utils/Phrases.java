package com.app.thesewords.utils;

import android.app.Activity;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.app.thesewords.R;

import java.util.ArrayList;
import java.util.Locale;

public class Phrases extends Activity {

    private TextToSpeech textToSpeech;
    public EditText AddPhraseTextView;
    public ArrayList<String> phasesArray = new ArrayList<String>();
    public ArrayAdapter adapter;
    public ListView listView;
    private Button AddButton;
    private Button RemoveButton;
    private Activity _activeActivity;
    private DataBaseHelper dataBaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.phrases);

        dataBaseHelper = new DataBaseHelper(this);
        phasesArray = dataBaseHelper.getPhrases();
        adapter = new ArrayAdapter<String>(this, R.layout.listview, phasesArray);
        listView = (ListView) findViewById(R.id.phrases_list);
        listView.setAdapter(adapter);
        AddPhraseTextView = findViewById(R.id.AddPhraseTextView);

        textToSpeech = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                // if No error is found then only it will run
                if (i != TextToSpeech.ERROR) {
                    // To Choose language of speech
                    textToSpeech.setLanguage(Locale.US);
                }
            }
        });

        AddButton = findViewById(R.id.AddButton);
        AddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ctext = String.valueOf(AddPhraseTextView.getText());
                if(!ctext.isEmpty())
                {
                    phasesArray.add(ctext);
                    adapter.notifyDataSetChanged();
                    dataBaseHelper.savePhrases(phasesArray);
                }
                else
                {
                    Toast.makeText(Phrases.this, "You need to enter test", Toast.LENGTH_LONG).show();
                }
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                textToSpeech.speak(phasesArray.get(position),
                        TextToSpeech.QUEUE_FLUSH, null);// Do something
            }
        });

        RemoveButton = findViewById(R.id.removeButton);
        RemoveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getText = AddPhraseTextView.getText().toString();
                for(int i=0; i<phasesArray.size(); i++) {
                    if (phasesArray.get(i).equals(getText)) {
                        phasesArray.remove(i);
                        break;
                    } else {
                        Toast.makeText(v.getContext(),"No item match", Toast.LENGTH_SHORT).show();
                    }
                }
                adapter.notifyDataSetChanged();
                dataBaseHelper.savePhrases(phasesArray);
            }
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
    protected void onResume() {
        super.onResume();
        Toast.makeText(getApplicationContext(), "onResume", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putStringArrayList("ListArray", phasesArray);
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        phasesArray = savedInstanceState.getStringArrayList("ListArray");
        if (phasesArray != null) {
            phasesArray = dataBaseHelper.getPhrases();
            adapter.addAll(phasesArray);
            listView.setAdapter(adapter);
            adapter.notifyDataSetChanged();
        }
        super.onRestoreInstanceState(savedInstanceState);
    }
}
