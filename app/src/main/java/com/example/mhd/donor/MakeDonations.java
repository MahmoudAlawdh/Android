package com.example.mhd.donor;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
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
import java.util.ArrayList;
/**
 * A simple {@link Fragment} subclass.
 */
public class MakeDonations extends Fragment {
    public final static String Filee ="donor";
    public final static String profile ="profile";
    JSONArray branches = new JSONArray();
    public MakeDonations() {
        // Required empty public constructor
    }

    public ArrayAdapter<String> adaptersetup(String[] list,String start){
        ArrayList<String> model = new ArrayList<>();
        model.add(start);
        for(String s :list){
            model.add(s);
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, model);
        return adapter;
    }

    public void Instructions(View vv){
        TextView InstructionForDonation = (TextView) vv.findViewById(R.id.text_donation);
        InstructionForDonation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), StaticInfoFragment.class);
                startActivity(i);
            }
        });

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View vv = inflater.inflate(R.layout.fragment_make_donations, container, false);
        Instructions(vv);
        final Spinner donationType = (Spinner) vv.findViewById(R.id.spinnerSelectDonationType);
        final Spinner peroids = (Spinner) vv.findViewById(R.id.spinnerperiod);
        final Spinner branchType = (Spinner) vv.findViewById(R.id.spinnerBranches);
        final TextView date = (TextView) vv.findViewById(R.id.editTextDate);
        Button confirm = (Button) vv.findViewById(R.id.confirmButton);



        peroids.setAdapter(adaptersetup(new String[]{"8 AM - 10 AM", "10 AM - 12 PM", "12 PM - 2 PM", "2 PM - 4 PM"},"Select peroid"));
        donationType.setAdapter(adaptersetup(new String[]{"Blood Cells","Platelets"},"Select Donation Type"));

        final RequestQueue queue= Connection.getInstance().getRequestQueue(getActivity());
        final String url="http://34.196.107.188:8081/MhealthWeb/webresources/bbbranch";
        final StringRequest Jr= new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray JA = new JSONArray(response);
                    String[] data= new String[JA.length()];

                    for(int i = 0; i < JA.length();i++){
                        JSONObject JO = (JSONObject) JA.get(i);
                        branches.put(JO);
                        data[i] = JO.getString("branchNameEn");
                    }
                    branchType.setAdapter(adaptersetup(data,"Select Brach"));

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        queue.add(Jr);
        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {


                DatePickerDialog d = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        date.setText(year + "/" + (month+1) + "/" + dayOfMonth);
                    }
                }, 2017, 3, 30);
                d.show();
            }
        });

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if(donationType.getSelectedItem().toString().equals("Blood Cells")){
                    try {
                        JSONObject req = new JSONObject();
                        SharedPreferences preferences = getActivity().getSharedPreferences(Filee, getActivity().MODE_PRIVATE);
                        final String p = preferences.getString(profile, "notfound");
                        JSONObject profile = new JSONObject(p);
                        String day[] = date.getText().toString().split("/");
                        if(day[1].length() == 1){
                            day[1] = 0+day[1];
                        }
                        req.put("ddate",day[0]+"-"+day[1]+"-"+day[2]+"T00:00:00Z");
                        req.put("dnbloodtype",profile.getString("bloodType"));
                        req.put("donationdestination","bank");
                        req.put("donorCivilid",profile.getString("civilId"));
                        req.put("status","pending");

                        if(!req.getString("ddate").equals("")){
                            System.out.println(req.toString());
                        final JsonObjectRequest Jr = new JsonObjectRequest(Request.Method.POST, "http://34.196.107.188:8081/MhealthWeb/webresources/donationrecord", req, new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {

                                Toast.makeText(getActivity(), "Done", Toast.LENGTH_SHORT).show();
                            }
                        }, new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Toast.makeText(getActivity(), "Done", Toast.LENGTH_SHORT).show();
                            }
                        });
                        queue.add(Jr);
                        }else{
                            Toast.makeText(getActivity(), "Error", Toast.LENGTH_SHORT).show();
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
                else if(donationType.getSelectedItem().toString().equals("Platelets")){

                    try {
                        JSONObject req = new JSONObject();
                        for(int i =0 ; i < branches.length();i++){
                            JSONObject JO = (JSONObject) branches.get(i);
                            if(JO.getString("branchNameEn").equals(branchType.getSelectedItem().toString())){
                                req.put("branchId",JO.getInt("branchId"));
                            }
                        }
                        String day[] = date.getText().toString().split("/");
                        if(day[1].length() == 1){
                            day[1] = 0+day[1];
                        }
                        req.put("day",day[0]+"-"+day[1]+"-"+day[2]+"T00:00:00Z");
                        req.put("isActive",1);
                        req.put("isPast",0);
                        req.put("isRegisteredUser",1);
                        req.put("period",peroids.getSelectedItemPosition());


                        SharedPreferences preferences = getActivity().getSharedPreferences(Filee, getActivity().MODE_PRIVATE);
                        final String p = preferences.getString(profile, "notfound");
                        JSONObject profile = new JSONObject(p);
                        req.put("regUserId",profile.getString("donorId"));
                        req.put("siteUserId",0);
                        System.out.println(req.toString());
                        if(!req.getString("day").equals("") && !req.getString("branchId").equals("")){

                        final JsonObjectRequest Jr = new JsonObjectRequest(Request.Method.POST, "http://34.196.107.188:8081/MhealthWeb/webresources/schedule", req, new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {

                                Toast.makeText(getActivity(), "Done", Toast.LENGTH_SHORT).show();

                            }
                        }, new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Toast.makeText(getActivity(), "Done", Toast.LENGTH_SHORT).show();
                            }
                        });
                        queue.add(Jr);
                        }
                        else{
                            Toast.makeText(getActivity(), "Error", Toast.LENGTH_SHORT).show();
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
                donationType.setSelection(0);
                branchType.setSelection(0);
                date.setText("");
                peroids.setSelection(0);

            }

        });
        return vv;
    }



}


