package com.example.intproj;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity2 extends AppCompatActivity {
    //create varibales
    Button btn4;
    Button btn6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        btn4 = findViewById(R.id.button8);
        btn6 = findViewById(R.id.button10);
    }
    @Override
    protected void onResume() {
        super.onResume();
        //navigate interfaces
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent( MainActivity2.this, MainActivity4.class);
                startActivity(intent);
            }
        });


        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1= new Intent( MainActivity2.this, CheckFood.class);

                startActivity(intent1);
            }
        });

    }
}