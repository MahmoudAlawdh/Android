package com.example.mhd.donor;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Base64;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;

import static com.example.mhd.donor.R.id.imageView;

public class ProfileActivity extends AppCompatActivity {

    static final int REQUEST_IMAGE_CAPTURE = 1;
    boolean lock=true;
    public final static String Filee ="donor";
    public final static String profile ="profile";
    JSONObject myprofile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        SharedPreferences preferences = getSharedPreferences(Filee, MODE_PRIVATE);
        final String p = preferences.getString(profile, "notfound");
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
        ImageView profileimage = (ImageView)findViewById(R.id.profileimage);
        final EditText textPhone = (EditText) findViewById(R.id.textPhone);
        try {
            myprofile = new JSONObject(p);
            textname.setText(myprofile.getString("firstName") + " " + myprofile.getString("lastName"));
            textemail.setText(myprofile.getString("email"));
            textCivil.setText(myprofile.getString("civilId"));
            textPassword.setText(myprofile.getString("password"));
            textblood.setText(myprofile.getString("bloodType"));
            textBirth.setText(myprofile.getString("birthDate"));
            textNationalty.setText(myprofile.getString("nationality"));
            textPhone.setText(myprofile.getString("phoneNumber"));
            Picasso.with(ProfileActivity.this).load(myprofile.getString("imgURL")).into(profileimage);

            if (myprofile.getString("gender").equals("F")) {
                radioFmale.setChecked(true);
            } else {
                radioMale.setChecked(true);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        final Button editbutton = (Button) findViewById(R.id.editbutton);
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

                if (lock == true) {
                    editbutton.setText("Update");
                    lock = !lock;
                } else {
                    editbutton.setText("EDIT PROFILE");
                    final RequestQueue queue= Connection.getInstance().getRequestQueue(ProfileActivity.this);
                    try {

                        JSONObject req = new JSONObject();
                        String names[] = textname.getText().toString().split(" ");
                        req.put("firstName",names[0]);
                        req.put("lastName",names[1]);
                        req.put("email",textemail.getText().toString());
                        req.put("civilId",textCivil.getText().toString());
                        req.put("password",textPassword.getText().toString());
                        req.put("bloodType",textblood.getText().toString());
                        req.put("birthDate",textBirth.getText().toString());
                        req.put("nationality",textNationalty.getText().toString());//textNationalty.setText(myprofile.getString("nationality"));
                        req.put("phoneNumber",textPhone.getText().toString());//textPhone.setText(myprofile.getString("phoneNumber"));
                        req.put("donorId",myprofile.getInt("donorId"));
                        if (radioFmale.isChecked()) {
                            req.put("gender","F");
                        } else {
                            req.put("gender","M");
                        }
                        req.put("deleted",0);
                        req.put("status",true);
                        String url="http://34.196.107.188:8081/MhealthWeb/webresources/donor/"+myprofile.getString("donorId");
                        System.out.println(req.toString());
                        final JsonObjectRequest Jr = new JsonObjectRequest(Request.Method.PUT, url, req, new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {

                                    Toast.makeText(ProfileActivity.this, "Updated", Toast.LENGTH_SHORT).show();

                            }
                        }, new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Toast.makeText(ProfileActivity.this, "Error", Toast.LENGTH_SHORT).show();
                            }
                        });
                        queue.add(Jr);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                lock = !lock;
                }
            }
        });


        profileimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
                    startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
                }

            }
        });





    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            final Bitmap imageBitmap = (Bitmap) extras.get("data");
            ImageView profileimage = (ImageView)findViewById(R.id.profileimage);
            profileimage.setImageBitmap(imageBitmap);
            final JSONObject req = new JSONObject();
            try {

                req.put("appID", "donor");
                req.put("imgData", encodeToBase64(imageBitmap, Bitmap.CompressFormat.PNG    , 0 ));




                final RequestQueue queue = Volley.newRequestQueue(ProfileActivity.this);
                StringRequest Jr = new StringRequest(Request.Method.POST, "http://34.196.107.188:8081/MhealthWeb/addimg", new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        System.out.println(response);
                            Toast.makeText(ProfileActivity.this, response, Toast.LENGTH_SHORT).show();
                            try {
                                JSONObject res = new JSONObject(response);
                                updateprofile(res.getString("imgPath"));
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }


                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        System.out.println(error.toString());
                    }
                }){
                    @Override
                    public byte[] getBody() throws AuthFailureError {
                        String s = "appID=donor&imgData="+encodeToBase64(imageBitmap, Bitmap.CompressFormat.PNG, 0);

                        return s.getBytes();
                    }
                };
                queue.add(Jr);

            } catch (JSONException e) {
                e.printStackTrace();
            }


        }
    }
    public void updateprofile(String url) throws JSONException {

        myprofile.put("imgURL",url);
        final RequestQueue queue = Volley.newRequestQueue(ProfileActivity.this);
        String urll="http://34.196.107.188:8081/MhealthWeb/webresources/donor/"+myprofile.getString("donorId");

        final JsonObjectRequest Jr = new JsonObjectRequest(Request.Method.PUT, urll, myprofile, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                Toast.makeText(ProfileActivity.this, "Updated", Toast.LENGTH_SHORT).show();

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(ProfileActivity.this, "Error", Toast.LENGTH_SHORT).show();
            }
        });
        queue.add(Jr);


    }

    public static String encodeToBase64(Bitmap image, Bitmap.CompressFormat compressFormat, int quality)
    {
        ByteArrayOutputStream byteArrayOS = new ByteArrayOutputStream();
        image.compress(compressFormat, quality, byteArrayOS);
        return Base64.encodeToString(byteArrayOS.toByteArray(), Base64.DEFAULT);
    }








    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        this.finish();
        return super.onOptionsItemSelected(item);
    }


}
