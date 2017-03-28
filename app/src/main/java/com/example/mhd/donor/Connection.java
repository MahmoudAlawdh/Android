package com.example.mhd.donor;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by mhd on 3/28/17.
 */

class Connection {
    private RequestQueue requestQueue;
    private static final Connection ourInstance = new Connection();

    static Connection getInstance() {
        return ourInstance;
    }

    private Connection() {
    }
    public  RequestQueue getRequestQueue(Context context) {

        if(requestQueue==null)
            requestQueue= Volley.newRequestQueue(context);


        return requestQueue;
    }
}
