package com.example.mhd.donor;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONException;
import org.json.JSONObject;

public class Register2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register2);

        Button submit = (Button) findViewById(R.id.submit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "http://34.196.107.188:8081/MhealthWeb/webresources/donor";

                final RequestQueue queue = Connection.getInstance().getRequestQueue(Register2Activity.this);
                try {
                    boolean flag = false;
                    JSONObject profile = new JSONObject();
                    profile.put("email", getIntent().getStringExtra("email"));
                    profile.put("password", getIntent().getStringExtra("password"));
                    profile.put("firstName", ((EditText) findViewById(R.id.first_name)).getText().toString());
                    profile.put("lastName", ((EditText) findViewById(R.id.last_name)).getText().toString());

                    if (((RadioButton) findViewById(R.id.radioFemalere)).isChecked()) {
                        profile.put("gender", "F");
                    } else {
                        profile.put("gender", "M");
                    }
                    profile.put("nationality", "K");
                    profile.put("deleted", 0);
                    profile.put("civilId", ((EditText) findViewById(R.id.civil_id)).getText().toString());
                    profile.put("phoneNumber", ((EditText) findViewById(R.id.phone)).getText().toString());
                    profile.put("status", true);
                    profile.put("birthDate", "2017-01-01T00:00:00Z");
                    profile.put("bloodType", "O");
                    if(profile.getString("email").equals("")||profile.getString("password").equals("")||
                    profile.getString("firstName").equals("")|| profile.getString("lastName").equals("")||
                    profile.getString("gender").equals("")|| profile.getString("civilId").equals("")||
                    profile.getString("phoneNumber").equals("")
                    ){
                        flag =true;
                    }
                    if(flag == true) {
                        final JsonObjectRequest Jr = new JsonObjectRequest(Request.Method.POST, url, profile, new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {
                                try {
                                    if (!response.getString("errorMsgEn").equals("Error")) {
                                        Toast.makeText(Register2Activity.this, response.toString(), Toast.LENGTH_SHORT).show();
                                    }
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                        }, new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Toast.makeText(Register2Activity.this, "error", Toast.LENGTH_SHORT).show();
                            }
                        });
                        queue.add(Jr);
                    }
                    else{
                        Toast.makeText(Register2Activity.this, "Some fields are missing", Toast.LENGTH_SHORT).show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
        Button backbutton = (Button) findViewById(R.id.back);
        backbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Register2Activity.this,LoginActivity.class);
                startActivity(intent);
            }
        });
    }

    }
