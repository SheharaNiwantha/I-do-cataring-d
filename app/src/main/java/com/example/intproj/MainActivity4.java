package com.example.intproj;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity4 extends AppCompatActivity {

        EditText txtMenu,txtFood,txtPrice;
        Button butsave,butshow,butupdate,butDelete;
        DatabaseReference dbRef;
        MenuName Mname;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        txtMenu=findViewById(R.id.edmenu);
        txtFood=findViewById(R.id.edfood);
        txtPrice=findViewById(R.id.edprice);

        butsave=findViewById(R.id.btnsave);
        butshow=findViewById(R.id.btnshow);
        butupdate=findViewById(R.id.btnupdate);
        butDelete=findViewById(R.id.btnDelete);

        Mname = new MenuName();

        /*butDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbRef = FirebaseDatabase.getInstance().getReference().child("MenuName/Mname1");
                dbRef.removeValue();
                Toast.makeText(getApplicationContext(),"Successfull Deleted",Toast.LENGTH_SHORT).show();

            }
        });*/

        butupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbRef = FirebaseDatabase.getInstance().getReference();
                dbRef.child("MenuName/Mname1/menu").setValue(txtMenu.getText().toString().trim());
                dbRef.child("MenuName/Mname1/food").setValue(txtFood.getText().toString().trim());
                Toast.makeText(getApplicationContext(),"Successfull Updated",Toast.LENGTH_SHORT).show();
                clearControls();
            }
        });

        butshow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbRef = FirebaseDatabase.getInstance().getReference().child("MenuName/Mname1");
                dbRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if (dataSnapshot.hasChildren()){
                            txtMenu.setText(dataSnapshot.child("menu").getValue().toString());
                            txtFood.setText(dataSnapshot.child("food").getValue().toString());
                            txtPrice.setText(dataSnapshot.child("price").getValue().toString());
                        }
                        else {
                            Toast.makeText(getApplicationContext(),"Can not find Mname1",Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });

        butsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            dbRef = FirebaseDatabase.getInstance().getReference().child("MenuName");
            try {
                if (TextUtils.isEmpty(txtMenu.getText().toString()))
                    Toast.makeText(getApplicationContext(),  "Empty Menu",Toast.LENGTH_SHORT).show();
                else if (TextUtils.isEmpty(txtFood.getText().toString()))
                    Toast.makeText(getApplicationContext(),  "Empty Food",Toast.LENGTH_SHORT).show();
                else if (TextUtils.isEmpty(txtPrice.getText().toString()))
                    Toast.makeText(getApplicationContext(),  "Empty Price",Toast.LENGTH_SHORT).show();
                else {
                    Mname.setMenu(txtMenu.getText().toString().trim());
                    Mname.setFood(txtFood.getText().toString().trim());
                    Mname.setPrice(Integer.parseInt( txtPrice.getText().toString().trim()));
                    dbRef.child("Mname1").setValue(Mname);
                    Toast.makeText(getApplicationContext(),"Successfull Inserted",Toast.LENGTH_SHORT).show();
                    clearControls();
                }
            }
            catch (NumberFormatException nfe){
                Toast.makeText(getApplicationContext(),"Invalid",Toast.LENGTH_SHORT).show();
            }



        };
    });
    }

    private void clearControls() {
        txtMenu.setText("");
        txtFood.setText("");
        txtPrice.setText("");
    }
}