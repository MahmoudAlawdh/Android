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
                final RequestQueue queue= Connection.getInstance().getRequestQueue(ForgetPassActivity.this);

                final StringRequest stringRequest=new StringRequest(Request.Method.GET, "http://34.196.107.188:8081/MhealthWeb/webresources/donor/reset/" + editText.getText().toString(), new Response.Listener<String>() {
                  @Override
                  public void onResponse(String response) {
                      try {
                          JSONObject o = new JSONObject(response);
                          Toast.makeText(ForgetPassActivity.this,o.getString("errorMsgEn") , Toast.LENGTH_SHORT).show();
                      } catch (JSONException e) {
                          e.printStackTrace();
                      }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        queue.add(stringRequest);
            }
        });



    }
}
