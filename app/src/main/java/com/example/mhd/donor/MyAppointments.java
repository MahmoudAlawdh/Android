package com.example.mhd.donor;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class MyAppointments extends Fragment {


    public MyAppointments() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_my_appointments, container, false);

        ListView lv = (ListView) v.findViewById(R.id.AppointmentListview);

        final ArrayList<MyAppointmentModel> model= new ArrayList<>();
        final MyAppointmentAdapter myv = new MyAppointmentAdapter(model,getActivity());
        String url="http://34.196.107.188:8080/mHealthWS/ws/donationrecord";

        final RequestQueue queue= Connection.getInstance().getRequestQueue(getContext());

        final StringRequest stringRequest=new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray a = new JSONArray(response);
                    for(int i = 0 ; i < a.length() ; i++){

                        JSONObject o = a.getJSONObject(i);
                        if( o.getString("status").toLowerCase().equals("pending") ) {
                            model.add(new MyAppointmentModel(o.getInt("donationId"), o.getInt("donorCivilid"), o.getString("ddate"), o.getString("donationdestination"), o.getString("dnbloodtype")));
                            myv.notifyDataSetChanged();
                        }
                    }
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








        lv.setAdapter(myv);




        return v;
    }

}
