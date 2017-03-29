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
public class Campaigns extends Fragment {


    public Campaigns() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_campaigns, container, false);

        ListView lv = (ListView) v.findViewById(R.id.CampaingListview);

        final ArrayList<CampaignModel> model= new ArrayList<>();
        final CampaignAdapter myv = new CampaignAdapter(model,getActivity());
        lv.setAdapter(myv);
        //   llate = 29.3640416;
        // llong = 47.9814006;
        String url="http://34.196.107.188:8080/mHealthWS/ws/newcallfordonation";

        final RequestQueue queue= Connection.getInstance().getRequestQueue(getContext());

        final StringRequest stringRequest=new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray a = new JSONArray(response);
                    for(int i = 0 ; i < a.length() ; i++){
                        JSONObject o = a.getJSONObject(i);
                        if( o.getString("status").toLowerCase().equals("active") ){
                            model.add(new CampaignModel(o.getInt("CFDId"),o.getString("name"),o.getString("startdate"),o.getString("enddate"),o.getString("locationName"),
                                    o.getString("LLat"),o.getString("LLong"),o.getString("bloodTypes")));
                            Toast.makeText(getContext(), o.getString("status"), Toast.LENGTH_SHORT).show();
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



        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(getActivity(),Campaign_Details.class);
                i.putExtra("Name",model.get(position).getName());
                i.putExtra("StartDate",model.get(position).getStartDate());
                i.putExtra("EndDate",model.get(position).getEndDate());
                i.putExtra("LocationName",model.get(position).getLocationName());
                i.putExtra("LLate",model.get(position).getLLate());
                i.putExtra("LLong",model.get(position).getLLong());
                i.putExtra("BloodType",model.get(position).getBloodType());
                startActivity(i);
            }
        });



        return v;
    }

}
