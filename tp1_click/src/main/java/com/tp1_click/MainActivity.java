package com.tp1_click;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    String[] textouille= {
      "Trololol",
      "MDR",
      "PTDMDR",
      "ROFLMAO"
    };
    Integer num = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button)findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckBox checkBox = (CheckBox)findViewById(R.id.checkBox);
                if(num == textouille.length) {
                    num = 0;
                }
                TextView textView = (TextView)findViewById(R.id.textView);
                if(checkBox.isChecked()){
                    textView.setText(textouille[num].toUpperCase());
                }
                else {
                    textView.setText(textouille[num].toLowerCase());
                }
                num++;
            }
        });
    }
}
