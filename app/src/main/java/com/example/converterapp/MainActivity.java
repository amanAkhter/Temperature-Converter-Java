package com.example.converterapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    Button ansBtn, againBtn;
    EditText getVal;
    TextView showAns;
    RadioButton c2f, f2c;
    Double x;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Assigning ids to the variables
        ansBtn = (Button) findViewById(R.id.ansBtn);
        againBtn = (Button) findViewById(R.id.againBtn);
        getVal = (EditText) findViewById(R.id.getVal);
        showAns = (TextView) findViewById(R.id.showAns);
        c2f = (RadioButton) findViewById(R.id.c2f);
        f2c = (RadioButton) findViewById(R.id.f2c);

//        Setting onClick Listener for "Convert Button"
        ansBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (getVal.getText().toString().isEmpty()){
                    showAns.setText("Please enter a number!");
                }
                else {
//                    Parsing the String value to Double
                    x = Double.parseDouble(String.valueOf(getVal.getText()));

//                    Checking which radio button is checked
                    if (c2f.isChecked()){
                        x = (x * 9/5) + 32;
//                        formatting the double decimal places
                        x = Double.parseDouble(new DecimalFormat("##.###").format(x));
                        showAns.setText(x + "°F");
                    }
                    else if (f2c.isChecked()){
                        x = (x - 32) * 5/9;
//                        formatting the double decimal places
                        x = Double.parseDouble(new DecimalFormat("##.###").format(x));
                        showAns.setText(x + "°C");
                    }
                    else {
                        showAns.setText("Please select any one option!");
                    }
                }
            }
        });

//        Setting onClick Listener for "Again Button"
        againBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Resetting everything
                showAns.setText("0.0");
                getVal.setText("");
                c2f.setChecked(false);
                f2c.setChecked(false);
            }
        });


    }
}