package com.example.intproj;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class PaymentRecord extends AppCompatActivity {



    Button btn,btn2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_record);

        btn2 = findViewById(R.id.btnDeleteR);
    }

    @Override
    protected void onResume() {
        super.onResume();

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(PaymentRecord.this, PaymentDelete.class);
                startActivity(intent1);

            }
        });
    }

}