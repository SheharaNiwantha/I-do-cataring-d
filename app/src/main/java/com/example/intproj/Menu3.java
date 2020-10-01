package com.example.intproj;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Menu3 extends AppCompatActivity {

    Button button12;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu3);


        button12 = findViewById(R.id.button8);

    }
    @Override
    protected void onResume() {
        super.onResume();

        button12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent( Menu3.this, InsertOrder.class);
                startActivity(intent);
            }
        });
    }
}