package com.example.harsh.bcalc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText height, weight;
    Button calculatebmi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        height = findViewById(R.id.height);
        weight = findViewById(R.id.weight);
        calculatebmi = findViewById(R.id.calculatebmi);

        calculatebmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String heightStr = height.getText().toString();
                String weightStr = weight.getText().toString();
                if (heightStr.isEmpty() || weightStr.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "not valid", Toast.LENGTH_SHORT).show();
                } else {

                    calculate();
                }
            }
        });
    }

    private void calculate() {
        String heightStr=height.getText().toString();
        String weightStr=weight.getText().toString();
        if((heightStr != null && !"".equals(heightStr)) && (weightStr!=null && !"".equals(weightStr))){
            float heightvalue=Float.parseFloat(heightStr)/100;
            float weightvalue=Float.parseFloat(weightStr);
            float bmi =weightvalue/(heightvalue*heightvalue);
            openactivity2(bmi);
        }
    }

    private void openactivity2(float bmi) {
        String bmiLabel="";
        if (Float.compare(bmi,18.5f)<0){
            bmiLabel="Underweight";
        }else if(Float.compare(bmi,18.5f)>=0 && Float.compare(bmi,24.9f)<=0){
            bmiLabel="Normal";
        }
        else if(Float.compare(bmi,24.9f)>0 && Float.compare(bmi,29.9f)<=0){
            bmiLabel="Overweight";
        }else if (Float.compare(bmi,30f)>=0){
            bmiLabel="Obese";
        }
        bmiLabel=bmi + "\n" + bmiLabel;

        Intent intent = new Intent(this, Activity2.class);
        intent.putExtra("BMI",bmiLabel);
        startActivity(intent);


    }

}


