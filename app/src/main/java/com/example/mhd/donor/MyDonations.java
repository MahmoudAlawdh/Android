package com.example.mhd.donor;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class MyDonations extends Fragment {


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

        model.add(new MyAppointmentModel(1,1,"2017/9/15","manayr hussain","O-"));
        model.add(new MyAppointmentModel(1,1,"2017/10/5","mariam jassim","AB-"));
        model.add(new MyAppointmentModel(1,1,"2017/11/5","mohammad","O+"));
        model.add(new MyAppointmentModel(1,1,"2017/2/13","yahya","O-"));
        model.add(new MyAppointmentModel(1,1,"2017/4/25","essa jawad","AB-"));
        model.add(new MyAppointmentModel(1,1,"2017/2/17","Rashid habeb","B+"));






        MyAppointmentAdapter myv = new MyAppointmentAdapter(model,getActivity());


        lv.setAdapter(myv);




        return v;
    }

}
