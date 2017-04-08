package com.example.mhd.donor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class RegisterActivity extends AppCompatActivity {
    Intent i ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        i = new Intent(RegisterActivity.this,Register2Activity.class);
        setContentView(R.layout.activity_register);
        Button next = (Button) findViewById(R.id.next);
        ImageView Aplus = (ImageView) findViewById(R.id.Aplus);
        ImageView Aminus = (ImageView) findViewById(R.id.Aplus);
        ImageView ABplus = (ImageView) findViewById(R.id.Aplus);
        ImageView ABminus = (ImageView) findViewById(R.id.Aplus);
        ImageView Bplus = (ImageView) findViewById(R.id.Aplus);
        ImageView Bminus = (ImageView) findViewById(R.id.Aplus);
        ImageView Ominus = (ImageView) findViewById(R.id.Aplus);
        ImageView Oplus = (ImageView) findViewById(R.id.Aplus);

        Aplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i.putExtra("bloodType",((EditText)findViewById(R.id.editText3)).getText().toString());
            }
        });
        Aminus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i.putExtra("bloodType",((EditText)findViewById(R.id.editText3)).getText().toString());
            }
        });
        ABplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i.putExtra("bloodType",((EditText)findViewById(R.id.editText3)).getText().toString());
            }
        });
        ABminus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i.putExtra("bloodType",((EditText)findViewById(R.id.editText3)).getText().toString());
            }
        });
        Bplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i.putExtra("bloodType",((EditText)findViewById(R.id.editText3)).getText().toString());
            }
        });
        Bminus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i.putExtra("bloodType",((EditText)findViewById(R.id.editText3)).getText().toString());
            }
        });
        Ominus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i.putExtra("bloodType",((EditText)findViewById(R.id.editText3)).getText().toString());
            }
        });
        Oplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i.putExtra("bloodType",((EditText)findViewById(R.id.editText3)).getText().toString());
            }
        });














        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i.putExtra("email",((EditText)findViewById(R.id.editText3)).getText().toString());
                i.putExtra("password",((EditText)findViewById(R.id.editText4)).getText().toString());
                startActivity(i);
            }
        });

    }
}
