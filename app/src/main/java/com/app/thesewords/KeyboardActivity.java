package com.app.thesewords;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class KeyboardActivity extends Activity {

    Button AButton;
    Button BButton;
    Button CButton;
    Button DButton;
    Button EButton;
    Button FButton;
    Button GButton;
    Button HButton;
    Button IButton;
    Button JButton;
    Button KButton;
    Button LButton;
    Button MButton;
    Button NButton;
    Button OButton;
    Button PButton;
    Button QButton;
    Button RButton;
    Button SButton;
    Button TButton;
    Button UButton;
    Button VButton;
    Button WButton;
    Button XButton;
    Button YButton;
    Button ZButton;
    Button SpaceButton;
    Button DeleteButton;
    Button SpecialCharButton;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.keyboard_activity);

        setupKeyboardButtons();
        setupOnTouchButtons();



    }

    private void  setupKeyboardButtons() {
        AButton = findViewById(R.id.keyboardButtonA);
        BButton = findViewById(R.id.keyboardButtonB);
        CButton = findViewById(R.id.keyboardButtonC);
        DButton = findViewById(R.id.keyboardButtonD);
        EButton = findViewById(R.id.keyboardButtonE);
        FButton = findViewById(R.id.keyboardButtonF);
        GButton = findViewById(R.id.keyboardButtonG);
        HButton = findViewById(R.id.keyboardButtonH);
        IButton = findViewById(R.id.keyboardButtonI);
        JButton = findViewById(R.id.keyboardButtonJ);
        KButton = findViewById(R.id.keyboardButtonK);
        LButton = findViewById(R.id.keyboardButtonL);
        MButton = findViewById(R.id.keyboardButtonM);
        NButton = findViewById(R.id.keyboardButtonN);
        OButton = findViewById(R.id.keyboardButtonO);
        PButton = findViewById(R.id.keyboardButtonP);
        QButton = findViewById(R.id.keyboardButtonQ);
        RButton = findViewById(R.id.keyboardButtonR);
        SButton = findViewById(R.id.keyboardButtonS);
        TButton = findViewById(R.id.keyboardButtonT);
        UButton = findViewById(R.id.keyboardButtonU);
        VButton = findViewById(R.id.keyboardButtonV);
        WButton = findViewById(R.id.keyboardButtonW);
        XButton = findViewById(R.id.keyboardButtonX);
        YButton = findViewById(R.id.keyboardButtonY);
        ZButton = findViewById(R.id.keyboardButtonZ);
        SpaceButton = findViewById(R.id.keyboardButtonSpace);
        DeleteButton = findViewById(R.id.keyboardButtonDelete);
        SpecialCharButton = findViewById(R.id.keyboardButtonSpecialChar);
    }
    private void setupOnTouchButtons(){
        AButton.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View view, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_UP) {
                    AButton.setBackgroundResource(R.drawable.key_bg);
                } else if(event.getAction() == MotionEvent.ACTION_DOWN) {
                    AButton.setBackgroundResource(R.drawable.key_bg_down);
                }
                return false;
            }

        });
        BButton.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View view, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_UP) {
                    BButton.setBackgroundResource(R.drawable.key_bg);
                } else if(event.getAction() == MotionEvent.ACTION_DOWN) {
                    BButton.setBackgroundResource(R.drawable.key_bg_down);
                }
                return false;
            }

        });
        CButton.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View view, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_UP) {
                    CButton.setBackgroundResource(R.drawable.key_bg);
                } else if(event.getAction() == MotionEvent.ACTION_DOWN) {
                    CButton.setBackgroundResource(R.drawable.key_bg_down);
                }
                return false;
            }

        });
        DButton.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View view, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_UP) {
                    DButton.setBackgroundResource(R.drawable.key_bg);
                } else if(event.getAction() == MotionEvent.ACTION_DOWN) {
                    DButton.setBackgroundResource(R.drawable.key_bg_down);
                }
                return false;
            }

        });
        EButton.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View view, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_UP) {
                    EButton.setBackgroundResource(R.drawable.key_bg);
                } else if(event.getAction() == MotionEvent.ACTION_DOWN) {
                    EButton.setBackgroundResource(R.drawable.key_bg_down);
                }
                return false;
            }

        });
        FButton.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View view, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_UP) {
                    FButton.setBackgroundResource(R.drawable.key_bg);
                } else if(event.getAction() == MotionEvent.ACTION_DOWN) {
                    FButton.setBackgroundResource(R.drawable.key_bg_down);
                }
                return false;
            }

        });
        GButton.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View view, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_UP) {
                    GButton.setBackgroundResource(R.drawable.key_bg);
                } else if(event.getAction() == MotionEvent.ACTION_DOWN) {
                    GButton.setBackgroundResource(R.drawable.key_bg_down);
                }
                return false;
            }

        });
        HButton.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View view, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_UP) {
                    HButton.setBackgroundResource(R.drawable.key_bg);
                } else if(event.getAction() == MotionEvent.ACTION_DOWN) {
                    HButton.setBackgroundResource(R.drawable.key_bg_down);
                }
                return false;
            }

        });
        IButton.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View view, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_UP) {
                    IButton.setBackgroundResource(R.drawable.key_bg);
                } else if(event.getAction() == MotionEvent.ACTION_DOWN) {
                    IButton.setBackgroundResource(R.drawable.key_bg_down);
                }
                return false;
            }

        });
        JButton.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View view, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_UP) {
                    JButton.setBackgroundResource(R.drawable.key_bg);
                } else if(event.getAction() == MotionEvent.ACTION_DOWN) {
                    JButton.setBackgroundResource(R.drawable.key_bg_down);
                }
                return false;
            }

        });
        KButton.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View view, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_UP) {
                    KButton.setBackgroundResource(R.drawable.key_bg);
                } else if(event.getAction() == MotionEvent.ACTION_DOWN) {
                    KButton.setBackgroundResource(R.drawable.key_bg_down);
                }
                return false;
            }

        });
        LButton.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View view, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_UP) {
                    LButton.setBackgroundResource(R.drawable.key_bg);
                } else if(event.getAction() == MotionEvent.ACTION_DOWN) {
                    LButton.setBackgroundResource(R.drawable.key_bg_down);
                }
                return false;
            }

        });
        MButton.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View view, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_UP) {
                    MButton.setBackgroundResource(R.drawable.key_bg);
                } else if(event.getAction() == MotionEvent.ACTION_DOWN) {
                    MButton.setBackgroundResource(R.drawable.key_bg_down);
                }
                return false;
            }

        });
        NButton.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View view, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_UP) {
                    NButton.setBackgroundResource(R.drawable.key_bg);
                } else if(event.getAction() == MotionEvent.ACTION_DOWN) {
                    NButton.setBackgroundResource(R.drawable.key_bg_down);
                }
                return false;
            }

        });
        OButton.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View view, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_UP) {
                    OButton.setBackgroundResource(R.drawable.key_bg);
                } else if(event.getAction() == MotionEvent.ACTION_DOWN) {
                    OButton.setBackgroundResource(R.drawable.key_bg_down);
                }
                return false;
            }

        });
        PButton.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View view, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_UP) {
                    PButton.setBackgroundResource(R.drawable.key_bg);
                } else if(event.getAction() == MotionEvent.ACTION_DOWN) {
                    PButton.setBackgroundResource(R.drawable.key_bg_down);
                }
                return false;
            }

        });
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
        RButton.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View view, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_UP) {
                    RButton.setBackgroundResource(R.drawable.key_bg);
                } else if(event.getAction() == MotionEvent.ACTION_DOWN) {
                    RButton.setBackgroundResource(R.drawable.key_bg_down);
                }
                return false;
            }

        });
        SButton.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View view, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_UP) {
                    SButton.setBackgroundResource(R.drawable.key_bg);
                } else if(event.getAction() == MotionEvent.ACTION_DOWN) {
                    SButton.setBackgroundResource(R.drawable.key_bg_down);
                }
                return false;
            }

        });
        TButton.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View view, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_UP) {
                    TButton.setBackgroundResource(R.drawable.key_bg);
                } else if(event.getAction() == MotionEvent.ACTION_DOWN) {
                    TButton.setBackgroundResource(R.drawable.key_bg_down);
                }
                return false;
            }

        });
        UButton.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View view, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_UP) {
                    UButton.setBackgroundResource(R.drawable.key_bg);
                } else if(event.getAction() == MotionEvent.ACTION_DOWN) {
                    UButton.setBackgroundResource(R.drawable.key_bg_down);
                }
                return false;
            }

        });
        VButton.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View view, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_UP) {
                    VButton.setBackgroundResource(R.drawable.key_bg);
                } else if(event.getAction() == MotionEvent.ACTION_DOWN) {
                    VButton.setBackgroundResource(R.drawable.key_bg_down);
                }
                return false;
            }

        });
        WButton.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View view, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_UP) {
                    WButton.setBackgroundResource(R.drawable.key_bg);
                } else if(event.getAction() == MotionEvent.ACTION_DOWN) {
                    WButton.setBackgroundResource(R.drawable.key_bg_down);
                }
                return false;
            }

        });
        XButton.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View view, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_UP) {
                    XButton.setBackgroundResource(R.drawable.key_bg);
                } else if(event.getAction() == MotionEvent.ACTION_DOWN) {
                    XButton.setBackgroundResource(R.drawable.key_bg_down);
                }
                return false;
            }

        });
        YButton.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View view, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_UP) {
                    YButton.setBackgroundResource(R.drawable.key_bg);
                } else if(event.getAction() == MotionEvent.ACTION_DOWN) {
                    YButton.setBackgroundResource(R.drawable.key_bg_down);
                }
                return false;
            }

        });
        ZButton.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View view, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_UP) {
                    ZButton.setBackgroundResource(R.drawable.key_bg);
                } else if(event.getAction() == MotionEvent.ACTION_DOWN) {
                    ZButton.setBackgroundResource(R.drawable.key_bg_down);
                }
                return false;
            }

        });
        SpaceButton.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View view, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_UP) {
                    SpaceButton.setBackgroundResource(R.drawable.key_bg);
                } else if(event.getAction() == MotionEvent.ACTION_DOWN) {
                    SpaceButton.setBackgroundResource(R.drawable.key_bg_down);
                }
                return false;
            }

        });

        DeleteButton.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View view, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_UP) {
                    DeleteButton.setBackgroundResource(R.drawable.key_delete);
                } else if(event.getAction() == MotionEvent.ACTION_DOWN) {
                    DeleteButton.setBackgroundResource(R.drawable.key_bg_down);
                }
                return false;
            }

        });
        SpecialCharButton.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View view, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_UP) {
                    SpecialCharButton.setBackgroundResource(R.drawable.key_bg);
                } else if(event.getAction() == MotionEvent.ACTION_DOWN) {
                    SpecialCharButton.setBackgroundResource(R.drawable.key_bg_down);
                }
                return false;
            }

        });

    }
}
