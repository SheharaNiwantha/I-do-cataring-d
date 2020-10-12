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

public class Register extends AppCompatActivity {

    EditText txtFname, txtLname, txtEmail, txtPassword, txtCpassword;
    Button butRegister;
    DatabaseReference dbref;
    Customer std;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        txtFname = findViewById(R.id.iname);
        txtLname = findViewById(R.id.ILname2);
        txtEmail = findViewById(R.id.iemail);
        txtPassword = findViewById(R.id.IPassword2);
        txtCpassword = findViewById(R.id.iconfirmpassword);

        butRegister = findViewById(R.id.registerB);

        std = new Customer();

        butRegister.setOnClickListener(new View.OnClickListener () {
            @Override
            public void onClick(View v){
                dbref = FirebaseDatabase.getInstance().getReference().child("Customer");
                //try {
                    if (TextUtils.isEmpty(txtFname.getText().toString()))
                        Toast.makeText(getApplicationContext(), "Empty First Name", Toast.LENGTH_SHORT).show();
                    else if (TextUtils.isEmpty(txtLname.getText().toString()))
                        Toast.makeText(getApplicationContext(), "Empty Last Name", Toast.LENGTH_SHORT).show();
                    else if (TextUtils.isEmpty(txtEmail.getText().toString()))
                        Toast.makeText(getApplicationContext(), "Empty Email", Toast.LENGTH_SHORT).show();
                    else if (TextUtils.isEmpty(txtPassword.getText().toString()))
                        Toast.makeText(getApplicationContext(), "Empty Password", Toast.LENGTH_SHORT).show();
                    else if (TextUtils.isEmpty(txtCpassword.getText().toString()))
                        Toast.makeText(getApplicationContext(), "Empty Password", Toast.LENGTH_SHORT).show();
                    else {
                        std.setFname(txtFname.getText().toString().trim());
                        std.setLname(txtLname.getText().toString().trim());
                        std.setEmail(txtEmail.getText().toString().trim());
                        std.setPassword(txtPassword.getText().toString().trim());
                        std.setCpassword(txtCpassword.getText().toString().trim());

                        dbref.child("1").setValue(std);

                        Toast.makeText(getApplicationContext(), "Successfully inserted ", Toast.LENGTH_SHORT).show();
                    }

                        }
                }
                //catch (NumberFormatException nfe) {
                   // Toast.makeText(getApplicationContext(), "Invalid Contact No", Toast.LENGTH_SHORT).show();


        );


    }
}