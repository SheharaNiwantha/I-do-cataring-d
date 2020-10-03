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

public class feedback extends AppCompatActivity {
    EditText txtfbname, txtfbEmail, txtfbfeedb;
    Button butFeedback,butUpdate,butDelete;
    DatabaseReference dbref;
    feedb std;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        txtfbname = findViewById(R.id.Uname);
        txtfbEmail = findViewById(R.id.Uemail);
        txtfbfeedb = findViewById(R.id.feedB);

        butFeedback = findViewById(R.id.SendB);
        butUpdate = findViewById(R.id.UpdateB);
        butDelete = findViewById(R.id.DeleteB);

        std = new feedb();

        butDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbref = FirebaseDatabase.getInstance().getReference().child("feedb").child("Std1");
                dbref.removeValue();
                Toast.makeText(getApplicationContext(),"Successfully deleted",Toast.LENGTH_SHORT).show();

            }
        });
        butUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbref = FirebaseDatabase.getInstance().getReference();
                dbref.child("feedb").child("Std1").child("name").setValue(txtfbname.getText().toString().trim());
                dbref.child("feedb").child("Std1").child("email").setValue(txtfbEmail.getText().toString().trim());
                dbref.child("feedb").child("Std1").child("message").setValue(txtfbfeedb.getText().toString().trim());
                dbref.child("Student/Std1/email").setValue(txtfbEmail.getText().toString().trim());
                Toast.makeText(getApplicationContext(),"Successfully update",Toast.LENGTH_SHORT).show();
                //clearControls();
            }
        });

        butFeedback.setOnClickListener(new View.OnClickListener () {
                                           @Override
                                           public void onClick(View v){
                                               dbref = FirebaseDatabase.getInstance().getReference().child("feedb");
                                               //try {
                                               if (TextUtils.isEmpty(txtfbname.getText().toString()))
                                                   Toast.makeText(getApplicationContext(), "Empty Name", Toast.LENGTH_SHORT).show();
                                               else if (TextUtils.isEmpty(txtfbEmail.getText().toString()))
                                                   Toast.makeText(getApplicationContext(), "Empty Email", Toast.LENGTH_SHORT).show();
                                               else if (TextUtils.isEmpty(txtfbfeedb.getText().toString()))
                                                   Toast.makeText(getApplicationContext(), "Empty Feedback", Toast.LENGTH_SHORT).show();
                                               else {
                                                   std.setName(txtfbname.getText().toString().trim());
                                                   std.setEmail(txtfbEmail.getText().toString().trim());
                                                   std.setMessage(txtfbfeedb.getText().toString().trim());

                                                   dbref.child("Std1").setValue(std);

                                                   Toast.makeText(getApplicationContext(), "Successfully inserted ", Toast.LENGTH_SHORT).show();
                                               }

                                           }
                                       }
        );


    }
    }
