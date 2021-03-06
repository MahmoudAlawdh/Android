package com.example.mhd.donor;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class LoginActivity extends AppCompatActivity {
    public final static String Filee ="donor";
    public final static String profile ="profile";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button b = (Button)findViewById(R.id.Login);
        Button bsign = (Button) findViewById(R.id.Sign_up);
        TextView forget = (TextView) findViewById(R.id.FP);

        bsign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                
                Intent i = new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(i);
            }
        });

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String url="http://34.196.107.188:8081/MhealthWeb/webresources/donor/login";

                final RequestQueue queue= Connection.getInstance().getRequestQueue(LoginActivity.this);
                try {
                    EditText email = (EditText) findViewById(R.id.Emaillll);
                    EditText password = (EditText) findViewById(R.id.Password);
                    JSONObject req = new JSONObject("{" + "username:"+email.getText().toString()+","+"password:"+password.getText().toString()+
                            "}");
                    final JsonObjectRequest Jr = new JsonObjectRequest(Request.Method.POST, url, req, new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            try {
                                if(!response.getString("errorMsgEn").equals("Error")){

                                   String s = response.getJSONObject("items").toString();
                                    JSONObject dp = new JSONObject(s);
                                    Toast.makeText(LoginActivity.this, "Welcome "+ dp.getString("firstName") +" "+dp.getString("lastName") , Toast.LENGTH_SHORT).show();
                                    SharedPreferences preferences=getSharedPreferences(Filee,MODE_PRIVATE);
                                    SharedPreferences.Editor editor=preferences.edit();
                                    editor.putString(profile,s);
                                    editor.commit();
                                    Intent i = new Intent(LoginActivity.this,HomeActivity.class);
                                    startActivity(i);
                                }else{
                                    Toast.makeText(LoginActivity.this, R.string.wrongemailpass, Toast.LENGTH_SHORT).show();
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                                Toast.makeText(LoginActivity.this, R.string.noemailpass, Toast.LENGTH_SHORT).show();
                            }
                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {

                            Toast.makeText(LoginActivity.this, "No connection", Toast.LENGTH_SHORT).show();
                        }
                    });
                    queue.add(Jr);

                } catch (JSONException e) {
                    e.printStackTrace();
                    Toast.makeText(LoginActivity.this, R.string.noemailpass, Toast.LENGTH_SHORT).show();
                }

            }
        });

        forget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, ForgetPassActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onBackPressed() {
    }
}
