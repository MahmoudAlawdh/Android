package com.example.mhd.donor;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class AboutUs extends Fragment {

Button donateGo;
    public AboutUs() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final FragmentM f = FragmentM.getInstance();
        final FragmentManager fm=getActivity().getSupportFragmentManager();
        View v = inflater.inflate(R.layout.fragment_about_us, container, false);



        return v;
    }


}
