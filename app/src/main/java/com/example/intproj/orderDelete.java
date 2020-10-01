package com.example.intproj;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class orderDelete extends AppCompatActivity {


    Button btnDelete;
    DatabaseReference dbDel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_delete);

        btnDelete = findViewById(R.id.btnYes1);

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbDel = FirebaseDatabase.getInstance().getReference().child("OrderDB/Order1");
                dbDel.removeValue();
                Toast.makeText(getApplicationContext(),"Your cancellation is successfully. Thank you!.",Toast.LENGTH_SHORT).show();

            }
        });


    }



}