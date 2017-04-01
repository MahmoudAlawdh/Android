package com.example.mhd.donor;

import android.content.SharedPreferences;
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

import org.json.JSONException;
import org.json.JSONObject;

public class ProfileActivity extends AppCompatActivity {


    boolean lock=true;
    public final static String Filee ="donor";
    public final static String profile ="profile";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);


        SharedPreferences preferences=getSharedPreferences(Filee,MODE_PRIVATE);
        String p=preferences.getString(profile,"notfound");
        Toast.makeText(this, p, Toast.LENGTH_SHORT).show();

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
        try {
            JSONObject myprofile = new JSONObject(p);
            textname.setText(myprofile.getString("firstName")+" "+myprofile.getString("lastName"));
            textemail.setText(myprofile.getString("email"));
            textCivil.setText(myprofile.getString("civilId"));
            textPassword.setText(myprofile.getString("password"));
            textblood.setText(myprofile.getString("bloodType"));
            textBirth.setText(myprofile.getString("birthDate"));
            textNationalty.setText(myprofile.getString("nationality"));
            if(myprofile.getString("gender").equals("F")) {
                radioFmale.setChecked(true);
            }
            else{
                radioMale.setChecked(true);
            }


        } catch (JSONException e) {
            e.printStackTrace();
        }
        final Button editbutton = (Button)findViewById(R.id.editbutton);
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

                if(lock == true){
                    editbutton.setText("Update");
                }
                else{
                    editbutton.setText("EDIT PROFILE");
                }
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
