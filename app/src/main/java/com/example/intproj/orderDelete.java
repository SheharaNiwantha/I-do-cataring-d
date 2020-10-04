package com.example.intproj;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;

public class orderDelete extends AppCompatActivity {


    Button btnDelete,btnNo;
    DatabaseReference dbDel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_delete);

        btnDelete = findViewById(R.id.btnYes1);
        btnNo = findViewById(R.id.btnNo);

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbDel = FirebaseDatabase.getInstance().getReference().child("OrderDB");
                dbDel.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if (dataSnapshot.hasChild("Order1")){

                            dbDel = FirebaseDatabase.getInstance().getReference().child("OrderDB").child("Order1");
                            dbDel.removeValue();
                            Toast.makeText(orderDelete.this,"Your cancellation is successfully. Thank you!.",Toast.LENGTH_SHORT).show();
                        }
                        else {
                            Toast.makeText(getApplicationContext(),"No source to Delete",Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });

        btnNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(orderDelete.this, orders.class);
                startActivity(intent);

            }
        });

    }



}