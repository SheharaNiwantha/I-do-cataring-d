package com.example.intproj;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class InsertOrder extends AppCompatActivity {

    EditText editTextName, editTextEmailAddress, editTextNumber, editTextMultiLineAddress, editTextNumberMenu, editTextNumberPlates, editTextDate, editTextTime;
    Button btnOrder, btnTotalPrice;
    DatabaseReference dbRef;
    OrderDB ord;
    TextView tvCal;



    private void clearControls() {
        editTextName.setText("");
        editTextEmailAddress.setText("");
        editTextNumber.setText("");
        editTextMultiLineAddress.setText("");
        editTextNumberMenu.setText("");
        editTextNumberPlates.setText("");
        editTextDate.setText("");
        editTextTime.setText("");
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.insert_order);

        btnOrder = findViewById(R.id.btnOrder);
        btnTotalPrice = findViewById(R.id.btnTotalPrice);

        editTextName = findViewById((R.id.editTextNameI));
        editTextEmailAddress = findViewById((R.id.editTextEmailAddressI));
        editTextNumber = findViewById((R.id.editTextNumberI));
        editTextMultiLineAddress = findViewById((R.id.editTextMultiLineAddressI));
        editTextNumberMenu = findViewById((R.id.editTextNumberMenuI));
        editTextNumberPlates = findViewById((R.id.editTextNumberPlatesI));
        editTextDate = findViewById((R.id.editTextDateI));
        editTextTime = findViewById((R.id.editTextTimeI));

        tvCal = findViewById((R.id.tvCal));

        ord = new OrderDB();



        btnOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbRef = FirebaseDatabase.getInstance().getReference().child("OrderDB");


                try {
                    if (TextUtils.isEmpty(editTextName.getText().toString()))
                        Toast.makeText(getApplicationContext(), "Please enter a Name", Toast.LENGTH_SHORT).show();
                    else if (TextUtils.isEmpty(editTextEmailAddress.getText().toString()))
                        Toast.makeText(getApplicationContext(), "Please enter an Email", Toast.LENGTH_SHORT).show();
                    else if (TextUtils.isEmpty(editTextNumber.getText().toString()))
                        Toast.makeText(getApplicationContext(), "Please enter a Contact Number", Toast.LENGTH_SHORT).show();
                    else if (TextUtils.isEmpty(editTextMultiLineAddress.getText().toString()))
                        Toast.makeText(getApplicationContext(), "Please enter an Address", Toast.LENGTH_SHORT).show();
                    else if (TextUtils.isEmpty(editTextNumberMenu.getText().toString()))
                        Toast.makeText(getApplicationContext(), "Please enter a Menu Number", Toast.LENGTH_SHORT).show();
                    else if (TextUtils.isEmpty(editTextNumberPlates.getText().toString()))
                        Toast.makeText(getApplicationContext(), "Please enter Number of plates", Toast.LENGTH_SHORT).show();
                    else if (TextUtils.isEmpty(editTextDate.getText().toString()))
                        Toast.makeText(getApplicationContext(), "Please enter a Date", Toast.LENGTH_SHORT).show();
                    else if (TextUtils.isEmpty(editTextTime.getText().toString()))
                        Toast.makeText(getApplicationContext(), "Please enter a Time", Toast.LENGTH_SHORT).show();
                    else {
                        ord.setName(editTextName.getText().toString().trim());
                        ord.setEmail(editTextEmailAddress.getText().toString().trim());
                        ord.setCno(Integer.parseInt(editTextNumber.getText().toString().trim()));
                        ord.setAddress(editTextMultiLineAddress.getText().toString().trim());
                        ord.setMenuNo(Integer.parseInt(editTextNumberMenu.getText().toString().trim()));
                        ord.setNumOfPlates(Integer.parseInt(editTextNumberPlates.getText().toString().trim()));
                        ord.setDate(editTextDate.getText().toString().trim());
                        ord.setTime(editTextTime.getText().toString().trim());

                        //insert into database
                        dbRef.child("Order1").setValue(ord);


                        Toast.makeText(getApplicationContext(), "Data Saved Successfully", Toast.LENGTH_SHORT).show();
                        clearControls();





                    }
                } catch (NumberFormatException e) {
                    Toast.makeText(getApplicationContext(), "Invalid", Toast.LENGTH_SHORT).show();
                    Intent intent= new Intent( InsertOrder.this, Payment.class);
                    startActivity(intent);

                }



            }
        });


        btnTotalPrice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int plates = Integer.parseInt(editTextNumberPlates.getText().toString());
                int menu = Integer.parseInt(editTextNumberMenu.getText().toString());

                if (menu == 1){
                int sum = plates * 1400;
                tvCal.setText("Total Price = RS: " + String.valueOf(sum));}
                else if(menu == 2){
                    int sum = plates * 1600;
                    tvCal.setText("Total Price = RS: " + String.valueOf(sum));
                }
                else if (menu == 3) {
                    int sum = plates * 2000;
                    tvCal.setText("Total Price = RS: " + String.valueOf(sum));
                }

            }

        });

    }


}

