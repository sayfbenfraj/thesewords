package com.app.thesewords.utils;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.app.thesewords.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class Letters extends Activity {

    private TextToSpeech textToSpeech;
    public TextView TextViewSpeech;
    public String CumText = "";
    public List<View> buttonsList = new ArrayList();

    @SuppressLint("WrongViewCast")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.letters);

        buttonsList.addAll(Arrays.asList(findViewById(R.id.A), findViewById(R.id.B),
                findViewById(R.id.C), findViewById(R.id.D), findViewById(R.id.E),
                findViewById(R.id.F), findViewById(R.id.G), findViewById(R.id.H),
                findViewById(R.id.I), findViewById(R.id.J), findViewById(R.id.K),
                findViewById(R.id.L), findViewById(R.id.M), findViewById(R.id.N),
                findViewById(R.id.O), findViewById(R.id.P), findViewById(R.id.Q),
                findViewById(R.id.R), findViewById(R.id.S), findViewById(R.id.T),
                findViewById(R.id.U), findViewById(R.id.V), findViewById(R.id.W),
                findViewById(R.id.X), findViewById(R.id.Y), findViewById(R.id.Z),
                findViewById(R.id.space)));




        TextViewSpeech = findViewById(R.id.TextViewSpeech);
        TextViewSpeech.setMovementMethod(new ScrollingMovementMethod());

        // create an object textToSpeech and adding features into it
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

        for(int i=0; i< buttonsList.size(); i++){
            CumText = onClickSpeech((Button) buttonsList.get(i));
        }


       /* CumText = onClickSpeech(findViewById(R.id.B));
        CumText = onClickSpeech(findViewById(R.id.C));
        CumText = onClickSpeech(findViewById(R.id.D));
        CumText = onClickSpeech(findViewById(R.id.E));
        CumText = onClickSpeech(findViewById(R.id.F));
        CumText = onClickSpeech(findViewById(R.id.G));
        CumText = onClickSpeech(findViewById(R.id.H));
        CumText = onClickSpeech(findViewById(R.id.I));
        CumText = onClickSpeech(findViewById(R.id.J));
        CumText = onClickSpeech(findViewById(R.id.K));
        CumText = onClickSpeech(findViewById(R.id.L));
        CumText = onClickSpeech(findViewById(R.id.M));
        CumText = onClickSpeech(findViewById(R.id.N));
        CumText = onClickSpeech(findViewById(R.id.O));
        CumText = onClickSpeech(findViewById(R.id.P));
        CumText = onClickSpeech(findViewById(R.id.Q));
        CumText = onClickSpeech(findViewById(R.id.R));
        CumText = onClickSpeech(findViewById(R.id.S));
        CumText = onClickSpeech(findViewById(R.id.T));
        CumText = onClickSpeech(findViewById(R.id.U));
        CumText = onClickSpeech(findViewById(R.id.V));
        CumText = onClickSpeech(findViewById(R.id.W));
        CumText = onClickSpeech(findViewById(R.id.X));
        CumText = onClickSpeech(findViewById(R.id.Y));
        CumText = onClickSpeech(findViewById(R.id.Z));*/

      /*  CumText = onClickSpeech(findViewById(R.id.space));*/
        CumText = onClickClear(findViewById(R.id.clear_test));
        CumText = onClickDelete(findViewById(R.id.delete));

        onClickRepeat(findViewById(R.id.repeat));
        onClickStop(findViewById(R.id.stop));
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
        outState.putString("Text", CumText);
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        CumText = savedInstanceState.getString("Text");
        TextViewSpeech.setText(CumText);
        super.onRestoreInstanceState(savedInstanceState);
    }

    public String onClickSpeech(View button) {
        final String[] letter = {""};
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Button cb = (Button) view;
                letter[0] = cb.getText().toString();

                if (letter[0].equals("Space")){
                    CumText += " ";

                } else {
                    CumText += letter[0];
                }
                textToSpeech.speak(CumText.toString(),TextToSpeech.QUEUE_FLUSH,null);// Do something
                if (CumText != null) {
                    TextViewSpeech.setText(CumText);
                }
            }
        });

        return letter[0];
    }

    public String onClickClear(Button button) {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                TextViewSpeech.setText("");
                CumText = "";
            }
        });
        return CumText;
    }

    public String onClickDelete(Button button) {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                if (CumText.length() > 0 ){
                    CumText = CumText.substring(0, CumText.length() - 1);
                    TextViewSpeech.setText(CumText);
                }
            }
        });
        return CumText;
    }

    public void onClickRepeat(Button button){
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                textToSpeech.speak(CumText.toString(),TextToSpeech.QUEUE_FLUSH,null);// Do something
            }
        });

    }

    public void onClickStop(Button button){
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                textToSpeech.speak("",TextToSpeech.QUEUE_FLUSH,null);// Do something
            }
        });
    }
}
