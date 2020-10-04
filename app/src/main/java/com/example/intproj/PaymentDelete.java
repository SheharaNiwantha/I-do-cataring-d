package com.example.intproj;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class PaymentDelete extends AppCompatActivity {


    Button btnDelete,btnNo;
    DatabaseReference dbDel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_delete);

        btnDelete = findViewById(R.id.btnYes1);
        btnNo = findViewById(R.id.btnNo);

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override                                      //Deleting records
            public void onClick(View view) {
                dbDel = FirebaseDatabase.getInstance().getReference().child("PaymentDB");
                dbDel.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if (dataSnapshot.hasChild("Payment1")){

                            dbDel = FirebaseDatabase.getInstance().getReference().child("PaymentDB").child("Payment1");
                            dbDel.removeValue();
                            Toast.makeText(PaymentDelete.this,"Deleted Successfully",Toast.LENGTH_SHORT).show();
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
                Intent intent = new Intent(PaymentDelete.this, PaymentRecord.class);
                startActivity(intent);

            }
        });

    }



}