package com.example.intentproj;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class FirstActivity extends AppCompatActivity {
    private Button okBtn;
    private EditText number1, number2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        okBtn = findViewById(R.id.btnOk);
        number1 = findViewById(R.id.number1);
        number2 = findViewById(R.id.number2);

        okBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater inflater = getLayoutInflater();
                View toastView = inflater.inflate(R.layout.custom_toast, (ViewGroup)findViewById(R.id.toastLayout));
                TextView message = toastView.findViewById(R.id.toastMessage);
                message.setText("Sending numbers for Calculation");

                Toast toast = new Toast(getApplicationContext());
                toast.setView(toastView);
                toast.setGravity(Gravity.BOTTOM,0, 0);
                toast.setDuration(Toast.LENGTH_LONG);
                toast.show();

                Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
                intent.putExtra("number1", number1.getText().toString());
                Log.d("Value", number1.getText().toString());
                intent.putExtra("number2", number2.getText().toString());
                startActivity(intent);
            }
        });
    }
}