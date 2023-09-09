package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText edtWeight, edtHeightFt, edtHeightIn;
        Button btnCalculate;
        TextView txtResult;
        LinearLayout llMain;

        edtWeight = findViewById(R.id.edtWeight);
        edtHeightIn = findViewById(R.id.edtHeightIn);
        edtHeightFt = findViewById(R.id.edtHeightFt);
        btnCalculate = findViewById(R.id.btnCalculate);
        txtResult = findViewById(R.id.txtResult);
        llMain = findViewById(R.id.llMain);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              int wt =   Integer.parseInt( edtWeight.getText().toString());
              int ft = Integer.parseInt(edtHeightFt.getText().toString());
              int in = Integer.parseInt(edtHeightIn.getText().toString());

              int totalIn = ft*12 +in;
              double totalCm = totalIn*2.53;
              double totalM = totalCm/100;
              double bmi = wt/(totalM*totalM);

              if (bmi>25) {
                  txtResult.setText("You are OverWeight");
                  llMain.setBackgroundColor(getResources().getColor(R.color.colorOW));
              }else if(bmi<18){
                  txtResult.setText("You are UnderWeight");
                  llMain.setBackgroundColor(getResources().getColor(R.color.colorUW));
              }else {
                  txtResult.setText("Your are Healthy");
                  llMain.setBackgroundColor(getResources().getColor(R.color.colorH));
              }


            }
        });


    }
}