package com.example.harsh.bcalc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        Bundle bundle=getIntent().getExtras();
        String bmi1=bundle.getString("BMI");
        TextView textView=(TextView) findViewById(R.id.result);
        textView.setText(bmi1);
    }


}
