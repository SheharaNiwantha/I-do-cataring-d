package com.example.intproj;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class orderUpdate extends AppCompatActivity {

    EditText editTextName2, editTextEmailAddress2, editTextNumber2, editTextMultiLineAddress2, editTextNumberMenu2, editTextNumberPlates2, editTextDate2, editTextTime2;
    Button btnPre, btnUpdate;
    DatabaseReference dbRef, upRef;
    OrderDB ord;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_update);

        btnPre = findViewById(R.id.btnPre);
        btnUpdate = findViewById(R.id.btnUpdate);

        editTextName2 = findViewById((R.id.editTextName2));
        editTextEmailAddress2 = findViewById((R.id.editTextEmailAddress2));
        editTextNumber2 = findViewById((R.id.editTextNumber2));
        editTextMultiLineAddress2 = findViewById((R.id.editTextMultiLineAddress2));
        editTextNumberMenu2 = findViewById((R.id.editTextNumberMenu2));
        editTextNumberPlates2 = findViewById((R.id.editTextNumberPlates2));
        editTextDate2 = findViewById((R.id.editTextDate2));
        editTextTime2 = findViewById((R.id.editTextTime2));

        ord = new OrderDB();

        btnPre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbRef = FirebaseDatabase.getInstance().getReference().child("OrderDB").child("Order1");
                dbRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if (dataSnapshot.hasChildren()){
                            editTextName2.setText(dataSnapshot.child("name").getValue().toString());
                            editTextEmailAddress2.setText(dataSnapshot.child("email").getValue().toString());
                            editTextNumber2.setText(dataSnapshot.child("cno").getValue().toString());
                            editTextMultiLineAddress2.setText(dataSnapshot.child("address").getValue().toString());
                            editTextNumberMenu2.setText(dataSnapshot.child("menuNo").getValue().toString());
                            editTextNumberPlates2.setText(dataSnapshot.child("numOfPlates").getValue().toString());
                            editTextDate2.setText(dataSnapshot.child("date").getValue().toString());
                            editTextTime2.setText(dataSnapshot.child("time").getValue().toString());


                        }
                        else {
                            Toast.makeText(getApplicationContext(),"No source to Display",Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                upRef = FirebaseDatabase.getInstance().getReference().child("OrderDB");
                upRef.addListenerForSingleValueEvent(new ValueEventListener(){

                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if(dataSnapshot.hasChild("Order1")){
                            try{
                                ord.setName(editTextName2.getText().toString().trim());
                                ord.setEmail(editTextEmailAddress2.getText().toString().trim());
                                ord.setCno(Integer.parseInt(editTextNumber2.getText().toString().trim()));
                                ord.setAddress(editTextMultiLineAddress2.getText().toString().trim());
                                ord.setMenuNo(Integer.parseInt(editTextNumberMenu2.getText().toString().trim()));
                                ord.setNumOfPlates(Integer.parseInt(editTextNumberPlates2.getText().toString().trim()));
                                ord.setDate(editTextDate2.getText().toString().trim());
                                ord.setTime(editTextTime2.getText().toString().trim());

                                upRef=FirebaseDatabase.getInstance().getReference().child("OrderDB").child("Order1");
                                upRef.setValue(ord);

                                Toast.makeText(getApplicationContext(),"Your changes saved successfully",Toast.LENGTH_SHORT).show();

                                Intent intent = new Intent(orderUpdate.this, orders.class);
                                startActivity(intent);

                            }
                            catch (NumberFormatException e){
                                Toast.makeText(getApplicationContext(),"Invalid",Toast.LENGTH_SHORT).show();
                            }
                        }
                        else{
                            Toast.makeText(getApplicationContext(),"No source to Update",Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });

            }
        });

    }




}