package com.example.mhd.donor;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

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

        model.add(new MyAppointmentModel(1,1,"2017/3/5","Ahmad abbas","O+"));
        model.add(new MyAppointmentModel(1,1,"2017/4/9","Mustafa khalid","A-"));
        model.add(new MyAppointmentModel(1,1,"2017/5/8","abbas soad","AB+"));
        model.add(new MyAppointmentModel(1,1,"2019/1/9","Aziz yosif","A+"));
        model.add(new MyAppointmentModel(1,1,"2017/6/5","fahad mohammad","B-"));
        model.add(new MyAppointmentModel(1,1,"2017/7/15","fatma kasim","B+"));
        model.add(new MyAppointmentModel(1,1,"2017/9/15","manayr hussain","O-"));
        model.add(new MyAppointmentModel(1,1,"2017/10/5","mariam jassim","AB-"));
        model.add(new MyAppointmentModel(1,1,"2017/11/5","mohammad","O+"));
        model.add(new MyAppointmentModel(1,1,"2017/2/13","yahya","O-"));
        model.add(new MyAppointmentModel(1,1,"2017/4/25","essa jawad","AB-"));
        model.add(new MyAppointmentModel(1,1,"2017/2/17","Rashid habeb","B+"));
        model.add(new MyAppointmentModel(1,1,"2017/5/16","Abdurahmman mohammad","B+"));
        model.add(new MyAppointmentModel(1,1,"2017/6/19","walled khalid","A+"));
        model.add(new MyAppointmentModel(1,1,"2017/7/21","jax jonson","AB-"));
        model.add(new MyAppointmentModel(1,1,"2017/9/27","alex bin","O-"));





        MyAppointmentAdapter myv = new MyAppointmentAdapter(model,getActivity());


        lv.setAdapter(myv);




        return v;
    }

}
