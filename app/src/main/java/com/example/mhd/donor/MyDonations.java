package com.example.mhd.donor;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;


/**
 * A simple {@link Fragment} subclass.
 */
public class MyDonations extends Fragment {

    public final static String Filee ="donor";
    public final static String profile ="profile";
    public MyDonations() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_my_donations, container, false);

        ListView lv = (ListView) v.findViewById(R.id.ListView);

        final ArrayList<MyAppointmentModel> model= new ArrayList<>();
        final MyAppointmentAdapter myv = new MyAppointmentAdapter(model,getActivity());
        String url="http://34.196.107.188:8081/MhealthWeb/webresources/donationrecord";

        final RequestQueue queue= Connection.getInstance().getRequestQueue(getContext());

        final StringRequest stringRequest=new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray a = new JSONArray(response);

                    SharedPreferences preferences = getActivity().getSharedPreferences(Filee, getActivity().MODE_PRIVATE);
                    final String p = preferences.getString(profile, "notfound");
                    JSONObject profile = new JSONObject(p);

                    for(int i = 0 ; i < a.length() ; i++){
                        JSONObject o = a.getJSONObject(i);
                        String civilId = profile.getString("civilId");
                        if( o.getString("status").toLowerCase().equals("accepted") &&  civilId.equals(o.getInt("donorCivilid")+"")) {
                            model.add(new MyAppointmentModel(o.getInt("donationId"), o.getInt("donorCivilid"), fixdate(o.getString("ddate")), o.getString("donationdestination"), o.getString("dnbloodtype")));
                            myv.notifyDataSetChanged();
                        }
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                } catch (ParseException e) {
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
    public String fixdate(String date) throws ParseException {
        DateFormat format  = new SimpleDateFormat("yyyy-mm-dd", Locale.ENGLISH);
        SimpleDateFormat fmtOut = new SimpleDateFormat("EEE, MMM d, ''yy");
        Date d = null;
        try {
            d = format.parse(date);
            //"EEE, MMM d, ''yy"

        } catch (ParseException e) {
            e.printStackTrace();
        }

        return fmtOut.format(d);
    }
}
