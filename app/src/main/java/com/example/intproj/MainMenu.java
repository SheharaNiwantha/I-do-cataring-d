package com.example.intproj;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainMenu extends AppCompatActivity {
    //create variables
    Button btn;
    Button btn1;
    Button btn2;

    ImageButton imageButton12, imageButton11, imageButton10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_menu);

        btn = findViewById(R.id.button9);
        btn1 = findViewById(R.id.button7);
        btn2 = findViewById(R.id.button11);
        imageButton12 = findViewById(R.id.imageButton12);
        imageButton11 = findViewById(R.id.imageButton11);
        imageButton10 = findViewById(R.id.imageButton10);
    }

    @Override
    //navigate interfaces
    protected void onResume() {
        super.onResume();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent( MainMenu.this, MainActivity3.class);
                startActivity(intent);
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1= new Intent( MainMenu.this, Menuu2.class);

                startActivity(intent1);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1= new Intent( MainMenu.this, Menu3.class);

                startActivity(intent1);
            }
        });
        imageButton12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2= new Intent( MainMenu.this, MainActivity2.class);

                startActivity(intent2);
            }
        });
        imageButton11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2= new Intent( MainMenu.this, orders.class);

                startActivity(intent2);

            }
        });
        imageButton10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2= new Intent( MainMenu.this, feedback.class);

                startActivity(intent2);

            }
        });



    }
}