package com.tp1_click;

import android.os.Build;
import android.support.annotation.IntegerRes;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.view.DragEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private String[] textouille = {
            "Trololol",
            "MDR",
            "PTDMDR",
            "ROFLMAO",
            "LOL",
            "YOLO",
            "SWAG",
            "XD"
    };
    private Integer num = 0;
    private ProgressBar progressBar;
    private TextView textView;
    private CheckBox checkBox;
    private SeekBar seekBar;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if(savedInstanceState != null) {

        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button) findViewById(R.id.button2);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        textView = (TextView) findViewById(R.id.textView);
        checkBox = (CheckBox) findViewById(R.id.checkBox);
        seekBar = (SeekBar) findViewById(R.id.seekBar);
        progressBar.setMax(textouille.length-1);
        seekBar.setMax(textouille.length-1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (num == textouille.length) {
                    num = 0;
                }
                displayMessages(checkBox, num, textView, progressBar, seekBar);
                num++;
            }
        });
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if(fromUser) {
                    displayMessages(checkBox, progress, textView, progressBar, seekBar);
                    num = progress + 1;
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void displayMessages(CheckBox checkBox, Integer progress, TextView textView , ProgressBar progressBar, SeekBar seekBar) {
        if (checkBox.isChecked()) {
            textView.setText(textouille[progress].toUpperCase());
        } else {
            textView.setText(textouille[progress].toLowerCase());
        }
        progressBar.setProgress(progress, true);
        seekBar.setProgress(progress,true);
    }
}
