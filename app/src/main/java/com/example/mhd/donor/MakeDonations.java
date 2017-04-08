package com.example.mhd.donor;


import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.google.android.gms.common.data.DataBufferUtils;
import com.google.gson.JsonObject;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Date;


/**
 * A simple {@link Fragment} subclass.
 */
public class MakeDonations extends Fragment {


    public MakeDonations() {
        // Required empty public constructor
    }
    public final static String Filee ="donor";
    public final static String profile ="profile";
    JSONArray branches = new JSONArray();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vv = inflater.inflate(R.layout.fragment_make_donations, container, false);


        TextView InstructionForDonation = (TextView) vv.findViewById(R.id.text_donation);

        InstructionForDonation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), StaticInfoFragment.class);
                startActivity(i);
            }
        });

        final Spinner donationType = (Spinner) vv.findViewById(R.id.spinnerSelectDonationType);
        final ArrayList<String> model = new ArrayList<>();

        model.add("Select Donation Type");
        model.add("Blood Cells");
        model.add("Platelets");

        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, model);
        donationType.setAdapter(adapter);
        final Spinner branchType = (Spinner) vv.findViewById(R.id.spinnerBranches);
        final ArrayList<String> model1 = new ArrayList<>();







        final ArrayAdapter<String> adapterr = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, model1);
        final RequestQueue queue= Connection.getInstance().getRequestQueue(getActivity());
        final String url="http://34.196.107.188:8081/MhealthWeb/webresources/bbbranch";

        final StringRequest Jr= new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray JA = new JSONArray(response);
                    model1.add("Select Branch");
                    for(int i = 0; i < JA.length();i++){
                        JSONObject JO = (JSONObject) JA.get(i);
                        branches.put(JO);
                        model1.add(JO.getString("branchNameEn"));
                    }
                    adapterr.notifyDataSetChanged();
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
        branchType.setAdapter(adapterr);

//
//
//
//        donationType.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(getActivity(), model.get(position), Toast.LENGTH_SHORT).show();
//            }
//        });
//
        final EditText date = (EditText) vv.findViewById(R.id.editTextDate);

        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {


                DatePickerDialog d = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                        Toast.makeText(getActivity(), year + "/" + month + "/" + dayOfMonth, Toast.LENGTH_SHORT).show();

                        date.setText(year + "/" + month + "/" + dayOfMonth);


                    }
                }, 2017, 3, 30);

                d.show();
            }
        });


        final EditText time = (EditText) vv.findViewById(R.id.editTextTime);

        time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {


                TimePickerDialog d = new TimePickerDialog(getActivity(), new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        time.setText(hourOfDay + ":" + minute);
                    }
                }, 12, 0, false);

                d.show();
            }
        });

        Button confirm = (Button) vv.findViewById(R.id.confirmButton);
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(donationType.getSelectedItem().toString().equals("Blood Cells")){






























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
                        req.put("period",1);

                        SharedPreferences preferences = getActivity().getSharedPreferences(Filee, getActivity().MODE_PRIVATE);
                        final String p = preferences.getString(profile, "notfound");
                        JSONObject profile = new JSONObject(p);
                        req.put("regUserId",profile.getInt("donorId"));
                        req.put("siteUserId",0);
                        System.out.println(req.toString());
                        final JsonObjectRequest Jr = new JsonObjectRequest(Request.Method.POST, "http://34.196.107.188:8081/MhealthWeb/webresources/schedule", req, new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {

                                Toast.makeText(getActivity(), response.toString(), Toast.LENGTH_SHORT).show();

                            }
                        }, new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {

                            }
                        });
                        queue.add(Jr);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }


            }
        });
        return vv;

    }
}


