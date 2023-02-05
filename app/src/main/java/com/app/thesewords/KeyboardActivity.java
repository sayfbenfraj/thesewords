package com.app.thesewords;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class KeyboardActivity extends Activity {
    Button QButton;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.keyboard_activity);
        
        QButton = findViewById(R.id.keyboardButton1);

        QButton.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View view, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_UP) {
                    QButton.setBackgroundResource(R.drawable.key_bg);
                } else if(event.getAction() == MotionEvent.ACTION_DOWN) {
                    QButton.setBackgroundResource(R.drawable.key_bg_down);
                }
                return false;
            }

        });

    }

}
