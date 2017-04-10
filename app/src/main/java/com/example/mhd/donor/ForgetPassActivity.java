package com.example.mhd.donor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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

import java.text.ParseException;

public class ForgetPassActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_pass);


        Button b = (Button) findViewById(R.id.button3);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final EditText editText = (EditText) findViewById(R.id.editText);
                final EditText civil = (EditText) findViewById(R.id.civilIDEdit);
                final RequestQueue queue= Connection.getInstance().getRequestQueue(ForgetPassActivity.this);
                if(editText.getText().toString().contains("@") && editText.getText().toString().contains("."))
                {
                    JSONObject req = new JSONObject();
                    try {
                        req.put("username",editText.getText().toString());
                        req.put("civilid",civil.getText().toString());

                        final JsonObjectRequest Jr = new JsonObjectRequest(Request.Method.POST, "http://34.196.107.188:8081/MhealthWeb/webresources/donor/reset/", req, new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {
                                Toast.makeText(ForgetPassActivity.this, "password channged", Toast.LENGTH_SHORT).show();
                            }
                        }, new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Toast.makeText(ForgetPassActivity.this, "Error", Toast.LENGTH_SHORT).show();
                            }
                        });
                        queue.add(Jr);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
                else {
                    Toast.makeText(ForgetPassActivity.this, R.string.wrongemail, Toast.LENGTH_SHORT).show();
                }
            }
        });



    }
}
