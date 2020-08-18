package com.example.intproj;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    public EditText no1,no2;
    public Button add,sub,multi,divi;
    public TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        no1 = findViewById(R.id.n1);
        no2 = findViewById(R.id.n2);

        int num1 = getIntent().getIntExtra("number1",0);
        int num2 = getIntent().getIntExtra("number2",0);

        no1.setText(String.valueOf(num1));
        no2.setText(String.valueOf(num2));

        add =(Button) findViewById(R.id.btn1);
        sub = (Button) findViewById(R.id.btn2);
        multi= (Button) findViewById(R.id.btn3);
        divi=(Button) findViewById(R.id.btn4);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int n1 = Integer.parseInt(no1.getText().toString());
                int n2 = Integer.parseInt(no2.getText().toString());
                int add = n1 + n2;
                result.setText(String.valueOf(n1)+ "+" +String.valueOf(n2)+ "=" + String.valueOf(add));

            }
        });

        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int n1= Integer.parseInt(no1.getText().toString());
                int n2 = Integer.parseInt(no2.getText().toString());
                int sub = n1 - n2;
                result.setText(String.valueOf(n1) + "-" + String.valueOf(n2) + "=" + String.valueOf(sub));

            }
        });

        multi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int n1 = Integer.parseInt(no1.getText().toString());
                int n2 = Integer.parseInt(no2.getText().toString());
                int multi = n1 * n2;
                result.setText(String.valueOf(n1) + "*" + String.valueOf(n2) + "=" + String.valueOf(multi));

            }

        });
        divi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int n1 = Integer.parseInt(no1.getText().toString());
                int n2 = Integer.parseInt(no2.getText().toString());
                int divi = n1 - n2;
                result.setText(String.valueOf(n1) + "-" + String.valueOf(n2) + "=" + String.valueOf(divi));

            }

        });



    }
}