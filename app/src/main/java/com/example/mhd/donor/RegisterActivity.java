package com.example.mhd.donor;

import android.content.Intent;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.mikepenz.materialize.color.Material;

public class RegisterActivity extends AppCompatActivity {
    Intent i ;
    String blood;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        i = new Intent(RegisterActivity.this,Register2Activity.class);
        setContentView(R.layout.activity_register);
        Button next = (Button) findViewById(R.id.next);
        final RadioGroup bloodType = (RadioGroup) findViewById(R.id.bloodType);
        bloodType.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                blood = ((RadioButton)findViewById(checkedId)).getText().toString();
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                i.putExtra("email",((EditText)findViewById(R.id.editText3)).getText().toString());
                i.putExtra("password",((EditText)findViewById(R.id.editText4)).getText().toString());
                i.putExtra("bloodType",blood);
                startActivity(i);
            }
                    });

                    }
                    }
