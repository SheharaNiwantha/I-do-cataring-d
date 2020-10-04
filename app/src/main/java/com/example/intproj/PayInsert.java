package com.example.intproj;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class PayInsert extends AppCompatActivity {

    EditText editTextCNumber,editTextCVV,editTextPNumber;
    Button btnPay1;
    DatabaseReference dbRef;
    PaymentDB pdb1;

 //   ListView listViewPayments;

//    List<PaymentDB> PaymentList;

    private void clearControls(){
        editTextCNumber.setText("");
        editTextCVV.setText("");
        editTextPNumber.setText("");
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay_insert);

        editTextCNumber = findViewById(R.id.editTextCNumber);
        editTextCVV = findViewById(R.id.editTextCVV);
        editTextPNumber = findViewById(R.id.editTextPNumber);

        btnPay1 = findViewById(R.id.btnPay1);

        pdb1 = new PaymentDB();

       // listViewPayments = (ListView) findViewById(R.id.listViewPayments);

        //PaymentList = new ArrayList<>();




        btnPay1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbRef= FirebaseDatabase.getInstance().getReference().child("PaymentDB");

                try {
                    if(TextUtils.isEmpty(editTextCNumber.getText().toString()))
                        Toast.makeText(getApplicationContext(),"Please enter Card Number", Toast.LENGTH_SHORT).show();
                    else if(TextUtils.isEmpty(editTextCVV.getText().toString()))
                        Toast.makeText(getApplicationContext(),"Please enter CVV", Toast.LENGTH_SHORT).show();
                    else if(TextUtils.isEmpty(editTextPNumber.getText().toString()))
                        Toast.makeText(getApplicationContext(),"Please enter Phone number", Toast.LENGTH_SHORT).show();
                    else{
                        pdb1.setcNumber(editTextCNumber.getText().toString().trim());
                        pdb1.setCvv(editTextCVV.getText().toString().trim());
                        pdb1.setpNumber(editTextPNumber.getText().toString().trim());



                        //insert into database
                        dbRef.child("Payment1").setValue(pdb1);

                        Toast.makeText(getApplicationContext(),"Data Saved Successfully", Toast.LENGTH_SHORT).show();
                        clearControls();
                    }
                } catch (NumberFormatException e) {
                    Toast.makeText(getApplicationContext(),"Invalid input", Toast.LENGTH_SHORT).show();
                }


            }
        });
    }}

  /*  @Override
    protected void onStart() {
        super.onStart();

        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                PaymentList.clear();
                for(DataSnapshot PaymentDBSnapshot : DataSnapshot.getChildren()){
                    PaymentDB paymentDB = PaymentDBSnapshot.getValue(PaymentDB.class);

                    PaymentList.add(PaymentDB);
                }

                PaymentList adapter = new PaymentList(PayInsert.this, PaymentList);
                listViewPayments.setAdapter(adapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}*/