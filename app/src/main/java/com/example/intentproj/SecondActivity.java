package com.example.intentproj;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    private TextView number1, number2;
    private TextView display;
    private Button btnPlus, btnMinus, btnDivision, btnMultiplication;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Intent intent = getIntent();

        btnPlus = findViewById(R.id.bnAdd);
        btnMinus = findViewById(R.id.bnMinus);
        btnDivision = findViewById(R.id.bnDivision);
        btnMultiplication = findViewById(R.id.bnMulti);
        number1 = findViewById(R.id.number1);
        number2 = findViewById(R.id.number2);
        display = findViewById(R.id.display);

        String num1 = intent.getStringExtra("number1");
        String  num2 = intent.getStringExtra("number2");

        number1.setText(num1);
        number2.setText(num2);

        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double num1 = Double.parseDouble(number1.getText().toString());
                double num2 = Double.parseDouble(number2.getText().toString());

                double value = num1 + num2;

                displayValues(value);
            }
        });

        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double num1 = Double.parseDouble(number1.getText().toString());
                double num2 = Double.parseDouble(number2.getText().toString());

                double value = num1 - num2;

                displayValues(value);
            }
        });

        btnMultiplication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double num1 = Double.parseDouble(number1.getText().toString());
                double num2 = Double.parseDouble(number2.getText().toString());

                double value = num1 * num2;

                displayValues(value);
            }
        });

        btnDivision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double num1 = Double.parseDouble(number1.getText().toString());
                double num2 = Double.parseDouble(number2.getText().toString());

                try {
                    double value = num1 / num2;
                    displayValues(value);
                } catch (Exception e) {
                    displayError("Error in Division");
                }
            }
        });
    }

    public void displayValues(double value) {
        display.setText(((Double) value).toString());
    }

    public void displayError(String message) {
        display.setText(message);
    }
}