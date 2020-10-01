package com.example.intproj;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Menuu2 extends AppCompatActivity {

    Button button6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menuu2);


        button6 = findViewById(R.id.button6);

    }
    @Override
    protected void onResume() {
        super.onResume();

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent( Menuu2.this, InsertOrder.class);
                startActivity(intent);
            }
        });
    }
}