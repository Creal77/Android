package com.example.tp2;

import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.LinearLayout;

import java.util.Random;

public class CodeActivity extends AppCompatActivity {

    Intent main;
    String message = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_code);
        Button[] buttons = new Button[9];
        main = new Intent(this, MainActivity.class);
        Random random = new Random();
        int alea = 8;
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.linearLayout2);
        LinearLayout linearLayout1 = (LinearLayout) findViewById(R.id.linearLayout3);
        LinearLayout linearLayout2 = (LinearLayout) findViewById(R.id.linearLayout4);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.MATCH_PARENT, 3);
        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new Button(this);
            int num = random.nextInt(alea);
            alea--;
            num++;
            buttons[i].setText("" + num);
            buttons[i].setLayoutParams(layoutParams);
            buttons[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    message += this.toString();
                }
            });
            if (i < 3) {
                linearLayout.addView(buttons[i]);
            }
            else if (i >= 3 && i < 6) {
                linearLayout1.addView(buttons[i]);
            }
            else if (i >= 6 && i < 9) {
                linearLayout2.addView(buttons[i]);
            }
        }
        Button ok = (Button) findViewById(R.id.button3);
        main = new Intent(this, MainActivity.class);
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                main.putExtra(Intent.EXTRA_TEXT, message);
                startActivity(main);
            }
        });

    }
}
