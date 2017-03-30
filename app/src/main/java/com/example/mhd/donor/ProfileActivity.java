package com.example.mhd.donor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class ProfileActivity extends AppCompatActivity {


    boolean lock=true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);



        final EditText textname = (EditText) findViewById(R.id.textName);
        final EditText textemail = (EditText) findViewById(R.id.textEmail);
        final EditText textCivil = (EditText) findViewById(R.id.textCivil);
        final EditText textPassword = (EditText) findViewById(R.id.textPassword);
        final EditText textblood = (EditText) findViewById(R.id.textBlood);
        final EditText textBirth = (EditText) findViewById(R.id.textBirthDate);
        final EditText textNationalty = (EditText) findViewById(R.id.textNationalty);
        final RadioButton radioMale = (RadioButton) findViewById(R.id.radioMale);
        final RadioButton radioFmale = (RadioButton) findViewById(R.id.radioFemale);

        final EditText textPhone = (EditText) findViewById(R.id.textPhone);

        Button editbutton = (Button)findViewById(R.id.editbutton);
        editbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                textname.setEnabled(lock);
                textBirth.setEnabled(lock);
                textblood.setEnabled(lock);
                textCivil.setEnabled(lock);
                textemail.setEnabled(lock);

                textNationalty.setEnabled(lock);
                textPhone.setEnabled(lock);
                textPassword.setEnabled(lock);
                radioFmale.setEnabled(lock);
                radioMale.setEnabled(lock);

                lock=!lock;
            }
        });







    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        this.finish();
        return super.onOptionsItemSelected(item);
    }


}
